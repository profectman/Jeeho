package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionQueueEmpty;
import com.jeeho.common.base.DataStructure.interfaces.Deque;

public class Deque_DLNode  implements Deque {

    private DLNode header;
    private DLNode tailer;
    private int size;

    public Deque_DLNode() {
        header = new DLNode();
        tailer = new DLNode();
        header.setNext(tailer);
        tailer.setPrev(header);
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
    public Object first() throws ExceptionQueueEmpty {
        if (isEmpty())
            throw new ExceptionQueueEmpty("双向队列为空！");
        DLNode first = header.getNext();
        return first.getElem();
    }

    @Override
    public Object last() throws ExceptionQueueEmpty {
        if (isEmpty())
            throw new ExceptionQueueEmpty("双向队列为空！");
        return tailer.getPrev().getElem();
    }

    @Override
    public void insertFirst(Object elem) {
        DLNode v = new DLNode();
        v.SetElem(elem);
        DLNode first = header.getNext();
        v.setPrev(header);
        v.setNext(first);
        header.setNext(v);
        first.setPrev(v);
        size++;
    }

    @Override
    public void insertLast(Object elem) {
        DLNode v = new DLNode();
        v.SetElem(elem);
        DLNode first = tailer.getPrev();
        v.setPrev(first);
        v.setNext(tailer);
        tailer.setPrev(v);
        first.setNext(v);
        size++;
    }

    @Override
    public Object removeFirst() throws ExceptionQueueEmpty {
        DLNode first = header.getNext();
        DLNode second = first.getNext();
        Object elem = first.getElem();
        header.setNext(second);
        second.setPrev(header);
        size--;
        return elem;
    }

    @Override
    public Object removeLast() throws ExceptionQueueEmpty {
        DLNode first = tailer.getPrev();
        DLNode second = first.getPrev();
        Object elem = first.getElem();
        tailer.setPrev(second);
        second.setNext(tailer);
        size--;
        return elem;
    }
}
