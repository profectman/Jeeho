package com.jeeho.common.base.DataStructure.interfaces;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionBoundaryViolation;

public interface Vector {

    int getSize();

    boolean isEmpty();

    Object getAtRank(int r) throws ExceptionBoundaryViolation;

    Object replaceAtRank(int r,Object elem) throws ExceptionBoundaryViolation;

    Object insertAtRank(int r,Object elem) throws ExceptionBoundaryViolation;

    Object removeAtRank(int r) throws ExceptionBoundaryViolation;
}
