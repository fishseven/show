package com.fish.show.mappers;

import com.fish.show.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表 数据层
 * 
 * @author ruoyi
 */
@Mapper
public interface UserMapper {
     List<User> getDetail();
}
