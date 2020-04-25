package com.jeeho.common.base.reflect;

import java.lang.reflect.Proxy;

public class Client1 {

    public static void main(String[] args){
        UserServiceImpl userServiceImpl= new UserServiceImpl();
        ClassLoader loader = userServiceImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userServiceImpl.getClass().getInterfaces();

        LogHandler logHandler = new LogHandler(userServiceImpl);

        UserService userService = (UserService) Proxy.newProxyInstance(loader,interfaces,logHandler);

        userService.select();
        userService.update();
        ProxyUtils.generateClassFile(userServiceImpl.getClass(),"UserServiceProxy");
    }
}
