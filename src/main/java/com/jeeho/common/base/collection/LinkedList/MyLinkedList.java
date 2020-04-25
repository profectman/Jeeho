package com.jeeho.common.base.collection.LinkedList;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements IList<T>,Iterable<T>,Serializable {

    protected int size;

    protected int modCount;

    protected Node<T> first;

    protected Node<T> lastRet;

    /**
     * 构造器链表初始化
     */
    public MyLinkedList(){
        this.first = new Node<T>(null,null,null);
        this.lastRet = new Node<T>(null,first,null);
        this.first.next = lastRet;
        size = 0;
        modCount++;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T data) {
        return null;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public void add(int index, T data) {

    }

    @Override
    public boolean remove(T data) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(T data) {
        return 0;
    }

    @Override
    public int lastIndexOf(T data) {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    /**
     * 根据index获取链表中节点
     * @param index
     * @return
     */
    Node<T> getNode(int index){
        if(index > (size >> 1)){
            Node<T> x = first.prev;
            for(int i=0;i<index;i++){
                x = x.next;
            }
            return x;
        }else{
            Node<T> x = lastRet.prev;
            for(int i=size-1;i>index;i--){
                x = x.prev;
            }
            return x;
        }
    }

    /**
     * 链表中删除节点
     * @param x
     * @return
     */
    T unLink(Node<T> x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
        modCount++;
        return x.data;
    }

    /**
     * 在succ节点前插入节点
     * @param t
     * @param succ
     */
    void linkBefore(T t,Node<T> succ){
        final Node<T> newNode = new Node<T>(t,succ.prev,succ);
        succ.prev.next = newNode;
        succ.prev = newNode;
        size++;
        modCount++;
    }

    /**
     * 在链表头部插入节点
     * @param data
     */
    void linkFirst(T data){
        final Node<T> f = first.next;
        final Node<T> newNode = new Node<>(data,first,f);
        f.prev = newNode;
        first.next = newNode;
        size++;
        modCount++;
    }

    /**
     * 在链表尾部插入节点
     * @param data
     */
    void linkLast(T data){
        final Node<T> l = lastRet.prev;
        final Node<T> newNode = new Node<>(data,l,lastRet);
        lastRet.prev = newNode;
        l.next =newNode;
        size++;
        modCount++;
    }

    private class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;
        public Node(T data,Node<T> prev,Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private class Itr implements Iterator<T> {
        /**
         * 指向下一个结点的下标
         */
        int cursor = 0;

        /**
         * 当前需要返回结点的下标
         */
        int lastRet = -1;

        /**
         *用于判断是否集合被修改
         */
        int expectedModCount = modCount;

        /**
         * 是否还有下一个结点
         * @return
         */
        public boolean hasNext() {
            return cursor != size();
        }

        /**
         * 获取当前结点的值
         * @return
         */
        public T next() {
            checkForComodification();
            try {
                int i = cursor;
                T next = get(i);
                lastRet = i;//指向当前结点
                cursor = i + 1;//更新,指向下一个还未访问的结点
                return next;
            } catch (IndexOutOfBoundsException T) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                MyLinkedList.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;//回撤一位
                lastRet = -1;//复原
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException T) {
                throw new ConcurrentModificationException();
            }
        }

        /**
         * 检测是否集合已变更
         * 快速失败机制
         */
        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

}
