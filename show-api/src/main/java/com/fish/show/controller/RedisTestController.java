package com.fish.show.controller;

import org.redisson.RedissonBucket;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @Author: Fish
 * @Date: 2020-08-27 23:46
 */
@RestController
@RequestMapping("/test")
public class RedisTestController {


    @Autowired
    private RedissonClient redissonClient;

    @PostMapping("/getKey")
    public String test(){
        Date date = new Date();

        RBucket<String> bucket = redissonClient.getBucket("dump-2");
//        String testStr = "str002";
//        bucket.set(testStr);
        String aa =  bucket.get();
        System.out.println(aa);
        return aa;
    }
}
