package com.jeeho.common.base.File;

import java.io.File;
import java.io.IOException;

public class ProcessFile {

    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFile(Strategy strategy,String ext){
        this.strategy = strategy ;
        this.ext = ext;
    }

    public void start(String[] args){
        try {
            if(args.length == 0){
                processDirectoryTree(new File("."));
            }else{
                for(String arg : args){
                    File fileArg = new File(arg);
                    if(fileArg.isDirectory()){
                        processDirectoryTree(fileArg);
                    }else{
                        if(arg.endsWith("."+ext)){
                            arg += "."+ext;

                                strategy.process(new File(arg).getCanonicalFile());

                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for(File file : Directory.TreeInfo.walk(root.getAbsoluteFile(),".*\\."+ext))
            strategy.process(file.getCanonicalFile());
    }

    public static void main(String[] args){
        new ProcessFile(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },"java").start(args);
    }
}
