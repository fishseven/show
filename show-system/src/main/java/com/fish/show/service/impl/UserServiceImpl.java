package com.fish.show.service.impl;

import com.fish.show.domain.User;
import com.fish.show.mappers.UserMapper;
import com.fish.show.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 业务层处理
 *
 * @author ruoyi
 */

@Service
public class UserServiceImpl implements IUserService {
    //private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getDetail() {
        return userMapper.getDetail();
    }
}
