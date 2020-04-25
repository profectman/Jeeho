package com.jeeho.common.netty.rpc.v1;

public class CaculatorServiceImpl implements CaculatorService {
    @Override
    public double add(double op1, double op2) {
        return op1 + op2;
    }

    @Override
    public double substract(double op1, double op2) {
        return op1 - op2;
    }

    @Override
    public double multiply(double op1, double op2) {
        return op1 * op2;
    }
}
