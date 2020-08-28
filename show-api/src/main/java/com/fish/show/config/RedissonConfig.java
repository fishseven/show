package com.fish.show.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.FstCodec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson配置
 * 目前使用的是腾讯云的单节点redis，所以暂时配置单服务
 *
 *
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;


    @Bean
    public RedissonClient getRedisson(){

        Config config = new Config();
//        config.setCodec(new JsonJacksonCodec());
        config.setCodec(new FstCodec());
        config.useSingleServer().setAddress("redis://" + host + ":" + port);
        //添加主从配置
//        config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});

        return Redisson.create(config);
    }

}