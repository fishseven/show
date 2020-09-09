package com.fish.show.controller;

import com.fish.show.service.ThreadPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: Fish
 * @Date: 2020-09-09 21:19
 */
@RestController
public class TestThreadPoolController {

    @Autowired
    ThreadPoolService threadPoolService;
    @PostMapping("/1")
    public String testTreadPool(){

        for (int i=0;i<100;i++){
            threadPoolService.testPool();
        }
        return "pool test";

    }

    @PostMapping("/2")
    public String testTreadPool2(){

        for (int i=0;i<100;i++){
            threadPoolService.testNoPool();
        }
        return "pool test";

    }

    @PostMapping("/3")
    public String testTreadPool3 (){

        for (int i=0;i<100;i++){
            long startTime = System.currentTimeMillis();
            try {
                threadPoolService.testPoolTaskExecutor(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("poolTask test "+(endTime-startTime)/1000+" 秒");
        }
        return "pool test";

    }




}
