package com.jeeho.common.netty.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class EchoHandler  implements Runnable{

    private Selector selector;
    private ServerSocketChannel serverChannel;
    private volatile boolean stop;
    private int num = 0;

    public EchoHandler(int port){
        try{
            selector = Selector.open();
            serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress(port));
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            //TODO:打印
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        while(!stop){
            try{
                selector.select(1000);  //阻塞监听事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey key = null;
                while(iterator.hasNext()){
                    key = iterator.next();  //获取选择器事件
                    iterator.remove();  //将选择器中已经拿出的事件清除
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        //出现异常，将当前取出的事件取消处理
                        if (key != null){
                            key.cancel();
                            if (key.channel()!=null){
                                key.channel().close();
                            }
                        }
                    }
                }
            }catch (Throwable t){
                t.printStackTrace();
            }
        }
        //多路复用器关闭
        if (selector != null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()){  //判断当前连接事件是否有效
            if (key.isAcceptable()){ //判断当前连接事件准备接入一个新的连接
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = ssc.accept(); //获取当前请求连接的客户端请求事件
                socketChannel.configureBlocking(false);
                SelectionKey sk = socketChannel.register(selector, SelectionKey.OP_READ);//注册当前客户端连接，设置器为可读状态
                sk.attach(num++);
            }
            if (key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    //TODO:打印客户端发送来的数据到屏幕上

                    if (body.trim().equals("Quit")){
                        //TODO:答应关闭与客户端的连接
                        key.cancel();
                        sc.close();
                    }else{
                        //TODO:向连接客户端响应数据
                    }
                }else if (readBytes < 0){
                    key.channel();
                    sc.close();
                }else{}
            }
        }

    }

    public void stop(){
        this.stop = true;
    }
}
