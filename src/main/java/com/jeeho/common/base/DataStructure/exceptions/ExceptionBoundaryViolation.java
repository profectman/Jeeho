package com.jeeho.common.base.DataStructure.exceptions;

/**
 * 数组越界异常
 */
public class ExceptionBoundaryViolation extends RuntimeException{

    public ExceptionBoundaryViolation(String message) {
        super(message);
    }
}
