package com.fish.show.controller;


import com.fish.show.domain.User;
import com.fish.show.service.IUserService;
import com.fish.show.service.TestService;
import com.fish.show.thread.MyThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUserService userService;

    @Autowired
    private TestService testService;

    @PostMapping("/getId")
    public String getId(String id){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("id:"+id);
        return "id:"+id;
    }

    @GetMapping("/getList")
    public List<User> getList(){
        List<User> userList = userService.getDetail();
        return userList;
    }

    @GetMapping("/getDetail")
    public List<User> getDetail(){
        List<User> userList = testService.getDetail();
        return userList;
    }


    public static void main(String[] args){
        MyThread thread = new MyThread("thread1") {

            @Override
            public void run() {
                System.out.println("123");
                System.out.println(this.getName());
            }
        };
//        thread.start();


        ExecutorService singPool = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            singPool.execute(thread);
        }
        singPool.shutdown();
    }
}
