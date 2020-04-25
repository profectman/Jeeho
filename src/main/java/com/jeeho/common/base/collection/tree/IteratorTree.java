package com.jeeho.common.base.collection.tree;

import java.util.Iterator;
import java.util.List;

/**
 * 什么是迭代器，就是对集合中所有数据生成一个快照，保存在迭代器对应的容器中。
 *
 */
public class IteratorTree implements Iterator {

    private List list;

    public IteratorTree(){list = null;}

    /**
     * 前序遍历
     * @param T
     */
    public void elementsPreorderIterator(TreeLinkedList T){
        if (null == T) return;

        list.add(T);

        TreeLinkedList subtree = T.getFirstChild();
        while (subtree != null){
            elementsPreorderIterator(subtree);
            subtree = T.getNextSubling();
        }
    }

    /**
     * 后序遍历
     * @param T
     */
    public void elementPostorderIterator(TreeLinkedList T){
        if (null == T) return;

        TreeLinkedList subtree = T.getFirstChild();
        while (subtree != null){
            elementPostorderIterator(subtree);
            subtree.getNextSubling();
        }

        list.add(T);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
