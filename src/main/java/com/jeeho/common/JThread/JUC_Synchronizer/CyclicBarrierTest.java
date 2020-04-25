package com.jeeho.common.JThread.JUC_Synchronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏CyclicBarrier,当访问线程到达一定数量时，才会唤醒阻塞线程
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        int N = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("运动员全部准备就绪，开始起跑...");
            }
        });

        for (int i = 0; i<N;i++){
            Thread t = new Thread(new PrepareWork(cyclicBarrier),"运动员 [" + i + "]");
            t.start();
            if (i == 3)
                t.interrupt();
        }

        Thread.sleep(3000);
        System.out.println("Barrier 是否损坏：" + cyclicBarrier.isBroken());
    }

    static class  PrepareWork implements Runnable{

        private CyclicBarrier cyclicBarrier;

        public PrepareWork(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": 准备完成...");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                //判断当前栅栏是否已经损害，如果损害，则抛出BrokenBarrierException
                e.printStackTrace();
            }
        }
    }
}
