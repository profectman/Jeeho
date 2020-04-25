package com.jeeho.common.persistence;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {

    String getSysRoleName(@Param("id")String id);

    SysRole getSysRole(@Param("id")String is);

    void updateSysRole(@Param("sysRole")SysRole sysRole);
}
