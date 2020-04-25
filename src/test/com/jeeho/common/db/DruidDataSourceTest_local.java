package com.jeeho.common.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-context*.xml")
public class DruidDataSourceTest_local {

    private final static Logger log = LoggerFactory.getLogger(DruidDataSourceTest_local.class);

    @Autowired
    DruidDataSource druidDataSource;

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Test
    public void test01() throws Exception{
        System.out.println("数据库连接测试："+druidDataSource.getConnection());
    }

    @Test
    public void test02(){
        System.out.println("redis 数据库连接：" + jedisConnectionFactory.getConnection());
    }
}
