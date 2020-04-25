package com.jeeho.common.netty.sticky;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

public class StickyDemoDecoderHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf cache;
    private int frameLength;

    public StickyDemoDecoderHandler(int frameLength) {
        this.frameLength = frameLength;
    }

    static ByteBuf expandCache(ByteBufAllocator alloc,ByteBuf cache,int readable){
        ByteBuf oldCache = cache;
        cache = alloc.buffer(oldCache.readableBytes() + readable);
        cache.writeBytes(oldCache);
        oldCache.release();
        return cache;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf data = (ByteBuf) msg;
        try {
            if (cache == null){
                cache = ctx.alloc().buffer(1024);
            }else{
                if (cache.writerIndex() > cache.maxCapacity() - cache.readableBytes()){
                    cache = expandCache(ctx.alloc(),cache,data.readableBytes());
                }
            }
            cache.writeBytes(data);
            List<ByteBuf> output = new ArrayList<>();
            while(cache.readableBytes() >= frameLength){
                output.add(cache.readBytes(frameLength));
            }

            if (cache.isReadable()){
                cache.discardReadBytes();
            }

            for (int i =0;i<output.size();i++){
                ctx.fireChannelRead(output.get(i));
            }
        } finally {
            data.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
