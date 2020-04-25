package com.jeeho.common.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JVMProxyBean<T> implements InvocationHandler {

    private T target ;

    public JVMProxyBean(T t) {
        this.target = t;
    }

    public T createProxy(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * @param proxy    代理生成的对象
     * @param method   代理目标对象里面的方法
     * @param args      代理目标对象方法对应的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置调用
        Object invoke = method.invoke(proxy, args);// 在调用目标对象指定的方法时调用这个类进行数据的拓展
        //后置调用
        return invoke;
    }
}
