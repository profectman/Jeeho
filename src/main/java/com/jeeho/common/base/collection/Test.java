package com.jeeho.common.base.collection;

public abstract class Test<C> {

    String name;

    public Test(String name){
        this.name = name;
    }

    abstract int test(C containter,TestParam tp);
}
