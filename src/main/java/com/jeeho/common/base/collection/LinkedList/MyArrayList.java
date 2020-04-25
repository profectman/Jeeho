package com.jeeho.common.base.collection.LinkedList;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements IList<T>,Iterable<T>,Serializable {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private int size;  //当前数据长度

    private int modCount;  //记录修改次数

    private T[] elementData;

    /**
     * 有参构造器初始化
     * @param initialCapacity
     */
    public MyArrayList(int initialCapacity){
        if(initialCapacity > 0){
            this.elementData = (T[])new Object[initialCapacity];
        }else if(initialCapacity == 0){
            this.elementData = (T[])EMPTY_ELEMENTDATA;
        }else{
            throw new IllegalArgumentException("IllegalArgument exception");
        }
    }

    /**
     * 默认无参构造器初始化
     */
    public MyArrayList(){
        this.elementData = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 根据需求扩容
     * @param capacity
     */
    public void ensureCapacity(int capacity){
        if(capacity < size)   //当需要扩充的容量小于当前容器容量时，无需扩容。
            return;

        T[] old = this.elementData;
        this.elementData = (T[])new Object[capacity];
        this.modCount++;
        for(int i=0;i<size();i++)
            elementData[i] = old[i];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(T data) {
        return indexOf(data) >= 0;
    }

    @Override
    public void clear() {
        this.modCount ++;

        for(int i=0;i<size();i++)
            this.elementData[i]=null;

        size = 0;
    }

    /**
     * 下标检测
     * @param index
     */
    public void rangeCheck(int index){
        if(index <0 || index >= size())
            throw new IndexOutOfBoundsException("index: " + index + "size: "+ size);
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return this.elementData[index];
    }

    @Override
    public T set(int index, T data) {
        rangeCheck(index);

        T oldData = this.elementData[index];
        this.modCount++;

        this.elementData[index] = data;
        return oldData;
    }

    @Override
    public boolean add(T data) {
        add(size(),data);
        return true;
    }

    @Override
    public void add(int index, T data) {
        rangeCheck(index);

        if(elementData.length == size())
            ensureCapacity(2*size()+1);

        for(int i=size-1;i>index;i--){
            this.elementData[i] = this.elementData[i-1];
        }
        this.elementData[index] = data;
        this.size++;
        this.modCount++;
    }

    @Override
    public boolean remove(T data) {

        if(data == null){
            throw new NullPointerException("data can\'t remove");
        }else{
            for(int index =size()-1;index>=0;index--)
                if(data.equals(this.elementData[index])){
                    this.remove(index);
                    return true;
                }
        }

        return false;
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);
        this.modCount++;

        T oldData = this.elementData[index];
        for(int i=index;i<size()-1;i++){
            this.elementData[i] = this.elementData[i+1];
        }

        this.elementData[--size] = null;
        return oldData;
    }

    @Override
    public int indexOf(T data) {
        if(data == null){
            for(int i=0;i<size();i++){
                if(this.elementData[i] == null){
                    return i;
                }
            }
        }else{
            for(int i=0;i<size();i++){
                if(data.equals(this.elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        if(data == null){
            for(int i=size()-1;i>=0;i--){
                if(this.elementData[i] == null){
                    return i;
                }
            }
        }else{
            for(int i=size()-1;i>=0;i--){
                if(data.equals(this.elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr<T>();
    }

    private class Itr<T> implements Iterator<T>{

        int cursor; //将要访问的下标

        int lastRet = -1; //当前正在访问的下标

        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            checkComodification();
            int i = cursor;

            if(i > size()){
                throw new NoSuchElementException();
            }
            Object[] elementData = MyArrayList.this.elementData;
            if(i >= elementData.length){
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (T)elementData[i];
        }

        @Override
        public void remove() {
            if(lastRet<0)
                throw new IllegalStateException();
            checkComodification();
            try {
                MyArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (Exception e) {
                throw new ConcurrentModificationException();
            }
        }

        /**
         * 检测modCount标识
         */
        final void checkComodification(){
            if(modCount!=expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

}
