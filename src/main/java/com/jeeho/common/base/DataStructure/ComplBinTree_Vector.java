package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.BinTreePosition;
import com.jeeho.common.base.DataStructure.interfaces.ComplBinTree;
import com.jeeho.common.base.DataStructure.interfaces.Vector;

/**
 * 完全二叉树的实现
 */
public class ComplBinTree_Vector extends BinTreeLinkedList implements ComplBinTree {

    Vector T ;

    public ComplBinTree_Vector(Vector t) {
        T = t;
    }

    @Override
    public BinTreePosition addLast(Object e) {
        ComplBinTreeNode_Rank node = new ComplBinTreeNode_Rank(T,e);
        root = (BinTreePosition) T.getAtRank(0);
        return node;
    }

    @Override
    public Object delLast() {

        if (isEmpty()) return null;
        if (1 == getSize()) root = null;
        return T.removeAtRank(T.getSize() - 1);
    }

    @Override
    public BinTreePosition posofNode(int i) {
        return (BinTreePosition) T.getAtRank(i);
    }
}
