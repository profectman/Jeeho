package com.jeeho.common.netty.nio.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIOEchoClientHandler implements Runnable {

    private String host;
    private int port;

    private Selector selector;
    private SocketChannel socketChannel;

    private volatile boolean stop ;

    private ExecutorService executorService;

    public NIOEchoClientHandler(String host,int port){
        this.host = host;
        this.port = port;
        this.executorService  = Executors.newSingleThreadExecutor();

        try {
            selector = Selector.open();
            socketChannel= SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try {
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
            socketChannel.socket().bind(new InetSocketAddress(host,port));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it= selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null){
                            key.cancel();
                            if (key != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        if (selector != null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (executorService != null){
            executorService.shutdown();
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            SocketChannel sc = (SocketChannel)key.channel();
            if(key.isConnectable()){
                if(sc.finishConnect()){
                    System.out.println("连接到服务器......");
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    System.out.println("请输入消息[输入\"Quit\"]退出：");
                    //使用线程池循环处理用户输入消息
                    executorService.submit(()->{
                        while (true){
                            try {
                                buffer.clear();

                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                String msg = br.readLine();
                                if(msg.equals("Quit")){
                                    System.out.println("关闭客户端");
                                    key.cancel();
                                    sc.close();
                                    this.stop = true;
                                    break;
                                }

                                buffer.put(msg.getBytes());
                                buffer.flip();

                                sc.write(buffer);

                                //TODO:提示输入消息或退出
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    sc.register(selector,SelectionKey.OP_READ);
                }
            }else{
                System.exit(1);
            }

            if(key.isReadable()){
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = socketChannel.read(readBuffer);
                if(readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println(body);

                    if (body.equals("Quit")){
                        this.stop = true;
                    }
                }else if(readBytes < 0){
                    key.cancel();
                    sc.close();
                }else{}
            }
            if(key.isWritable()){
                //TODO:
            }
        }
    }
}
