package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.Position;

/**
 * 双向链表
 */
public class DLNode implements Position {

    private Object elem;
    private DLNode prev;
    private DLNode next;

    public DLNode() {
    }

    public DLNode(Object elem, DLNode prev, DLNode next) {
        this.elem = elem;
        this.prev = prev;
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
        return this.elem;
    }

    public DLNode getPrev() {
        return prev;
    }

    public void setPrev(DLNode prev) {
        this.prev = prev;
    }

    public DLNode getNext() {
        return next;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }
}
