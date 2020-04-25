package com.jeeho.common.JThread.JUC_Synchronizer.Phaser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Phaser;

public class PhaserTest02 {

    public static void main(String[] args) throws IOException {
        Phaser phaser = new Phaser(1);
        for (int i=0; i < 10 ;i++){
            phaser.register();
            new Thread(new Task(phaser),"Thread - " + i).start();
        }

        System.out.println("Press ENTER to welcome...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();

        phaser.arriveAndDeregister();
        System.out.println("主线程打开开关");
    }

    static class Task implements Runnable{

        private final Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            int i = phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + ": 任务执行完成，" +
                    "phaser :" + i);
        }
    }
}
