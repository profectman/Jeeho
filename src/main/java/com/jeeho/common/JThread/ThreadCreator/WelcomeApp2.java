package com.jeeho.common.JThread.ThreadCreator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * boolean cancel(boolean mayInterruptIfRunning);
 * Future.isCancelled()
 * V get(long timeout,TimeUnit unit) throws InterruptedException
 */
public class WelcomeApp2 {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        System.out.println("---程序开始运行---");
        Date date1 = new Date();
        int taskSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        List<Future> futures = new ArrayList<>();
        for(int i=0;i<taskSize;i++){
            Future f = pool.submit(new MyCallable(i+""));
            futures.add(f);
        }
        pool.shutdown();



        for (Future f : futures){
            System.out.println(">>>" + f.get().toString());
        }
    }

    /**
     * 创建一个带返回结果的线程任务
     */
    static class MyCallable implements Callable<Object>{

        private String taskNum;

        public MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(">>>" + taskNum + "任务启动...");
            Date dateTmp1 = new Date();
            Thread.sleep(1000);
            Date dateTmp2 = new Date();
            long time = dateTmp2.getTime() - dateTmp1.getTime();
            System.out.println(">>>" + taskNum + "任务终止");
            return taskNum + "任务返回运行结果，当前任务时间[ " + time + "]毫秒.";
        }
    }
}
