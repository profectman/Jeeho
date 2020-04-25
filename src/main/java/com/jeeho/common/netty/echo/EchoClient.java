package com.jeeho.common.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class EchoClient {

    static final String HOST = System.getProperty("host","127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port","8040"));

    public static void main(String args[]) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast("framer",new DelimiterBasedFrameDecoder(8192,Delimiters.lineDelimiter()));
                            p.addLast("decoder",new StringDecoder());
                            p.addLast("encoder",new StringEncoder());
                            p.addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture f = b.bind(HOST,PORT).sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }
    }
}
