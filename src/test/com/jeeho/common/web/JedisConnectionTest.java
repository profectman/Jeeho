package com.jeeho.common.web;

import com.jeeho.common.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-context*.xml")
public class JedisConnectionTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(JedisConnectionTest.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test01(){
        Jedis jedis = new Jedis("localhost", 6379);
        int i = 0;
        long start = System.currentTimeMillis();
        while (true){
            long end = System.currentTimeMillis();
            if((end - start) > 1000){
                break;
            }
            i++;
            jedis.set("redis_"+i,i+"");
        }
        LOGGER.info("redis key is : {} ,value is : {}","redis_"+i,jedis.get("redis_"+i));
    }

    @Test
    public void test02(){
        Role role = new Role();
        role.setId("1");
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        redisTemplate.opsForValue().set("role_1",role);
        Role role1 = (Role) redisTemplate.opsForValue().get("role_1");
        LOGGER.info("role is : {} ",role1);
    }

    @Test
    public void _test02(){
        final Role role = new Role();
        role.setId("1");
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        SessionCallback<Role> sessionCallback = new SessionCallback<Role>() {
            @Override
            public Role execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.boundValueOps("role_1").set(role);
                return (Role) redisOperations.boundValueOps("role_1").get();
            }
        };
        Role role1 = (Role) redisTemplate.execute(sessionCallback);
        LOGGER.info("sessionCallback role is : {} ",role1);
    }

    /**
     * Redis 的六种数据结构
     *
     */

    /**
     * Redis 遵循事务的隔离性，原子性
     * 具体操作命令：
     *      multi       开启redis事务的能力
     *      watch       监听某些键 【key...】
     *      unwatch     取消监听某些键 【key...】
     *      exec        执行事务，如果当前监听的键没有发生改变，则执行，否则回滚
     *      discard     回滚操作
     */

    /**
     *  Redis 订阅模式
     *
     */

    /**
     * Redis 超时命令 ttl
     *
     */

    /**
     * Redis备份(持久化)
     *  1.Redis的备份方式有两种：snapshotting(快照) ,Append only file (AOF) 追加文件的方式
     *    (备份当前时间Redis内缓存存入的数据)         (备份Redis内缓存执行的命令)
     *  2.配置文件说明：
     *      save 900 1
     *      save 300 10
     *      save 60  10000
     *      rdbchecksum yes
     *      dbfilename  dump.db
     *      appendonly  no
     *      appendfilename  "appendonly.aof"
     *      #appendfsync  always
     *      appendfsync   everysec
     *      #appendfsync  no
     *      no-appendfsync-on-rewrite  no
     *      auto-aof-rewrite-percentage 100
     *      auto-aof-rewrite-min-size  64mb
     *      aof-load-truncated  yes
     */

    /**
     * Redis执行回收策略
     * maxmemory-policy
     * maxmemory-samples
     *  volatile-lru
     *  allkeys-lru
     *  volatile-random
     *  allkeys-random
     *  volatile-ttl
     *  noeviction
     */

    /**
     * 复制
     * 1.主从同步
     *    主服务器负责写入数据，不提供读取数据。
     *    从服务器负责同步主服务器的数据，不提供写入数据。
     *    主服务器写入数据后，即刻将写入数据的命令同步到同服务器上，完成数据的同步
     *    应用程序可以随机的从从服务器中读取数据
     *    当一台主服务器故障时，可以从从服务器中选举一台当做主服务器。
     * 2.主从同步的配置：
     *
     */

    /**
     * 哨兵模式(sentiel)
     *  Redis中的一个独立的进程，监控若干台Redis服务器的状态
     *
     *  主从服务器的配置：
     *      bind 0.0.0.0
     *      requirepass "abcdef"
     *      #########从服务器配置#########
     *      slaveof  192.168.11.128  6379
     *      masterauth  abcdef
     *  哨兵配置：
     *      #禁止保护模式
     *      protected-mode  no
     *      #配置监听的主服务器
     *      sentinel monitor mymaster  192.168.11.128 6379 2
     *      sentinel auth-pass mymaster abcdf
     */

    /**
     * 配置默认Redis 注解缓存
     */
}
