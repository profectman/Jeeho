package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionBoundaryViolation;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionListEmpty;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionPositionInvalid;
import com.jeeho.common.base.DataStructure.interfaces.Iterator;
import com.jeeho.common.base.DataStructure.interfaces.List;
import com.jeeho.common.base.DataStructure.interfaces.Position;

/**
 * 相当于LinkedList -> 基于链表实现
 */
public class List_DLNode implements List {

    protected int numElem;
    protected DLNode header,tailer;

    public List_DLNode() {
        header = new DLNode();
        tailer = new DLNode();
        header.setNext(tailer);
        tailer.setPrev(header);
        numElem = 0;
    }

    private DLNode checkPosition(Position p){
        if (p == null)
            throw new ExceptionPositionInvalid("输入DLNode为空！");
        if (header == p)
            throw new ExceptionPositionInvalid("输入DLNode为头部哨兵节点，非法错误!");
        if (tailer == p)
            throw new ExceptionPositionInvalid("输入DLNode为尾部哨兵节点，非法错误!");
        DLNode temp = (DLNode) p;
        return temp;
    }

    @Override
    public int getSize() {
        return numElem;
    }

    @Override
    public boolean isEmpty() {
        return numElem == 0;
    }

    @Override
    public Position first() {
        if (isEmpty())
            throw new ExceptionListEmpty("意外：列表为空！");
        return header.getNext();
    }

    @Override
    public Position last() {
        if (isEmpty())
            throw new ExceptionListEmpty("意外：列表为空！");
        return tailer.getPrev();
    }

    @Override
    public Position getPrev(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
        DLNode v = checkPosition(p);
        DLNode prev = v.getPrev();
        if (header == prev)
            throw new ExceptionPositionInvalid("意外：企图越过列表前端!");
        return prev;
    }

    @Override
    public Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
        DLNode v = checkPosition(p);
        DLNode next = v.getNext();
        if (tailer == next)
            throw new ExceptionPositionInvalid("意外：企图越过列表后端");
        return next;
    }

    @Override
    public Position insertBefore(Position p, Object e) throws ExceptionPositionInvalid {
        DLNode v = checkPosition(p);

        numElem++;
        DLNode newNode = new DLNode(e,v.getPrev(),v);

        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
        return newNode;
    }

    @Override
    public Position insertAfter(Position p, Object e) throws ExceptionPositionInvalid {
        DLNode v = checkPosition(p);
        numElem++;

        DLNode newNode = new DLNode(e,v,v.getNext());

        v.getNext().setPrev(newNode);
        v.setPrev(newNode);
        return newNode;
    }

    @Override
    public Position insertFirst(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e,header,header.getNext());

        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        return newNode;
    }

    @Override
    public Position insertLast(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e,tailer.getPrev(),tailer);

        if (null == tailer.getPrev()) System.out.println("!!!Prev of trailer is NULL!!!");

        tailer.getPrev().setNext(newNode);
        tailer.setPrev(newNode);
        return newNode;
    }

    @Override
    public Object replace(Position p, Object e) throws ExceptionPositionInvalid {
        DLNode v = checkPosition(p);

        DLNode newNode = new DLNode(e,v.getPrev(),v.getNext());

        v.getPrev().setNext(newNode);
        v.getNext().setPrev(newNode);

        return v.getElem();
    }

    @Override
    public Object remove(Position p) {
        DLNode v = checkPosition(p);

        numElem--;

        v.getPrev().setNext(v.getNext());
        v.getNext().setPrev(v.getPrev());

        v.setPrev(null);
        v.setNext(null);

        return v.getElem();
    }

    @Override
    public Object removeFirst() throws ExceptionPositionInvalid {
        return remove(header.getNext());
    }

    @Override
    public Object removeLast() throws ExceptionPositionInvalid {
        return remove(tailer.getPrev());
    }

    @Override
    public Iterator positions() {
        return new IteratorPosition(this);
    }

    @Override
    public Iterator elements() {
        Iterator iterator = new IteratorElements(this);
        return iterator;
    }
}
