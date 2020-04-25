package com.jeeho.common.persistence.dao;

import com.jeeho.common.persistence.pojo.User;
import com.jeeho.common.persistence.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);
    int deleteByExample(UserExample example);
    int deleteByPrimaryKey(Integer id);
    int insert(User record);
    int insertSelective(User record);
    List<User> selectByExample(UserExample example);
    User selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);

    /**
     * @param username
     * @param password
     * @return
     */
    User selectLogin(@Param("username") String username,@Param("password") String password);

    int autoIncExample01(@Param("user")User user);

    int autoIncExample02(@Param("user")User user);


}