package com.jeeho.common.JThread.JUC_Synchronizer.Phaser;

import java.util.concurrent.Phaser;

public class PhaserTest01  {

    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        for (int i=0; i < 10;i++){
            phaser.register();
            new Thread(new Task(phaser)).start();
        }
    }

    static class Task implements Runnable{

        private final Phaser phaser;


        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            int i = phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " :执行完当前任务，" +
                    "phaser ：" + i);
        }
    }
}
