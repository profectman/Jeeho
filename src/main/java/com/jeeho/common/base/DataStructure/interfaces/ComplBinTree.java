package com.jeeho.common.base.DataStructure.interfaces;

public interface ComplBinTree extends BinTree {

    BinTreePosition addLast(Object e);

    Object delLast();

    BinTreePosition posofNode(int i);
}
