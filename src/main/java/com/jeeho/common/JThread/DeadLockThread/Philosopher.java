package com.jeeho.common.JThread.DeadLockThread;

public interface Philosopher {

    public void eat();

    public void think() throws InterruptedException;
}
