package com.jeeho.common.base.reflect;

public class UserServiceImpl implements UserService{
    @Override
    public void select() {
        System.out.println("查询：selectById");
    }

    @Override
    public void update() {
        System.out.println("更新：update");
    }
}
