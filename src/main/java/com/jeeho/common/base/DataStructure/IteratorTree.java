package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.Iterator;
import com.jeeho.common.base.DataStructure.interfaces.List;
import com.jeeho.common.base.DataStructure.interfaces.Position;
import com.jeeho.common.base.DataStructure.interfaces.Queue;

public class IteratorTree implements Iterator {

    List list;
    Position nextPosition;

    public IteratorTree() {
        this.list = null;
    }

    /**
     * 前序遍历
     * @param T
     */
    public void elementsPreorderIterator(TreeLinkedList T){
        if (null == T) return;

        list.insertLast(T);
        TreeLinkedList subtree = T.getFirstChild();

        while (null != subtree){
            elementsPreorderIterator(subtree);
            subtree = subtree.getNextSibling();
        }
    }

    public void elementsPostorderIterator(TreeLinkedList T){
        if (null == T) return;

        TreeLinkedList subtree = T.getFirstChild();

        while (null != subtree){
            elementsPostorderIterator(subtree);
            subtree = subtree.getNextSibling();
        }

        list.insertLast(T);
    }

    public void levelTraversalIterator(TreeLinkedList T){
        if (null == T) return;
        Queue Q = new Queue_List();

        Q.enqueue(T);

        while (!Q.isEmpty()){
            TreeLinkedList tree = (TreeLinkedList) Q.dequeue();
            list.insertLast(tree);

            TreeLinkedList subtree = tree.getFirstChild();
            while (null != subtree){
                Q.enqueue(subtree);
                subtree = subtree.getNextSibling();
            }
        }
    }

    @Override
    public boolean hasNext() {
        return null != nextPosition;
    }

    @Override
    public Object getNext() {
        Position currentPosition = nextPosition;

        Position next = list.getNext(currentPosition);
        if (next == list.last()){
            nextPosition = null;
        }else
            nextPosition = list.getNext(currentPosition);
        return currentPosition.getElem();
    }
}
