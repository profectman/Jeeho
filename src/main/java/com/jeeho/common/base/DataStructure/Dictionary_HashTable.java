package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.*;

/**
 * 基于散列表实现无序词典
 */
public class Dictionary_HashTable implements Dictionary {

    private Dictionary[] A;

    private int N;

    private double lemda = 0.75;

    private int size ;

    private EqualityTester E;

    public Dictionary_HashTable(int n,EqualityTester e){
        this.E = e;
        N = p(n);

        this.A = new Dictionary[N];

        for (int i = 0;i < A.length; i++){
            A[i] = new Dictionary_DLNode(E);
        }
    }
    /*********************** 辅助方法 ****************************/
    private int h(Object key){
        return key.hashCode()%N;
    }

    private boolean prime(int n){
        for (int i = n; i > 3 ; i--){
            if (n/i*i == n) return false;
        }
        return true;
    }

    private int p(int n){
        if (n < 3) return 3;

        while (!prime(n)) n++;

        return n;
    }

    /*********************** 词典方法 ****************************/
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public Entry find(Object key) {
        return A[h(key)].find(key);
    }

    @Override
    public Iterator findAll(Object key) {
        return A[h(key)].findAll(key);
    }

    @Override
    public Entry insert(Object key, Object value) {
        Entry entry = A[h(key)].insert(key,value);
        size++;

        if ( size > getSize() - 1)
            rehash();

        return entry;
    }

    @Override
    public Entry remove(Object key) {
        Entry oldEntry = A[h(key)].remove(key);
        if (null != oldEntry)
            size--;
        return oldEntry;
    }

    @Override
    public Iterator entries() {
        List L = new List_DLNode();
        for (int i=0;i<N;i++){
            Iterator iterator = A[i].entries();
            while (iterator.hasNext())
                L.insertLast(iterator.getNext());
        }
        return new IteratorElements(L);
    }

    private void rehash(){
        N = p(N >> 1);
        this.A = new Dictionary[N];

        for (int i = 0;i < A.length; i++)
            A[i] = new Dictionary_DLNode(E);

        Iterator entries = this.entries();
        while (entries.hasNext()){
            Entry entry = (Entry) entries.getNext();
            Object k = entry.getKey();
            Object v = entry.getValue();
            A[h(k)].insert(k,v);
        }
    }
}
