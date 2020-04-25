package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.Tree;

public class TreeLinkedList implements Tree {

    private TreeLinkedList parent,firstChild,nextSibling;
    private Object elem;

    @Override
    public Object getElem() {
        return this.elem;
    }

    @Override
    public Object setElem(Object elem) {
        Object oldElem = this.elem;
        this.elem = elem;
        return oldElem;
    }

    @Override
    public TreeLinkedList getParent() {
        return parent;
    }

    @Override
    public TreeLinkedList getFirstChild() {
        return firstChild;
    }

    @Override
    public TreeLinkedList getNextSibling() {
        return nextSibling;
    }

    @Override
    public int getSize() {
        int size = 0;
        TreeLinkedList subtree = firstChild;
        while (subtree != null){
            size += subtree.getSize();
            subtree = subtree.getNextSibling();
        }
        return size;
    }

    @Override
    public int getHeight() {
        int height = -1;
        TreeLinkedList subtree = firstChild;
        while(subtree != null){
            height = Math.max(height,subtree.getHeight());
            subtree = subtree.getNextSibling();
        }
        return height + 1;
    }

    @Override
    public int getDepth() {
        int depth = 0;
        TreeLinkedList p = parent;
        while (null != p){
            p = p.getParent();
            depth++;
        }
        return depth;
    }
}
