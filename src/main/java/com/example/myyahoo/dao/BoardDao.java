package com.example.myyahoo.dao;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.dto.BoardDto;
import com.example.myyahoo.entity.BoardEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Repository
public class BoardDao {
    //@Resource(name = "sqlSession")
    private SqlSession sqlSession;

    //private static final String NAMESPACE = "com.spring.board.boardMapper";


    /** 게시판 - 목록 조회 */
    public List<BoardEntity> getBoardList(int page,int startNo,String keyword) throws Exception {
        HashMap<String,Object> data = new HashMap<>();

        data.put("keyword",keyword);
        data.put("startNo",startNo);
        data.put("listOffset",Constants.listOffset);

        return sqlSession.selectList("board.getBoardList", data);
    }

    public BoardEntity getOne(int id) throws Exception{
        return sqlSession.selectOne("mappers.board-mapper.getOne",id);
    }

    public Integer getTotalCnt(Object data) throws Exception{
        return sqlSession.selectOne("mapper.board-mapper.getTotalCnt",data);
    }
}
