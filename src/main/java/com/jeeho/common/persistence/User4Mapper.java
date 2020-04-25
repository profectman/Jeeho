package com.jeeho.common.persistence;

import org.apache.ibatis.annotations.Param;

public interface User4Mapper {

    User4 getUser4ById(@Param("id") int id);

    void insertUser4(User4 user4);
}
