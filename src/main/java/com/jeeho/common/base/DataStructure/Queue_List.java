package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionQueueEmpty;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionQueueFull;
import com.jeeho.common.base.DataStructure.interfaces.Queue;

public class Queue_List implements Queue {

    Node head ;
    Node tail ;
    private int size;

    public Queue_List() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object front() throws ExceptionQueueEmpty {
        if (isEmpty())
            throw new ExceptionQueueEmpty("队列为空！");
        return head.getElem();
    }

    @Override
    public void enqueue(Object ele) throws ExceptionQueueFull {
        Node v = new Node(ele,null);
        if (size == 0)
            head = v;
        else
            tail = v;
        size++;
    }

    @Override
    public Object dequeue() throws ExceptionQueueEmpty {
        if (isEmpty())
            throw new ExceptionQueueEmpty("队列为空!");
        Object elem = head.getElem();
        head = head.getNext();
        size--;
        if (0 == size) tail = null;
        return elem;
    }

    @Override
    public void Traversal() {
        Node p = head;
        while (p != null){
            System.out.print(p.getElem() + " ");
            p = p.getNext();
        }
    }
}
