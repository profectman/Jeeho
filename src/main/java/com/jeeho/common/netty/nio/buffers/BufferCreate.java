package com.jeeho.common.netty.nio.buffers;

import java.nio.ByteBuffer;

/**
 * Buffer的四种创建方式
 * Capacity      数组容量
 * limit        代表还有多少个数据需要从数组中获取或还有多少空间可以来存储数据
 * position     如果是写入数据（代表下一个写入数据的位置） 如果是输出数据（代表下一个字节来自数组的哪一个元素）
 * remaining   是否有剩余
 */
public class BufferCreate {

    public static void main(String args[]){
        ByteBuffer buffer0 = ByteBuffer.allocate(10);
        if (buffer0.hasArray()) {
            System.out.println("buffer0 array: " + buffer0.array());
            System.out.println("Buffer0 array offset: " + buffer0.arrayOffset());

        }
        System.out.println("Capacity: " + buffer0.capacity());
        System.out.println("Limit: " + buffer0.limit());
        System.out.println("Position: " + buffer0.position());
        System.out.println("Remaining: " + buffer0.remaining());
        System.out.println();

        ByteBuffer buffer1 = ByteBuffer.allocateDirect(10);
        if (buffer1.hasArray()) {
            System.out.println("buffer1 array: " + buffer1.array());
            System.out.println("Buffer1 array offset: " + buffer1.arrayOffset());
        }
        System.out.println("Capacity: " + buffer1.capacity());
        System.out.println("Limit: " + buffer1.limit());
        System.out.println("Position: " + buffer1.position());
        System.out.println("Remaining: " + buffer1.remaining());
        System.out.println();

        byte[] bytes = new byte[10];
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes);

        byte[] bytes2 = new byte[10];
        ByteBuffer buffer3 = ByteBuffer.wrap(bytes, 2, 3);

    }
}
