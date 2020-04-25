package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionBoundaryViolation;
import com.jeeho.common.base.DataStructure.interfaces.Vector;

public class Vector_Array implements Vector {

    private Object[] A;

    private int n;

    private  int N =1024;

    public Vector_Array() {
        A = new Object[N];
        n=0;
    }

    @Override
    public int getSize() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        if (r < 0 || r > n)
            throw new ExceptionBoundaryViolation("意外：越界!");
        return A[r];
    }

    @Override
    public Object replaceAtRank(int r, Object elem) throws ExceptionBoundaryViolation {
        if (r < 0 || r > n)
            throw new ExceptionBoundaryViolation("意外：越界!");
        Object obj = A[r];
        A[r] = elem;
        return obj;
    }

    @Override
    public Object insertAtRank(int r, Object elem) throws ExceptionBoundaryViolation {
        if (r < 0 || r > n)
            throw new ExceptionBoundaryViolation("意外：越界！");
        for (int i = n;i > r;i--) A[i] = A[i-1];
        Object obj = A[r];
        A[r] = elem;
        n++;
        return obj;
    }

    /**
     * 动态扩容
     * @param r
     * @param elem
     * @return
     * @throws ExceptionBoundaryViolation
     */
    public Object insertAtRank1(int r,Object elem) throws ExceptionBoundaryViolation{
        if (r < 0 || r > n)
            throw new ExceptionBoundaryViolation("意外：越界！");

        Object[] B = null;
        if(n >= N){
            B = new Object[2*N];
            for (int i = 0;i < getSize();i++) B[i] = A[i];
            A = B;
        }

        for (int i = n;i > r;i--) A[i] = A[i-1];
        Object obj = A[r];
        A[r] = elem;
        n++;
        return obj;
    }


    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        if (r < 0 || r > n)
            throw new ExceptionBoundaryViolation("意外：越界!");
        Object obj = A[r];
        for (int i = r;i < n;i++) A[i] = A[i+1];
        n--;
        return obj;
    }
}
