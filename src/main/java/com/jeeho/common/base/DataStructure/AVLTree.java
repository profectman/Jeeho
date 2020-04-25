package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.*;

/**
 * 平衡二分查找树
 */
public class AVLTree extends BSTree implements Dictionary {

    public AVLTree() {
    }

    public AVLTree(BinTreePosition root) {
        super(root);
    }

    public AVLTree(Comparator c, BinTreePosition r) {
        super(c, r);
    }

    @Override
    public Entry insert(Object key, Object value) {
        Entry e = super.insert(key,value);
        if (null != e)
            rebalance(lastV.getParent(),root);
        return e;
    }

    @Override
    public Entry remove(Object key) {
        Entry e = super.remove(key);
        if (null != e)
            rebalance(lastV,root);
        return e;
    }

    private BinTreePosition rebalance(BinTreePosition z,BinTreePosition r){
        if (null == z) return r;

        while (true){
            if (isBalanced(z)){
              rotate(z);
            }

            if (!z.hasParent()) return z;

            z = z.getParent();
        }
    }

    private boolean isBalanced(BinTreePosition z) {
        if (null == z) return true;

        int lH = z.hasLChild() ? z.getLChild().getHeight():-1;
        int rH = z.hasRChild() ? z.getRChild().getHeight():-1;

        int dealH = lH - rH; //平衡因子
        return (-1 < dealH) && (1 > dealH);
    }

    private BinTreePosition rotate(BinTreePosition z) {
        BinTreePosition y = tailerChild(z);
        BinTreePosition x = tailerChild(y);
        BinTreePosition a,b,c;
        BinTreePosition T0,T1,T2,T3;
        boolean cType = z.isLChild();
        BinTreePosition p = z.getParent();

        if (y.isLChild()){
            c = z;T3 = z.getRChild();
            if (x.isLChild()){
                b = y;T2 = y.getRChild();
                a = x;T0 = x.getLChild();T1 = x.getRChild();
            }else{
                a = y;T0 = y.getLChild();T1=x.getLChild();
                b = x;T2 = x.getRChild();
            }
        }else{
            a = z;T0 = z.getLChild();
            if (y.isRChild()){
                b = y;T1 = y.getLChild();
                c = x;T2 = x.getLChild();T3 = x.getRChild();
            }else{
                b = x;T3 = y.getRChild();
                c = y;T2 = x.getRChild();T1 = x.getLChild();
            }
        }

        a.secede();
        b.secede();
        c.secede();

        if (null != T0) T0.secede();
        if (null != T1) T1.secede();
        if (null != T2) T2.secede();
        if (null != T3) T3.secede();

        a.attachL(T0);a.attachR(T1);b.attachL(a);
        c.attachL(T2);c.attachR(T3);b.attachR(c);

        if (null != p){
            if (cType)
                p.attachL(b);
            else
                p.attachR(b);
        }
        return p;
    }

    private BinTreePosition tailerChild(BinTreePosition z) {
        int lH = z.hasLChild() ? z.getLChild().getHeight():-1;
        int rH = z.hasRChild() ? z.getRChild().getHeight():-1;

        if (lH > rH){
            return z.getLChild();
        }
        if (lH < rH){
            return z.getRChild();
        }

        if (z.isLChild())
            return z.getLChild();
        else
            return z.getRChild();
    }

}
