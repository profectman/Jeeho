package com.jeeho.common.base.File;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 流文件 输入/输出
 * DataInputStream --> BufferedInputStream --> FileInputStream
 * DataOutputStream --> BufferedOutputStream --> FileOutputStream
 * PrintWriter --> BufferedWriter --> FileWriter
 * PrintReader --> BufferedReader --> FileReader
 */
public class Input_OutputStream {

    /**
     * 一.缓冲流输入文件    BufferedReader  FileReader
     * @param filenamme
     * @return
     * @throws IOException
     */
    public static String read(String filenamme) throws IOException {
        BufferedReader bin = new BufferedReader(new FileReader(filenamme));
        StringBuilder sb = new StringBuilder();
        String s ;
        while((s = bin.readLine()) != null){
            sb.append(s);
        }
        bin.close();
        return sb.toString();
    }

    /**
     * 从内存输入
     * StringReader   sr.read()
     */
    public static void memoryInput(){
        try {
            StringReader sr = new StringReader(read("Input_OutputStream"));
            int c;
            while((c = sr.read()) != -1){
                System.out.println((char)c);
            }
            sr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * DataInputStream先流中读取基本数据类型的数据
     * dis.available() 在没有阻塞的情况下所能读取的字节数
     * @throws IOException
     */
    public static void formattedMemoryInput() throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(read("Input_OutputStream.java").getBytes()));
        while(true)
            System.out.println((char)dis.readByte());
    }

    /**
     * 基本文件输入
     * 缓冲可以显著的提高I/O性能
     * @param file
     * @throws IOException
     */
    public void basicFileOutput(String file) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(read("Input_OutputStream.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = -1;
        String s;
        while((s = br.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        out.close();
    }

    /**
     * 使用DataInputStream/DataOutPutStream用于数据的存储和恢复
     * @throws IOException
     */
    public void storingAndRecoveringData() throws IOException {
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("note.txt")));
        dos.writeDouble(3.142);
        dos.writeUTF("That was pi");
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("note.txt")));
        System.out.println(dis.readDouble());
    }

    /**
     * 读取随机访问文件
     * @param file
     * @throws IOException
     */
    public static void usinngRandomAccessFile(String file) throws IOException {
        RandomAccessFile r = new RandomAccessFile(file, "r");
        for(int i=0;i<7;i++){
            r.readDouble();
        }
        r.close();
    }

    /**
     * java.nio中的通道和缓冲器
     * 只有三种流能生成通道 FileInputStream FileOutputStream RandomAccessFile
     * 使用ByteBuffer快速的传送大量数据
     * @param args
     * @throws IOException
     */
    public void channelCopy(String args) throws IOException {
        FileChannel in = new FileInputStream(args).getChannel();
        FileChannel out = new  FileOutputStream(args).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);   //使用allocate分配缓冲器
        while(in.read(buffer)!= -1){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    /**
     *  使用transferTo() transferForm()使用一个通道与另一个通道连接
     * @param args
     */
    public void TransferTo(String args) throws IOException {
        FileChannel in = new FileInputStream(args).getChannel();
        FileChannel out = new  FileOutputStream(args).getChannel();
        in.transferTo(0, in.size(),out);
    }


}
