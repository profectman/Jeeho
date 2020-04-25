package com.jeeho.common.base.reflect;

import java.util.Date;

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {

    private UserService target;

    public UserServiceProxy(UserService userServiceImpl) {
        this.target = userServiceImpl;
    }

    @Override
    public void select() {
        before();
        target.select();
        after();
    }

    @Override
    public void update() {
        before();
        target.update();
        after();
    }

    private void before(){
        System.out.println(String.format("log start time [%s]",new Date()));
    }

    private void after(){
        System.out.println(String.format("log end time [%s]",new Date()));
    }

    public static void main(String[] args){
        UserService userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.select();
        userServiceProxy.update();
    }
}
