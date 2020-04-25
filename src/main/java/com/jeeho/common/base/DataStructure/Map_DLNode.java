package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.*;

/**
 * 基于链表实现映射
 */
public class Map_DLNode implements Map {

    List L;
    EqualityTester T;

    public Map_DLNode() {
        this(new EqualityTesterDefault());
    }

    public Map_DLNode(EqualityTester t) {
        T = t;
        L = new List_DLNode();
    }

    @Override
    public int getSize() {
        return L.getSize();
    }

    @Override
    public boolean isEmpty() {
        return L.isEmpty();
    }

    @Override
    public Object get(Object key) {
        Iterator positions = L.positions();
        while (positions.hasNext()){
            Position position = (Position)positions.getNext();
            Entry entry = (Entry)position.getElem();
            if (T.isEqualTo(entry.getKey(),key))
                return entry.getValue();
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        Iterator positions = L.positions();
        while (positions.hasNext()){
            Position position = (Position) positions.getNext();
            Entry entry = (Entry) position.getElem();
            EntryDefault entryDefault = new EntryDefault(key,value);
            if (T.isEqualTo(entry.getKey(),key)){
                L.replace(position,entryDefault);
                return ((Entry) position.getElem()).getValue();
            }
        }
        L.insertLast(new EntryDefault(key,value));
        return null;
    }

    @Override
    public Object remove(Object key) {
        Iterator positions = L.positions();
        while (positions.hasNext()){
            Position position = (Position) positions.getNext();
            Entry entry = (Entry) position.getElem();
            if (T.isEqualTo(entry.getKey(),key)){
                L.remove(position);
                return ((Entry) position.getElem()).getValue();
            }
        }
        return null;
    }

    @Override
    public Iterator entries() {
        return new IteratorElements(L);
    }
}
