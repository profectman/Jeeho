package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.Iterator;
import com.jeeho.common.base.DataStructure.interfaces.List;
import com.jeeho.common.base.DataStructure.interfaces.Position;

public class IteratorPosition implements Iterator {

    private List list ;
    private Position nextPosition;  //下一个位置,从头部开始.

    public IteratorPosition() {
        list = null;
    }

    public IteratorPosition(List list) {
        this.list = list;
        if (list.isEmpty())
            nextPosition = null;
        else
            nextPosition = list.first();
    }

    @Override
    public boolean hasNext() {
        return nextPosition != null;
    }

    @Override
    public Object getNext() {
        Position currentPosition = nextPosition;
        if (currentPosition == list.last())
            currentPosition = null;
        else
            nextPosition = list.getNext(currentPosition);
        return currentPosition;
    }
}
