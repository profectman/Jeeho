package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.BinTree;
import com.jeeho.common.base.DataStructure.interfaces.BinTreePosition;
import com.jeeho.common.base.DataStructure.interfaces.Iterator;

public class BinTreeLinkedList implements BinTree {

    public BinTreePosition root;

    public BinTreeLinkedList() {
        this(null);
    }

    public BinTreeLinkedList(BinTreePosition root) {
        this.root = root;
    }

    @Override
    public BinTreePosition getRoot() {
        return root;
    }

    @Override
    public int getSize() {
        return isEmpty() ? 0 : root.getSize();
    }

    @Override
    public boolean isEmpty() {
        return null == root;
    }

    @Override
    public int getHeight() {
        return isEmpty() ? 0 : root.getHeight();
    }

    @Override
    public Iterator elementsPreOrder() {
        return root.elementsPreOrder();
    }

    @Override
    public Iterator elementsPostOrder() {
        return root.elementsPostOrder();
    }

    @Override
    public Iterator elementsLevelOrder() {
        return root.elementsLevelOrder();
    }

    @Override
    public Iterator elementsInOrder() {
        return root.elementsInOrder();
    }
}
