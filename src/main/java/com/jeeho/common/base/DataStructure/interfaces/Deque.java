package com.jeeho.common.base.DataStructure.interfaces;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionQueueEmpty;

public interface Deque {

    public int getSize();

    public boolean isEmpty();

    public Object first() throws ExceptionQueueEmpty;

    public Object last() throws ExceptionQueueEmpty;

    public void insertFirst(Object elem);

    public void insertLast(Object elem);

    public Object removeFirst() throws ExceptionQueueEmpty;

    public Object removeLast() throws ExceptionQueueEmpty;
}
