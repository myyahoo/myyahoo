package com.example.myyahoo.mapper;

import com.example.myyahoo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserEntity> getUserList();
}

