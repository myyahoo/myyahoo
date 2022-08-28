package com.example.myyahoo.dao;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.entity.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public List<UserEntity> getUserlist(Integer startNo,String keyword) throws Exception{

        HashMap<String,Object> data = new HashMap<>();
        data.put("startNo",startNo);
        data.put("listOffset", Constants.listOffset);
        data.put("keyword",keyword);

        return sqlSession.selectList("mappers.user-mapper.getUserList",data);
    }

    public Integer getUserCnt(String keyword) throws Exception{
        HashMap<String,Object> data= new HashMap<>();
        data.put("listOffset",Constants.listOffset);
        data.put("keyword",keyword);
        return sqlSession.selectOne("mappers.user-mapper.getUserCnt",data);
    }
    public UserEntity getUserById(Integer id) throws Exception{
        return sqlSession.selectOne("mappers.user-mapper.getOne",id);
    }

    public UserEntity getUserByEmail(String email) throws  Exception{
        return sqlSession.selectOne("mappers.user-mapper.getUserByEmail",email);
    }
    public Integer insertUser(UserEntity userEntity) throws  Exception{
        return sqlSession.insert("mappers.user-mapper.insertUser",userEntity);
    }
}
