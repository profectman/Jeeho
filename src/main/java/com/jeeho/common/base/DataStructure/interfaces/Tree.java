package com.jeeho.common.base.DataStructure.interfaces;


import com.jeeho.common.base.DataStructure.TreeLinkedList;

public interface Tree {

    Object getElem();

    Object setElem(Object elem);

    TreeLinkedList getParent();

    TreeLinkedList getFirstChild();

    TreeLinkedList getNextSibling();

    int getSize();

    int getHeight();

    int getDepth();
}
