package com.jeeho.common.netty.nio.channels;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
    public static void main(String args[]) throws IOException {
        String infile = "log4j.properties";
        String outfile = "log4j.properties.copy";

        FileInputStream fin = new FileInputStream(infile);
        FileInputStream fout = new FileInputStream(outfile);

        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (true){
            buf.clear();

            int read = fcin.read(buf);

            if (read == -1){
                break;
            }

            buf.flip();

            fcout.write(buf);
        }
    }
}
