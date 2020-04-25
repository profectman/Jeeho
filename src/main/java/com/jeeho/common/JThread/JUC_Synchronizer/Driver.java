package com.jeeho.common.JThread.JUC_Synchronizer;


import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch同步计数器
 */
public class Driver {

    private final static int N = 10;

    public static void main(String[] args) {
        CountDownLatch downLatch = new CountDownLatch(1);
        for (int i=0; i < N ; i++){
            new Thread(new Worker(downLatch)).start();
        }
        //阻塞线程唤醒
        downLatch.countDown();
    }

    static class Worker implements Runnable{

        final CountDownLatch startSignal;

        Worker(CountDownLatch startSignal) {
            this.startSignal = startSignal;
        }


        @Override
        public void run() {
            try {
                //当前工作线程进入阻塞等待
                startSignal.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
