package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionQueueEmpty;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionQueueFull;
import com.jeeho.common.base.DataStructure.interfaces.Queue;

/**
 * 基于数组实现队列 fifo
 */
public class MyQueue implements Queue {

    private static final int CAPACITY = 1024;
    private Object[] Q;
    private int capacity;

    private int f =0;
    private int r =0;

    public MyQueue(){
        this(CAPACITY);
    }

    public MyQueue(int capacity){
        this.capacity = capacity;
        Q = new Object[capacity];
    }

    @Override
    public int getSize() {
        return (capacity-f+r)%capacity;
    }

    @Override
    public boolean isEmpty() {
        return f==r;
    }

    @Override
    public Object front() throws ExceptionQueueEmpty {
        if (isEmpty())
            throw new ExceptionQueueEmpty("队列为空！");
        return Q[f];
    }

    @Override
    public void enqueue(Object ele) throws ExceptionQueueFull {
        if (getSize() == capacity -1)
            throw new ExceptionQueueFull("队列已满！");
        Q[r] = ele;
        r = (r+1)%capacity;
    }

    @Override
    public Object dequeue() throws ExceptionQueueEmpty {
        Object obj = null;
        if (isEmpty())
            throw new ExceptionQueueEmpty("队列为空！");
        obj= Q[f];
        Q[f]= null;
        f = (f+1)%capacity;
        return obj;
    }

    @Override
    public void Traversal() {
        for (int i=f;i<=r;i++)
            System.out.print(Q[i] + " ");
        System.out.println();
    }

    /**
     * 使用队列实现闭环
     * @param Q
     * @param k
     * @return
     */
    public static Object Josephus(Queue Q,int k){
        if (Q.isEmpty())
            return null;
        while (Q.getSize() > 1){
            Q.Traversal();

            for (int i=0;i<k;i++){
                Q.enqueue(Q.dequeue());
            }

            Object e = Q.dequeue();
            System.out.println("\n\t" + e + "退出.");
        }
        return Q.dequeue();
    }

    //将一组对象组织为一个队列
    public static Queue buildQueue(Object a[]) {
        Queue Q = new MyQueue();
        for (int i=0; i<a.length; i++)
            Q.enqueue(a[i]);
        return Q;
    }

    //测试用main方法
    public static void main(String[] args) {
        String[] kid = {"Alice", "Bob", "Cindy", "Doug", "Ed",
                "Fred", "Gene", "Hope", "Irene", "Jack",
                "Kim", "Lance", "Mike", "Nancy", "Ollie"};
        System.out.println("最终的幸运者是" + Josephus(buildQueue(kid), 5));
    }
}
