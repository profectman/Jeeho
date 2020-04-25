package com.jeeho.common.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ByteProcessor;

import java.nio.charset.Charset;
import java.util.Random;

public class ByteBufExamples {

    private final static Random random = new Random();
    private static final ByteBuf BYTE_BUF_FROM_SOMEWHERE = Unpooled.buffer();

    public static void main(String args[]){

    }

    /**
     * byteBuf的简单创建与使用  set  get
     */
    public static void byteBufSetGet(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);
        System.out.println((char)buf.getByte(0));
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        System.out.println("readerIndex = " + readerIndex
                + ";writerIndex = " + writerIndex);
        buf.setByte(0,(byte)'B');
        System.out.println((char)buf.getByte(0));
        System.out.println("readerIndex = " + buf.readerIndex()
                + "writerIndex = " + writerIndex );
    }

    /**
     * ByteBuf 的简单创建 与使用 readByte  writeByte
     */
    public static void byteBufWriteRead(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks", utf8);
        System.out.println((char)buf.readByte());
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        System.out.println("readerIndex = " + readerIndex
                + "writerIndex = " + writerIndex );
        buf.writeByte((byte)'?');
        buf.readByte();
        System.out.print("readerIndex = " + readerIndex
                + "writerIndex = " + writerIndex);
    }

    public static void writeAndRead(){
        ByteBuf buffer = Unpooled.buffer(20);
        int i = 0 ;
        while(buffer.writableBytes() > 4){
            buffer.writeInt(i++);
        }
        while(buffer.isReadable()){
            System.out.println(buffer.readInt());
        }
    }

    public static void byteProcessor(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buffer = Unpooled.copiedBuffer("Netty\r in Action rocks! ", utf8);
        int index = buffer.forEachByte(ByteProcessor.FIND_CR);
    }

    public static void byteBufSlice(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);
        ByteBuf sliced = buf.slice(0,15);
        System.out.println(sliced.toString(utf8));
        buf.setByte(0,(byte)'J');
        System.out.println(sliced.toString(utf8));
    }

    public static void byteBufCopy(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);
        ByteBuf copy = buf.copy(0,15);
        System.out.println(copy.toString(utf8));
        buf.setByte(0,(byte)'J');
        System.out.println(copy.toString(utf8));
    }

    public static void byteBufComposite(){
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf headerBuf = Unpooled.copiedBuffer("Header" ,utf8);
        ByteBuf bodyBuf = Unpooled.copiedBuffer("This is body",utf8);
        messageBuf.addComponents(headerBuf,bodyBuf);
        for (ByteBuf buf : messageBuf){
            System.out.println(buf.toString());
        }

        messageBuf.removeComponent(0);
        for (ByteBuf buf : messageBuf){
            System.out.println(buf.toString());
        }
    }

    public static void heapBuffer(){
        ByteBuf heapBuf = Unpooled.buffer(16);
        if(heapBuf.hasArray()){
            int i = 0;
            while(heapBuf.writableBytes() > 0){
                heapBuf.writeByte(i++);
            }
            byte[] array = heapBuf.array();
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            int length = heapBuf.readableBytes();
            handleArray(array,offset,length);
        }
    }

    public static void directBuffer(){
        ByteBuf directBuf = Unpooled.directBuffer(16);
        if (!directBuf.hasArray()){
            int i = 0;
            while (directBuf.writableBytes() > 0){
                directBuf.writeByte(i++);
            }
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            handleArray(array,0,length);
        }
    }

    public static void byteBufCompositeArray(){
        CompositeByteBuf compBuf = Unpooled.compositeBuffer();
        int lenght = compBuf.readableBytes();
        byte[] array = new byte[lenght];
        compBuf.getBytes(compBuf.readerIndex(),array);
        handleArray(array,0,array.length);
    }

    private static void handleArray(byte[] array, int offset, int length) {
        for (int i = 0;i<length;i++){
            System.out.println(array[offset + i]);
        }
    }
}
