package com.jeeho.common.JThread.JUC_Synchronizer;

import java.util.concurrent.Semaphore;

/**
 * 信号量Semaphore ，在高并发的情况下，控制共享资源中线程的访问数量。
 */
public class Pool {
    private final static int MAX_AVAILABLE = 100;
    private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE,true);
    protected Object[] item = new Object[MAX_AVAILABLE];
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    /**
     * 单项线程首先获取信号量，如果信号量满足，就获取资源；如果信号量不满足，就等待；
     * @return
     * @throws InterruptedException
     */
    public Object getItem() throws InterruptedException {
        semaphore.acquire();
        return getNextAvailableItem();
    }

    /**
     * 线程归还资源，若归还成功，则释放信号量；若归还失败，则进行继续进行等待；
     * @param x
     */
    public void putItem(Object x){
        if (markAsUnused(x))
            semaphore.release();
    }

    private synchronized Object getNextAvailableItem(){
        for (int i=0; i < MAX_AVAILABLE;++i){
            if (!used[i]){
                used[i] = true;
                return item[i];
            }
        }
        return null;
    }


    private synchronized boolean markAsUnused(Object x){
        for (int i=0; i < MAX_AVAILABLE; ++i){
            if (x == item[i]){
                if (used[i]){
                    used[i] = false;
                    return true;
                }else
                    return false;
            }
        }
        return false;
    }
}
