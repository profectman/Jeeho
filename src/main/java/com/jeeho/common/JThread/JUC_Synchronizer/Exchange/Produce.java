package com.jeeho.common.JThread.JUC_Synchronizer.Exchange;

import java.io.Serializable;
import java.util.concurrent.Exchanger;

/**
 * 交换器，主要用于两个线程进行数据交换
 */
public class Produce implements Runnable {

    final Exchanger<Message> exchanger ;

    public Produce(Exchanger<Message> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i =0;i<3;i++){
            Message message = new Message();
            message.setV(String.valueOf(i));
            System.out.println("生产者生产数据：" + message.getV());
            try {
                Message message1 = exchanger.exchange(message);
                System.out.println("生产者接受到的消费者返回数据：" + message.getV());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Message implements Serializable {
        private String V;

        public Message() {
        }

        public Message(String v) {
            V = v;
        }

        public String getV() {
            return V;
        }

        public void setV(String v) {
            V = v;
        }
    }
}
