package com.jeeho.common.service;

import com.jeeho.common.persistence.SysRole;
import com.jeeho.common.persistence.SysRoleMapper;
import com.jeeho.common.persistence.User4;
import com.jeeho.common.persistence.User4Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseService {

    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    User4Mapper user4Mapper;

    public String getSysRoleNameById(String id){
        return sysRoleMapper.getSysRoleName(id);
    }

    public SysRole getSysRoleById(String id){
        return sysRoleMapper.getSysRole(id);
    }

    @Transactional()
    public void updateSysRole(SysRole sysRole){
        sysRoleMapper.updateSysRole(sysRole);
    }

    public void aspectJTest(){
        System.out.println("目标函数输出......");
    }

    public User4 getUserById(Integer id){
        return user4Mapper.getUser4ById(id);
    }

    @Transactional()
    public void insertUser(User4 user4){
        user4Mapper.insertUser4(user4);
    }
}
