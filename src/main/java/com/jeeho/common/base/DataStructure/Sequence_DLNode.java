package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionBoundaryViolation;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionPositionInvalid;
import com.jeeho.common.base.DataStructure.interfaces.Position;
import com.jeeho.common.base.DataStructure.interfaces.Sequence;

/**
 * 基于 向量和列表的结合
 */
public class Sequence_DLNode extends List_DLNode implements Sequence {

    private void checkRank(int r,int n){
        if (r < 0 || r > n)
            throw new ExceptionBoundaryViolation("意外：非法的轶 " + r + ",应属于[0,"+n+"]");
    }

    @Override
    public Position rank2Pos(int r) throws ExceptionBoundaryViolation {
        DLNode node;

        checkRank(r,getSize());

        if (r < getSize()/2){
            node = header.getNext();
            while(r > 0){
                node = node.getNext();
                r--;
            }
        }else{
            node = tailer.getPrev();
            while (r > 0){
                node = node.getPrev();
                r--;
            }
        }
        return node;
    }

    @Override
    public Object Pos2Rank(Position p) throws ExceptionPositionInvalid {
        DLNode v = header.getNext();
        int r = 0;

        while(v != null){
            if (p == v)
                return r;
            v = v.getNext();
            r++;
        }
        throw new ExceptionPositionInvalid("意外：作为参数的位置不存在！");
    }

    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        checkRank(r,getSize());
        return rank2Pos(r).getElem();
    }

    /**
     * 返回被替换的元素
     * @param r
     * @param elem
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Object replaceAtRank(int r, Object elem) throws ExceptionBoundaryViolation {
        checkRank(r,getSize());
        Position p = rank2Pos(r);
        return replace(p, elem);
    }

    @Override
    public Object insertAtRank(int r, Object elem) throws ExceptionBoundaryViolation {
        checkRank(r,getSize());

        Position p = rank2Pos(r);
        if (r == getSize())
            insertLast(elem);
        else
            insertBefore(p,elem);
        return elem;
    }

    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        checkRank(r,getSize());
        return remove(rank2Pos(r));
    }
}
