package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.Position;

/**
 * 单链表节点元素
 */
public class Node implements Position {

    private Object elem;

    private Node next;

    public Node(Object elem, Node next) {
        this.elem = elem;
        this.next = next;
    }


    @Override
    public Object SetElem(Object newElem) {
        Object oldElem = this.elem;
        this.elem = newElem;
        return oldElem;
    }

    @Override
    public Object getElem() {
        return elem;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
