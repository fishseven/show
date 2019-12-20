package com.fish.show.controller;


import com.fish.show.domain.User;
import com.fish.show.service.IUserService;
import com.fish.show.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUserService userService;

    @Autowired
    private TestService testService;
    @GetMapping("/getId")
    public String getId(String id){
        return "1";
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
}
