package com.jiaty.demo.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.File;

/**
 * @program: Practice
 * @description: redisson
 * @author: Jiaty
 * @create: 2020-07-03 10:34
 **/

public class RedissonTest {

    private void createRedisConno(){
        Config config = new Config();
        config.useClusterServers()
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://127.0.0.1:6379");
        //config = Config.fromJSON(new File())
        RedissonClient redisson = Redisson.create(config);
        redisson.getLock("");
    }



    public static void main(String[] args) {

    }

}