package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionKeyInvalid;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionPQueueEmpty;
import com.jeeho.common.base.DataStructure.interfaces.*;

public class PQueue_Heap implements PQueue {

    private ComplBinTree H;
    private Comparator C;

    public PQueue_Heap(Sequence s,Comparator c) {
        C = c;
        H = new ComplBinTree_Vector(s);

        if (!H.isEmpty()){
            for (int i = H.getSize()/2 - 1;i >= 0;i--){
                percolateDown(H.posofNode(i));
            }
        }
    }

    @Override
    public int getSize() {
        return H.getSize();
    }

    @Override
    public boolean isEmpty() {
        return H.isEmpty();
    }

    @Override
    public Entry getMin() throws ExceptionPQueueEmpty {
        return (Entry) H.getRoot().getElem();
    }

    @Override
    public Entry insert(Object key, Object o) throws ExceptionKeyInvalid {
        Entry entry = new EntryDefault(key,o);
        precolateUp(H.addLast(entry));
        return entry;
    }

    @Override
    public Entry delMin() throws ExceptionPQueueEmpty {
        Entry min = (Entry) H.getRoot().getElem();
        if (1 == H.getSize())
            H.delLast();
        else{
            H.getRoot().SetElem(((ComplBinTreeNode_Rank)H.delLast()).getElem());
            percolateDown(H.getRoot());
        }
        return min;
    }

    public Object key(BinTreePosition v){
        return ((Entry)(v.getElem())).getKey();
    }

    private void swapParentChild(BinTreePosition u,BinTreePosition v){
        Object temp = v.getElem();
        v.SetElem(u.getElem());
        u.SetElem(temp);
    }

    /**
     * 下滤
     * @param v
     */
    private void percolateDown(BinTreePosition v) {
        while (v.hasLChild()){
            BinTreePosition smallerChild = v.getLChild();
            if (v.hasRChild() && 0 < C.compareTo(key(v.getLChild()),key(v.getRChild())))
                smallerChild = v.getRChild();
            if (0 < C.compareTo(key(smallerChild),v)) break;

            swapParentChild(smallerChild,v);
            v = smallerChild;
        }
    }

    /**
     * 上滤
     * @param v
     */
    private void precolateUp(BinTreePosition v){
        BinTreePosition root = H.getRoot();
        while (v != root){
            BinTreePosition parent = v.getParent();
            if (0 >= C.compareTo(key(parent),key(v))) break;

            swapParentChild(parent,v);
            v = parent;
        }
    }
}
