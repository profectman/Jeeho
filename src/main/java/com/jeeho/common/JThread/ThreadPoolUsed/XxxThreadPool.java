package com.jeeho.common.JThread.ThreadPoolUsed;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class XxxThreadPool {

    public static void main(String args[]){
        testScheduledThreadPool();
    }


    public static void testFixedThreadPool(){
        System.out.println("Main Thread : Starting at:" + new Date());
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0;i<10;i++){
            exec.execute(new Handle(String.valueOf(i)));
        }
        exec.shutdown();
        System.out.println("Main Thread : Finished at:" + new Date());
    }

    public static void testSingleThreadPool(){
        System.out.println("Main Thread : Starting at:" + new Date());
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0;i<10;i++){
            exec.execute(new Handle(String.valueOf(i)));
        }
        exec.shutdown();
        System.out.println("Main Thread : Finished at:" + new Date());
    }

    public static void testCachedThreadPool(){
        System.out.println("Main Thread : Starting at:" + new Date());
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0;i<10;i++){
            exec.execute(new Handle(String.valueOf(i)));
        }
        exec.shutdown();
        System.out.println("Main Thread : Finished at:" + new Date());
    }

    public static void testScheduledThreadPool(){
        System.out.println("Main Thread : Starting at:" + new Date());
        ScheduledThreadPoolExecutor exec = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        for (int i = 0;i<10;i++){
            exec.schedule(new Handle(String.valueOf(i)),10,TimeUnit.SECONDS);
        }
        exec.shutdown();
        while(!exec.isTerminated()){}
        System.out.println("Main Thread : Finished at:" + new Date());
    }
}
