package com.jeeho.common.base.File;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * zip 文件压缩与读取
 * FileOutputStream --> CheckedOutputStream  --> ZipOutputStream --> BufferedOutputStream
 * FileInputStream --> CheckedInputStream --> ZipInputStream --> BufferedInputStream
 * zos zis (setComment(),putNextEntry())
 * ZipFile (entries(),hasMoreElement(),nextElement())
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {
        System.out.println("zip file...");
        FileOutputStream fos = new FileOutputStream("test.zip");
        CheckedOutputStream cos = new CheckedOutputStream(fos, new Adler32()); //文件按数据计算以及校验 adler32 和crc
        ZipOutputStream zip = new ZipOutputStream(cos);
        BufferedOutputStream bos = new BufferedOutputStream(zip);
        zip.setComment("A test of Java Zipping");
        for(String s : args){
            BufferedReader in = new BufferedReader(new FileReader(s));
            zip.putNextEntry(new ZipEntry(s));
            int c;
            while((c = in.read()) != -1)
                bos.write(c);
            in.close();
            bos.flush();
        }
        bos.close();
        System.out.println("read zip file...");
        FileInputStream fis = new FileInputStream("test.zip");
        CheckedInputStream cis = new CheckedInputStream(fis, new Adler32());
        ZipInputStream zis = new ZipInputStream(cis);
        BufferedInputStream bis = new BufferedInputStream(zis);
        ZipEntry ze;
        while((ze = zis.getNextEntry())!=null){
            int x;
            while((x = bis.read())!=-1){
                System.out.println(x);
            }
        }
        bis.close();
        System.out.println("read zip file2...");
        ZipFile zf = new ZipFile("test.zip");
        Enumeration<? extends ZipEntry> entries = zf.entries();
        while (entries.hasMoreElements()){
            ZipEntry ze2 = entries.nextElement();
            System.out.println(ze2);
        }
    }
}
