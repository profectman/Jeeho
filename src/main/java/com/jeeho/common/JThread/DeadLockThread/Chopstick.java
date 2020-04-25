package com.jeeho.common.JThread.DeadLockThread;

public class Chopstick {

    private final int id;
    private boolean status= false;

    public Chopstick(int id) {
        super();
        this.id = id;
    }

    public void pickUp(){
        this.status = true;
    }

    public void pickDown(){
        this.status = false;
    }
}
