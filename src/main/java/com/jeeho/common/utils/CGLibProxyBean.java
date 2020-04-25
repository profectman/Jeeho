package com.jeeho.common.utils;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxyBean<T> implements MethodInterceptor {

    private T target;

    public CGLibProxyBean(T target) {
        super();
        this.target = target;
    }

    public T createProxy(){
        Enhancer enhancer  = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T)enhancer.create();
    }

    /**
     * 回调函数
     * @param o 代理对象
     * @param method 委托类方法
     * @param objects 方法参数
     * @param methodProxy 每个被代理的方法都对应一个MethodProxy对象，
     *                    methodProxy.invokeSuper方法最终调用委托类(目标类)的原始方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //.....
        Object o1 = methodProxy.invokeSuper(o, objects);
        //.....
        return o1;
    }
}
