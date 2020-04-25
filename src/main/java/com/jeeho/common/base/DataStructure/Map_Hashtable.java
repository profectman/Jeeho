package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.Entry;
import com.jeeho.common.base.DataStructure.interfaces.EqualityTester;
import com.jeeho.common.base.DataStructure.interfaces.Iterator;
import com.jeeho.common.base.DataStructure.interfaces.Map;

public class Map_Hashtable implements Map {

    private int N;

    private Map[] A;

    private final double lemda = 0.75;

    private int size;

    private EqualityTester T;

    public Map_Hashtable() {
    }

    public Map_Hashtable(int n, EqualityTester t) {
        T = t;
        N = p(n);
        A = new Map[N];

        for (int i = 0;i<A.length;i++){
            A[i] = new Map_DLNode(T);
        }
        size = 0;
    }

    /**************************** 辅助方法 ************************************/
    private boolean prime(int n){
        for (int i = 3;i<Math.sqrt(n) + 1 ;i ++){
            if (n/i * i == n) return false;
        }
        return true;
    }

    public int p (int n){
        if (3 > n) return 3;
        while (!prime(n)) n += 1;
        return  n;
    }

    public int h(Object key){
        return key.hashCode() % N;
    }
    /****************************接口方法 *************************************/

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public Object get(Object key) {
        return A[h(key)].get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        Object oldValue = A[h(key)].put(key, value);
        if (null != oldValue){
            size++;
            if (size > N * lemda) rehash();
        }
        return oldValue;
    }

    @Override
    public Object remove(Object key) {
        Object oldValue = A[h(key)].remove(key);
        if (null != oldValue)
            size--;
        return oldValue;
    }

    @Override
    public Iterator entries() {
        return null;
    }

    public void rehash(){
        Iterator iterator = this.entries();
        N = p(N << 1);

        A = new Map[N];
        for (int i =0;i<A.length;i++) A[i] = new Map_DLNode(T);

        while (iterator.hasNext()){
            Entry entry =  (Entry) iterator.getNext();
            Object key = entry.getKey();
            Object value = entry.getValue();
            A[h(key)].put(key,value);
        }
    }
}
