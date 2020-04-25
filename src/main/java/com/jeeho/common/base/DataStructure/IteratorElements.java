package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.Iterator;
import com.jeeho.common.base.DataStructure.interfaces.List;
import com.jeeho.common.base.DataStructure.interfaces.Position;

public class IteratorElements implements Iterator {

    List list;
    Position nextPosition;

    public IteratorElements() {
        list = null;
    }

    public IteratorElements(List list) {
        this.list = list;
        if (this.list == null)
            nextPosition = null;
        else
            nextPosition = list.first();
    }

    @Override
    public boolean hasNext() {
        return null == nextPosition;
    }

    @Override
    public Object getNext() {
        Position currentPosition = nextPosition;

        if (currentPosition == list.last())
            nextPosition = null;
        else
            nextPosition = list.getNext(currentPosition);
        return currentPosition.getElem();
    }
}
