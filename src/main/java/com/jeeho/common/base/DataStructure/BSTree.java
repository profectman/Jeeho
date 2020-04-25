package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.*;

public class BSTree extends BinTreeLinkedList implements Dictionary {

    protected Comparator C;
    protected BinTreePosition lastV;  //最后一次操作的节点，方便AVL树，伸展树进行平衡

    public BSTree() {
        this(new ComparatorDefault(),null);
    }

    public BSTree(BinTreePosition root) {
        this(new ComparatorDefault(),root);
    }

    public BSTree(Comparator c, BinTreePosition r) {
        C = c;
        root = r;
    }

    @Override
    public Entry find(Object key) {
        if (isEmpty()) return null;
        BSTreeNode u = binSearch((BSTreeNode)root,key,C);
        return 0 == C.compareTo(u.getKey(),key)?(Entry) u.getElem():null;
    }

    @Override
    public Iterator findAll(Object key) {
        List list = new List_DLNode();
        findAllNodes((BSTreeNode)root,key,list,C);
        return list.elements();
    }

    @Override
    public Entry insert(Object key, Object value) {
        Entry e = new EntryDefault(key,value);

        if (isEmpty())
            lastV = new BSTreeNode(null,null,null,true,e);
        else {
            BSTreeNode p = (BSTreeNode) root;
            boolean asLeftChild;

            while (true){
                p = binSearch(p,key,C);

                if (0 < C.compareTo(p.getKey(),key)) {
                    asLeftChild = false;
                    break;
                }else if (0 > C.compareTo(p.getKey(),key)) {
                    asLeftChild = true;
                    break;
                }else if (!p.hasLChild()) {
                    asLeftChild = true;
                    break;
                }else if (!p.hasRChild()) {
                    asLeftChild = false;
                    break;
                }else
                    p = (BSTreeNode) p.getLChild();
            }
            lastV = new BSTreeNode(p,null,null,asLeftChild,e);
        }
        return e;
    }

    @Override
    public Entry remove(Object key) {
        if (isEmpty()) return null;

        BinTreePosition v= binSearch((BSTreeNode)root,key,C);
        if (v.hasLChild()){
            BinTreePosition w =  v.getPrev();
            w.SetElem(v.SetElem(w.getElem()));
            v = w;
        }

        lastV = v.getParent();
        BinTreePosition u = v.hasLChild()?v.getLChild():v.getRChild();
        if (null == lastV) {
            if (u != null){
                u.secede();
                root = u;
            }
        }else{
           if (v.isLChild()){
               v.secede();
               lastV.attachL(u);
           }else{
               v.secede();
               lastV.attachR(u);
           }
        }
        return (Entry)v.getElem();
    }

    @Override
    public Iterator entries() {
        List list = new List_DLNode();
        concatenate(list,(BSTreeNode) root);
        return list.elements();
    }

    private BSTreeNode binSearch(BSTreeNode v,Object key,Comparator c){
        BSTreeNode u = v;
        while (true){
            if (c.compareTo(u.getKey(),key) > 0 )
                if (u.hasRChild()) u = (BSTreeNode) u.getRChild();
                else return u;
            else if (c.compareTo(u.getKey(),key) < 0)
                if (u.hasLChild()) u = (BSTreeNode) u.getLChild();
                else return u;
            else
                return u;
        }
    }

    private void findAllNodes(BSTreeNode v,Object key,List list,Comparator c){
        if (v == null) return;

        int comp = c.compareTo(v.getKey(),key);

        if (comp >= 0) findAllNodes((BSTreeNode) v.getRChild(),key,list,c);
        if (comp == 0) list.insertLast(v.getElem());
        if (comp <= 0) findAllNodes((BSTreeNode)v.getLChild(),key,list,c);
    }

    private void concatenate(List list,BSTreeNode v){
        if (v == null) return;

        concatenate(list,(BSTreeNode)v.getLChild());
        list.insertLast(v.getElem());
        concatenate(list,(BSTreeNode)v.getRChild());
    }
}
