package com.jeeho.common.base.DataStructure.interfaces;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionQueueEmpty;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionQueueFull;

public interface Queue {

    public int getSize();

    public boolean isEmpty();

    public Object front() throws ExceptionQueueEmpty;

    public void enqueue(Object ele) throws ExceptionQueueFull;

    public Object dequeue() throws ExceptionQueueEmpty;

    public void Traversal();
}
