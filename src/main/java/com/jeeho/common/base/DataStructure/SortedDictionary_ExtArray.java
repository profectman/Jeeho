package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.*;

/**
 * 有序词典的实现
 */
public class SortedDictionary_ExtArray implements SortedDictionary {

    private Vector S;

    private Comparator C;

    public SortedDictionary_ExtArray() {
        this(new ComparatorDefault());
    }

    public SortedDictionary_ExtArray(Comparator c) {
        S = new Vector_Array();
        C = c;
    }

    /*********************** 辅助方法 **********************/
    private int binSearch(Vector s,Comparator c,int lo,int hi,Object key){
        if ( lo > hi) return lo;

        int mi = (lo + hi) >> 1;
        int flag = c.compareTo(key,((Entry)s.getAtRank(mi)).getKey());
        if (flag > 0) return binSearch(s,c,mi + 1,hi,key);
        else if (flag < 0) return binSearch(s,c,lo,mi - 1,key);
        else
            return mi;
    }
    /*********************** 词典基本方法 ******************/

    @Override
    public Entry first() {
        return (Entry) S.getAtRank(0);
    }

    @Override
    public Entry last() {
        return (Entry) S.getAtRank(S.getSize() - 1);
    }

    @Override
    public Iterator predecessors(Object key) {
        List L = new List_DLNode();
        int k = binSearch(S,C,0,S.getSize()-1,key);

        if (0 > k || k > S.getSize() || (0 != C.compareTo(key,((Entry)S.getAtRank(k)).getKey())))
            return new IteratorElements(L);

        while (getSize() > ++k){
            if (0 > k || k > S.getSize() || (0 != C.compareTo(key,((Entry)S.getAtRank(k)).getKey()))) break;
        }

        while (0 <= --k)
            L.insertLast(S.getAtRank(k));

        return new IteratorElements(L);
    }

    @Override
    public Iterator successors(Object key) {
        List L = new List_DLNode();
        int k = binSearch(S,C,0,S.getSize()-1,key);

        if (0 > k || k > S.getSize() || (0 != C.compareTo(key,((Entry)S.getAtRank(k)).getKey())))
            return new IteratorElements(L);

        while (0 <= --k){
            if (0 > k || k > S.getSize() || (0 != C.compareTo(key,((Entry)S.getAtRank(k)).getKey()))) break;
        }

        while (S.getSize() > ++k)
            L.insertLast(S.getAtRank(k));

        return new IteratorElements(L);
    }

    @Override
    public int getSize() {
        return S.getSize();
    }

    @Override
    public boolean isEmpty() {
        return S.isEmpty();
    }

    @Override
    public Entry find(Object key) {
        int k = binSearch(S,C,0,S.getSize()-1,key);

        if (0 > k || k > S.getSize() || (0 != C.compareTo(key,((Entry)S.getAtRank(k)).getKey())))
            return null;
        return (Entry)S.getAtRank(k);
    }

    @Override
    public Iterator findAll(Object key) {
        List L = new List_DLNode();
        int k = binSearch(S,C,0,S.getSize()-1,key);

        if (0 > k || k > S.getSize() || (0 != C.compareTo(key,((Entry)S.getAtRank(k)).getKey())))
            return new IteratorElements(L);

        L.insertLast(S.getAtRank(k));
        int lo = k;
        while (0 < --lo){
            if (0 > lo || lo > S.getSize() || (0 != C.compareTo(key,((Entry)S.getAtRank(lo)).getKey()))) break;
            L.insertLast(S.getAtRank(lo));
        }

        int hi = k;
        while ( ++k < S.getSize()){
            if (0 > lo || lo > S.getSize() || (0 != C.compareTo(key,((Entry)S.getAtRank(lo)).getKey()))) break;
            L.insertLast(S.getAtRank(lo));
        }
        return new IteratorElements(L);
    }

    @Override
    public Entry insert(Object key, Object value) {
        Entry e = new EntryDefault(key,value);

        if (S.isEmpty())
            return (Entry) S.insertAtRank(0,e);
        return (Entry) S.insertAtRank(binSearch(S,C,0,S.getSize() - 1,key),e);
    }

    @Override
    public Entry remove(Object key) {
        int k = binSearch(S,C,0,S.getSize()-1,key);

        if (0 > k || k > S.getSize() || (0 != C.compareTo(key,((Entry)S.getAtRank(k)).getKey())))
            return null;
        return (Entry) S.removeAtRank(k);
    }

    @Override
    public Iterator entries() {
        List L = new List_DLNode();
        for (int i=0;i<S.getSize();i++)
            L.insertLast(S.getAtRank(i));
        return new IteratorElements(L);
    }
}
