package com.jeeho.common.JThread.ThreadCreator;

public class WelcomeApp {

    public static void main(String args[]){
        Thread welcomeThread = new WelcomeThread();
        welcomeThread.start();
        System.out.printf("1.Welcome! I`m %s.%n",Thread.currentThread().getName());
    }

    static class WelcomeThread extends Thread{
        @Override
        public void run() {
            System.out.printf("2.WelCome! I`m %s.%n",Thread.currentThread().getName());
        }
    }
}
