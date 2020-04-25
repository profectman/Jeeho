package com.jeeho.common.JThread.DeadLockThread;

import sun.security.util.Debug;

import javax.tools.Tool;

public abstract class AbstractPhilosopher extends Thread implements Philosopher {

    protected final int id;
    protected final Chopstick left;
    protected final Chopstick right;

    public AbstractPhilosopher(int id, Chopstick left, Chopstick right) {
        super("Philosopher " + id);
        this.id = id;
        this.left = left;
        this.right = right;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        for (;;){
            try {
                think();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            eat();
        }
    }

    @Override
    public abstract void eat();

    public void doEat() throws InterruptedException {
        System.out.format("%s is doEating ... %n",this);
        Thread.sleep(1000);
    }

    @Override
    public void think() throws InterruptedException {
        System.out.format("%s is thinking... %n",this);
        Thread.sleep(1000);
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}
