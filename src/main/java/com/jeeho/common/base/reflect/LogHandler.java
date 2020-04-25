package com.jeeho.common.base.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * JDK动态代理
 * Proxy
 * InvocationHandler
 */
public class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    private void before(){
        System.out.println(String.format("log start time [%s]",new Date()));
    }

    private void after(){
        System.out.println(String.format("log end time [%s]",new Date()));
    }
}
