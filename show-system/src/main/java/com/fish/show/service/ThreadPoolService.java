package com.fish.show.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: Fish
 * @Date: 2020-09-09 22:11
 */
@Service
public class ThreadPoolService {

    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor poolTaskExecutor;

    @Async
    public void testPool() {
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    public void testNoPool() {
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    public int testPoolTaskExecutor(int n) throws InterruptedException, ExecutionException {
        CountDownLatch countDownLatch = new CountDownLatch(n);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            final int index = i;
            final Future<Integer> future = poolTaskExecutor.submit(() -> {
                Thread.sleep(5000);
                System.out.println(simpleDateFormat.format(new Date())+" "+Thread.currentThread().getName() + " 执行 " + index);
                countDownLatch.countDown();
                return 1;
            });
        }
        countDownLatch.await();
        return sum;
    }
}
