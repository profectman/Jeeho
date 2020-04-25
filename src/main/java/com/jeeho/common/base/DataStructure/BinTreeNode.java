package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.*;

public class BinTreeNode implements BinTreePosition {

    private BinTreePosition parent,lChild,rChild;

    private int height,depth,size;

    private Object elem;

    public BinTreeNode() {
        this(null,null,null,true,null);
    }

    public BinTreeNode(BinTreePosition p, BinTreePosition l, BinTreePosition r, boolean isLChild, Object elem){
        size = 1;
        parent = lChild = rChild = null;
        depth = height = 0;

        this.elem = elem;

        if (null != p){
            if (isLChild)
                p.attachL(this);
            else
                p.attachR(this);
        }

        if (null != l)
            attachL(l);
        if (null != r)
            attachR(r);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void updateSize() {
        size = 1;
        if (hasLChild()) size += getLChild().getSize();
        if (hasRChild()) size += getRChild().getSize();

        if (hasParent()) getParent().updateSize();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void updateHeight() {
        height = 0;
        if (hasRChild()) height = Math.max(height,1+getRChild().getHeight());
        if (hasLChild()) height = Math.max(height,1+getRChild().getHeight());

        if (hasParent()) getParent().updateHeight();
    }

    @Override
    public int getDepth() {
        return depth;
    }

    @Override
    public void updateDepth() {
        depth = hasParent() ? getParent().getDepth() : 0;

        if (hasLChild()) getLChild().updateDepth();
        if (hasRChild()) getRChild().updateDepth();
    }

    @Override
    public boolean isLeaf() {
        return !hasLChild() && !hasRChild();
    }

    @Override
    public boolean hasParent() {
        return null!=parent;
    }

    @Override
    public BinTreePosition getParent() {
        return parent;
    }

    @Override
    public void setParent(BinTreePosition p) {
        this.parent = p;
    }

    @Override
    public boolean isLChild() {
        return (hasParent() && this == getParent().getLChild())?true:false;
    }

    @Override
    public boolean hasLChild() {
        return null != lChild;
    }

    @Override
    public BinTreePosition getLChild() {
        return lChild;
    }

    @Override
    public void setLChild(BinTreePosition c) {
        this.lChild = c;
    }

    @Override
    public boolean isRChild() {
        return (hasParent() && this == getParent().getRChild())?true:false;
    }

    @Override
    public boolean hasRChild() {
        return null != rChild;
    }

    @Override
    public BinTreePosition getRChild() {
        return rChild;
    }

    @Override
    public void setRChild(BinTreePosition c) {
        this.rChild = c;
    }

    @Override
    public BinTreePosition getPrev() {
        if (hasLChild()) return findMaxDescendant(getLChild());

        if (isRChild()) return getParent();

        BinTreePosition v = this;
        while (v.isRChild()) v = v.getParent();

        return v.getParent();
    }

    @Override
    public BinTreePosition getSucc() {
        if (hasRChild()) return findMinDescendant(getRChild());

        if (isLChild()) return getParent();

        BinTreePosition v = this;
        while (v.isLChild()) v = v.getParent();
        return v.getParent();
    }

    @Override
    public BinTreePosition attachL(BinTreePosition c) {
        if (hasLChild()) getLChild().secede();

        while (null != c){
            c.secede();

            setLChild(c);
            updateHeight();
            updateSize();

            c.updateDepth();
        }
        return this;
    }

    @Override
    public BinTreePosition attachR(BinTreePosition c) {
        if (hasRChild()) getRChild().secede();

        while (null != c){
            c.secede();

            setRChild(c);
            updateSize();
            updateHeight();

            c.updateDepth();
        }
        return this;
    }

    @Override
    public BinTreePosition secede() {
        if (null != parent){
            if (isLChild()) parent.setLChild(null);
            else
                parent.setRChild(null);

            parent.updateSize();
            parent.updateHeight();

            this.updateDepth();
            parent = null;
        }
        return this;
    }

    @Override
    public Iterator elementsPreOrder() {
        List list = new List_DLNode();
        preOrder(list,this);
        return list.elements();
    }

    @Override
    public Iterator elementsPostOrder() {
        List list = new List_DLNode();
        postOrder(list,this);
        return list.elements();
    }

    @Override
    public Iterator elementsInOrder() {
        List list = new List_DLNode();
        inOrder(list,this);
        return list.elements();
    }

    @Override
    public Iterator elementsLevelOrder() {
        List list = new List_DLNode();
        levelOrder(list,this);
        return list.elements();
    }

    @Override
    public Object SetElem(Object newElem) {
        return null;
    }

    @Override
    public Object getElem() {
        return null;
    }

    private void preOrder(List list,BinTreePosition v){
        if (null == v) return;
        list.insertLast(v);
        preOrder(list, v.getLChild());
        preOrder(list, v.getRChild());

    }

    private void inOrder(List list,BinTreePosition v){
        if (null == v) return;
        inOrder(list, v.getLChild());
        list.insertLast(v);
        inOrder(list, v.getRChild());
    }

    private void postOrder(List list,BinTreePosition v){
        if (null == v) return;
        postOrder(list, v.getLChild());
        postOrder(list, v.getRChild());
        list.insertLast(v);
    }

    private void levelOrder(List list,BinTreePosition v){
        Queue Q = new Queue_List();
        Q.enqueue(v);
        while (!Q.isEmpty()){
            BinTreePosition subtree = (BinTreePosition) Q.dequeue();
            list.insertLast(subtree);
            if (subtree.hasLChild()) Q.enqueue(subtree.getLChild());
            if (subtree.hasRChild()) Q.enqueue(subtree.getRChild());
        }
    }

    private BinTreePosition findMaxDescendant(BinTreePosition v){
        if (null != v)
            while (v.hasRChild()) v = v.getRChild();
        return v;
    }

    private BinTreePosition findMinDescendant(BinTreePosition v){
        if (null != v)
            while (v.hasLChild()) v = v.getLChild();
        return v;
    }
}
