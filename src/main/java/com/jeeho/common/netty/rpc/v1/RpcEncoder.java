package com.jeeho.common.netty.rpc.v1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.springframework.core.serializer.Serializer;


public class RpcEncoder  extends MessageToByteEncoder<Object> {

    private Class<?> genericClass;
    private Serializer serializer;

    public RpcEncoder(Class<?> genericClass, Serializer serializer) {
        this.genericClass = genericClass;
        this.serializer = serializer;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        if (genericClass.isInstance(o)){
//            byte[] data = serializer.serialize(o,new ObjectOutputStream());
//            out.writeInt(data.length);
//            out.writeBytes(data);
        }
    }
}
