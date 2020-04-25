package com.jeeho.common.base.collection.tree;

public interface Tree {

    public Object getElem();

    public void setElem(Object elem);

    public TreeLinkedList getParent();

    public TreeLinkedList getFirstChild();

    public TreeLinkedList getNextSubling();

    public int getSize();

    public int getHeight();

    public int getDepth();
}
