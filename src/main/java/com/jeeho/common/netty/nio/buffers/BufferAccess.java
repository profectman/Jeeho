package com.jeeho.common.netty.nio.buffers;

import java.nio.ByteBuffer;

/**
 * Buffer的使用方式
 * put flip
 * get
 * clear
 */
public class BufferAccess {

    public static void main(String args[]){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        printBuffer(buffer);

        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'0');
        printBuffer(buffer);

        buffer.flip();
        printBuffer(buffer);

        System.out.println("" + (char)buffer.get() + (char)buffer.get());
        printBuffer(buffer);

        buffer.mark();
        printBuffer(buffer);

        buffer.mark();
        printBuffer(buffer);

        buffer.reset();
        printBuffer(buffer);

        buffer.compact();
        printBuffer(buffer);

        buffer.clear();
        printBuffer(buffer);
    }

    private static void printBuffer(ByteBuffer buffer) {
        System.out.println("[limit= "+buffer.limit()
                +",position = "+ buffer.position()
                +",capacity = "+ buffer.capacity()
                +",array = "+buffer.toString()
                +"]");
    }


}
