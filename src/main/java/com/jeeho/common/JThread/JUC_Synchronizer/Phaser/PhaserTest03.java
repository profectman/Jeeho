package com.jeeho.common.JThread.JUC_Synchronizer.Phaser;

import java.util.concurrent.Phaser;

public class PhaserTest03 {

    public static void main(String[] args) {
        int repeat = 3;
        Phaser phaser = new Phaser(){
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("---------------PHASE[" + phase + "]," +
                        "Parties[" + registeredParties + "] ---------------");
                return phase + 1 >= repeat || registeredParties == 0;
            }
        };

        for (int i=0;i<10;i++){
            phaser.register();
            new Thread(new Task(phaser),"Thread - " + i).start();
        }
    }

    static class Task implements Runnable{

        private final Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            if (!phaser.isTerminated()){
                int i = phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + ":执行完成，" +
                        "phase： " + i);
            }
        }
    }
}
