package com.jeeho.common.base.DataStructure.interfaces;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionStackEmpty;

public interface Stack {

    public int getSize();

    public boolean isEmpty();

    public void push(Object ele);

    public Object pop() throws ExceptionStackEmpty;

    public Object top() throws ExceptionStackEmpty;
}
