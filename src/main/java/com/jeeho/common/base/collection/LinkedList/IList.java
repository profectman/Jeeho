package com.jeeho.common.base.collection.LinkedList;

public interface IList<T> {
    /**
     * list大小
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含data
     * @param data
     * @return
     */
    boolean contains(T data);

    /**
     * 清空list数据
     */
    void clear();

    /**
     * 获取list中指定位置对象
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 在list中指定位置插入对象
     * @param index
     * @param data
     * @return
     */
    T set(int index,T data);

    /**
     * 尾部插入数据，返回判断是否插入成功
     * @param data
     * @return
     */
    boolean add(T data);

    /**
     * 在指定位置插入数据
     * @param index
     * @param data
     */
    void add(int index,T data);

    /**
     * 删除指定对象
     * @param data
     * @return
     */
    boolean remove(T data);

    /**
     * 删除指定位置对象
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * 获取第一次查找对象位置
     * @param data
     * @return
     */
    int indexOf(T data);

    /**
     * 获取最后一次查找到对象位置
     * @param data
     * @return
     */
    int lastIndexOf(T data);
}
