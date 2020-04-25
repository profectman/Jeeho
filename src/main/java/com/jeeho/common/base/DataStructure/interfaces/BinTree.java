package com.jeeho.common.base.DataStructure.interfaces;

public interface BinTree {

    BinTreePosition getRoot();

    int getSize();

    boolean isEmpty();

    int getHeight();

    Iterator elementsPreOrder();

    Iterator elementsPostOrder();

    Iterator elementsLevelOrder();

    Iterator elementsInOrder();
}
