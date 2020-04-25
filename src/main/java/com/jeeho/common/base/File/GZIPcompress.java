package com.jeeho.common.base.File;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * bufferedReader --> inputStreamReader --> GZIPinputStream --> FileInputStream
 */
public class GZIPcompress {

    public static void main(String[] args) throws IOException {
        System.out.println("gzip file...");
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        int c;
        while((c = in.read()) != -1){
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("read gzip file...");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while((s = in2.readLine()) != null)
            System.out.println(s);
    }
}
