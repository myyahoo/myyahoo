package com.example.myyahoo.service;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.dao.UserDao;
import com.example.myyahoo.dto.UserDto;
import com.example.myyahoo.entity.UserEntity;
import com.example.myyahoo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserMapper userMapper;

    public List<UserDto> getList(Integer page,String keyword) throws Exception{

        Integer startNo = (page-1) * Constants.listOffset;

        //List<UserEntity> userEntityList = userDao.getUserlist();
        List<UserEntity> userEntityList = userMapper.getUserList();
        List<UserDto> userDtos = new ArrayList<>();
        for(UserEntity userEntity:userEntityList){
            //userEntity.toDto();
            userDtos.add(userEntity.toDto());
        }
        return userDtos;
    }

    public UserDto getOne(Integer id) throws Exception{
        return userDao.getUserById(id).toDto();
    }

    public void insertUser(UserDto userDto) throws Exception{

        UserEntity userEntity = userDto.toEntity();

        userDao.insertUser(userEntity);
    }
}
