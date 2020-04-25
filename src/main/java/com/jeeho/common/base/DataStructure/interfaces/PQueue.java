package com.jeeho.common.base.DataStructure.interfaces;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionKeyInvalid;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionPQueueEmpty;

public interface PQueue {

    int getSize();

    boolean isEmpty();

    Entry getMin() throws ExceptionPQueueEmpty;

    Entry insert(Object key , Object o) throws ExceptionKeyInvalid;

    Entry delMin() throws ExceptionPQueueEmpty;
}
