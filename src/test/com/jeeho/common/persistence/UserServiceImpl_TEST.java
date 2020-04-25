package com.jeeho.common.persistence;

import com.jeeho.common.persistence.dao.UserMapper;
import com.jeeho.common.persistence.pojo.User;
import com.jeeho.common.utils.MD5Util;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class UserServiceImpl_TEST {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl_TEST.class);
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        String resource = "mybatis-config-test.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01(){
        String username = "admin";
        String password = MD5Util.MD5EncodeUtf8("admin");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectLogin(username,password);

        logger.info("user : " + user.toString());
    }
}
