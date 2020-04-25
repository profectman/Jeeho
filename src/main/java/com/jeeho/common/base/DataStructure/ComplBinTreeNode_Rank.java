package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.BinTreePosition;
import com.jeeho.common.base.DataStructure.interfaces.Vector;

public class ComplBinTreeNode_Rank extends BinTreeNode implements BinTreePosition {

    private Vector T;
    private int rank;
    private Object elem;

    public ComplBinTreeNode_Rank(Vector v, Object elem) {
        this.T = v;
        this.elem = elem;
        rank = v.getSize();
        T.insertAtRank(rank,elem);
    }

    @Override
    public int getSize() {
        int size = 1;
        if (hasLChild()) size += getLChild().getSize();
        if (hasRChild()) size += getRChild().getSize();
        return size;
    }

    @Override
    public int getHeight() {
        int height = 0;
        if (hasLChild()) height = Math.max(height,getLChild().getHeight());
        if (hasRChild()) height = Math.max(height,getRChild().getHeight());
        return height + 1;
    }

    @Override
    public int getDepth() {
        int depth = 0;
        if (hasParent()){
            depth += getParent().getDepth();
        }
        return depth+1;
    }

    @Override
    public boolean hasParent() {
        return 0 != rank;
    }

    @Override
    public BinTreePosition getParent() {
        return hasParent() ? (BinTreePosition) T.getAtRank((rank - 1)/2) : null;
    }

    @Override
    public boolean hasLChild() {
        return (2*rank + 1) < T.getSize();
    }

    @Override
    public BinTreePosition getLChild() {
        return hasLChild() ? (BinTreePosition) T.getAtRank(2*rank + 1) : null;
    }

    @Override
    public boolean hasRChild() {
        return (2*rank + 2) < T.getSize();
    }

    @Override
    public BinTreePosition getRChild() {
        return hasLChild() ? (BinTreePosition) T.getAtRank(2*rank + 2) : null;
    }

    @Override
    public Object SetElem(Object newElem) {
        Object oldElem = elem;
        this.elem = newElem;
        return oldElem;
    }

    @Override
    public Object getElem() {
        return this.elem;
    }
}
