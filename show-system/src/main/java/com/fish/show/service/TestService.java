package com.fish.show.service;

import com.fish.show.domain.User;
import com.fish.show.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private UserMapper userMapper;


    public List<User> getDetail(){
        return userMapper.getDetail();
    }
}
