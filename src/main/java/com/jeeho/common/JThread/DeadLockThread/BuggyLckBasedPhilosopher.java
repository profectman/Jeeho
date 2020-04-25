package com.jeeho.common.JThread.DeadLockThread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用可重入式锁实现线程死锁
 */
public class BuggyLckBasedPhilosopher extends AbstractPhilosopher {

    private final static ConcurrentMap<Chopstick,ReentrantLock> LOCK_MAP ;

    static {
        LOCK_MAP = new ConcurrentHashMap<>();
    }

    public BuggyLckBasedPhilosopher(int id, Chopstick left, Chopstick right) {
        super(id, left, right);
        LOCK_MAP.putIfAbsent(left,new ReentrantLock());
        LOCK_MAP.putIfAbsent(right,new ReentrantLock());
    }

    @Override
    public void eat() {
        if (pickUpChopstick(left) && pickUpChopstick(right)){
            try {
                doEat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                pickDownChopstick(left,right);
            }
        }
    }

    private boolean pickUpChopstick(Chopstick chopstick) {
        ReentrantLock reentrantLock = LOCK_MAP.get(chopstick);
        reentrantLock.lock();
        try {
            chopstick.pickUp();
            //TODO:
        }catch (Exception e){
            reentrantLock.unlock();
            return false;
        }
        return true;
    }

    private void pickDownChopstick(Chopstick chopstick1,Chopstick chopstick2){
        try {
            pickDownChopstick(chopstick1);
        }finally {
            pickDownChopstick(chopstick2);
        }
    }

    private void pickDownChopstick(Chopstick chopstick   ) {
        ReentrantLock reentrantLock = LOCK_MAP.get(chopstick);
        try {
            chopstick.pickDown();
            //TODO:
        }finally {
            reentrantLock.unlock();
        }
    }
}
