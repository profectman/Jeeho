package com.jeeho.common.base.DataStructure.interfaces;


import com.jeeho.common.base.DataStructure.exceptions.ExceptionBoundaryViolation;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionPositionInvalid;

/**
 * 基于双向链表实现列表
 * p == null
 * p 已经被删除
 * p 是另一个列表中的位置
 * p 是列表中的第一个位置(getPrev)
 * p 是列表的中最后一个位置(getNext)
 */
public interface List {

    int getSize();

    boolean isEmpty();

    Position first();

    Position last();

    Position getPrev(Position p) throws ExceptionPositionInvalid,ExceptionBoundaryViolation;

    Position getNext(Position p) throws ExceptionPositionInvalid,ExceptionBoundaryViolation;

    Position insertBefore(Position p,Object e) throws ExceptionPositionInvalid;

    Position insertAfter(Position p,Object e) throws ExceptionPositionInvalid;

    Position insertFirst(Object e);

    Position insertLast(Object e);

    Object replace (Position p ,Object e) throws ExceptionPositionInvalid;

    Object remove(Position p);

    Object removeFirst() throws ExceptionPositionInvalid;

    Object removeLast() throws ExceptionPositionInvalid;

    com.jeeho.common.base.DataStructure.interfaces.Iterator positions();

    com.jeeho.common.base.DataStructure.interfaces.Iterator elements();
}
