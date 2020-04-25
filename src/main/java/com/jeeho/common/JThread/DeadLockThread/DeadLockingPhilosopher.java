package com.jeeho.common.JThread.DeadLockThread;

/**
 * 基于内部锁的线程死锁的实现
 */
public class DeadLockingPhilosopher extends AbstractPhilosopher {

    public DeadLockingPhilosopher(int id, Chopstick left, Chopstick right) {
        super(id, left, right);
    }

    @Override
    public void eat() {
        synchronized(left){
            System.out.format("%s is picking up %s on his left",this,left);
            left.pickUp();
            synchronized (right){
                System.out.format("%s is picking up %s on his right",this,right);
                right.pickUp();
                try {
                    doEat();
                    right.pickDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            left.pickDown();
        }
    }

}
