package com.jeeho.common.netty.nio.buffers;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferSlice {

    public static void main(String args[]){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i=0;i<buffer.capacity();i++){
            buffer.put((byte)i);
        }
        printBuffer(buffer);

        buffer.position(3).limit(7);

        printBuffer(buffer);

        ByteBuffer sliceBuffer = buffer.slice();
        for (int i=0;i<sliceBuffer.capacity();i++){
            byte b = sliceBuffer.get();
            b *=11;
            sliceBuffer.put(i,b);
        }
        printBuffer(buffer);

        buffer.position(0).limit(buffer.capacity());
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }

        printBuffer(buffer);
    }

    private static void printBuffer(Buffer buffer) {
        System.out.println("[limit=" + buffer.limit()
                +", position = " + buffer.position()
                +", capacity = " + buffer.capacity()
                +", array = " + buffer.toString()+"]");
    }
}
