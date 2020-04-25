package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.*;

/**
 * 基于链表实现词典
 */
public class Dictionary_DLNode implements Dictionary {

    List L ;
    EqualityTester T;

    public Dictionary_DLNode(EqualityTester T){
        this.T = T;
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
    public Entry find(Object key) {
        Iterator positions = L.positions();
        while (positions.hasNext()){
            Position position = (Position) positions.getNext();
            Entry entry = (Entry) position.getElem();
            if (T.isEqualTo(key,entry.getKey()))
                return entry;
        }
        return null;
    }

    @Override
    public Iterator findAll(Object key) {
        List list = new List_DLNode();
        Iterator iterator = L.positions();
        while (iterator.hasNext()){
            Position position = (Position)iterator.getNext();
            Entry entry = (Entry) position.getElem();
            if (T.isEqualTo(key,entry.getKey()))
                list.insertLast(entry);
        }
        return new IteratorElements(list);
    }

    @Override
    public Entry insert(Object key, Object value) {
        Entry entry = new EntryDefault(key,value);
        L.insertLast(entry);
        return entry;
    }

    @Override
    public Entry remove(Object key) {
        Iterator iterator = L.positions();
        while (iterator.hasNext()){
            Position position = (Position) iterator.getNext();
            Entry entry = (Entry) position.getElem();
            if (T.isEqualTo(key,entry.getKey())){
                Entry oldEntry = entry;
                L.remove(position);
                return oldEntry;
            }
        }
        return null;
    }

    @Override
    public Iterator entries() {
        return new IteratorElements(L);
    }
}
