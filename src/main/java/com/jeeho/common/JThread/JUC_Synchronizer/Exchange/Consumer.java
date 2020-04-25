package com.jeeho.common.JThread.JUC_Synchronizer.Exchange;

import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

    final Exchanger<Produce.Message> exchanger;

    public Consumer(Exchanger<Produce.Message> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true){
            Produce.Message message = new Produce.Message(null);
            try {
                message = exchanger.exchange(message);
                System.out.println("消费者接受到数据：" + message.getV());
                message.setV(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Exchanger<Produce.Message> exchanger = new Exchanger<>();
        Thread t1 = new Thread(new Consumer(exchanger),"消费者线程");
        Thread t2 = new Thread(new Produce(exchanger),"消费者线程");
        t1.start();
        t2.start();
    }
}
