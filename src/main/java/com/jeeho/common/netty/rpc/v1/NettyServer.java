package com.jeeho.common.netty.rpc.v1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer {

    private final static Logger logger = LoggerFactory.getLogger(NettyServer.class);

    private Thread thread ;

    private final int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void start(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                EventLoopGroup boss = new NioEventLoopGroup();
                EventLoopGroup worker = new NioEventLoopGroup();
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(boss,worker)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {

                            }
                        });
            }
        });
    }

    public Thread getThread() {
        return thread;
    }

    public void stop(){
        if (thread != null && thread.isAlive()){
            thread.interrupt();
        }
        logger.info("接口服务端停止......");
    }
}
