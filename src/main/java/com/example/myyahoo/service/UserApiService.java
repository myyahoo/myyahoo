package com.example.myyahoo.service;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.dao.UserDao;
import com.example.myyahoo.dto.UserDto;
import com.example.myyahoo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserApiService {

    @Autowired
    UserDao userDao;

    public List<UserDto> getList(Integer page,String keyword) throws Exception {

        Integer startNo = (page-1)* Constants.listOffset;

        List<UserEntity> userEntityList =  userDao.getUserlist(startNo,keyword);
        List<UserDto> userDtoList = new ArrayList<>();
        for(UserEntity userEntity:userEntityList){
            userDtoList.add(userEntity.toDto());
        }
        return userDtoList;
    }
    public Integer getTotalCnt(String keyword) throws Exception{
        return  userDao.getUserCnt(keyword);
    }

    public UserDto getOne(Integer id) throws Exception{
        return userDao.getUserById(id).toDto();
    }

    public UserDto getOneByEmail(String email) throws Exception{
        UserEntity userEntity = userDao.getUserByEmail(email);
        if(userEntity != null) {
            return userEntity.toDto();
        }else{
            return null;
        }
    }
    public void insertUser(UserDto userDto) throws Exception{

        UserEntity userEntity = userDto.toEntity();

        userDao.insertUser(userEntity);
    }
}
