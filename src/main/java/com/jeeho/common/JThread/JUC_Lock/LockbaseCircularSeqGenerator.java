package com.jeeho.common.JThread.JUC_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 计数器 simple counter
 */
public class LockbaseCircularSeqGenerator {
    private short sequence = -1;
    private final Lock lock = new ReentrantLock();

    public short nextSequence(){
        lock.lock();
        try {
            if (sequence >= 999)
                sequence = 0;
            else
                sequence++;
            return sequence;
        }finally {
            lock.unlock();
        }
    }
}
