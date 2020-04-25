package com.jeeho.common.base.collection.tree;

public class TreeLinkedList implements Tree {

    private Object elem;

    private TreeLinkedList parent;

    private TreeLinkedList firstChild;

    private TreeLinkedList nextSubling;

    @Override
    public Object getElem() {
        return elem;
    }

    @Override
    public void setElem(Object elem) {
        this.elem = elem;
    }

    @Override
    public TreeLinkedList getParent() {
        return null;
    }

    @Override
    public TreeLinkedList getFirstChild() {
        return firstChild;
    }

    @Override
    public TreeLinkedList getNextSubling() {
        return nextSubling;
    }

    /**
     * 以当前节点作为根节点的树的后代节点的数目
     * 递归获取所有子节点的数目
     * @return
     */
    @Override
    public int getSize() {
        int size = 1;
        TreeLinkedList subtree = firstChild;
        while (subtree != null){
            size += subtree.getSize();
            subtree = subtree.getNextSubling();
        }
        return size;
    }

    /**
     * 返回当前节点的高度
     * @return
     */
    @Override
    public int getHeight() {
        int heigth = -1;
        TreeLinkedList subtree = firstChild;
        while (firstChild != null){
            heigth = Math.max(heigth,subtree.getHeight());
            subtree = subtree.getNextSubling();
        }
        return heigth + 1;
    }

    @Override
    public int getDepth() {
        int depth = 0;
        TreeLinkedList p = parent;
        while (p != null){
            depth++;
            p = p.getParent();
        }
        return depth;
    }
}
