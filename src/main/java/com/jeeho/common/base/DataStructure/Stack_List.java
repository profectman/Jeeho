package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionStackEmpty;
import com.jeeho.common.base.DataStructure.interfaces.Stack;

public class Stack_List implements Stack {

    private Node top;
    private int size;

    public Stack_List() {
        top = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(Object ele) {
        Node v = new Node(ele,top);
        top = v;
        size++;
    }

    @Override
    public Object pop() throws ExceptionStackEmpty {
        if (isEmpty())
            throw new ExceptionStackEmpty("栈为空！");
        Object elem = top.getElem();
        top = top.getNext();
        size--;
        return elem;
    }

    @Override
    public Object top() throws ExceptionStackEmpty {
        if (isEmpty())
            throw new ExceptionStackEmpty("栈为空!");
        return top.getElem();
    }


}
