package com.example.myyahoo.dao;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.dto.BoardDto;
import com.example.myyahoo.entity.BoardEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Repository
public class BoardDao {
    //@Resource(name = "sqlSession")
    @Autowired
    private SqlSession sqlSession;

    //private static final String NAMESPACE = "com.spring.board.boardMapper";


    /** 게시판 - 목록 조회 */
    public List<BoardEntity> getBoardList(int page,int startNo,String keyword) throws Exception {
        HashMap<String,Object> data = new HashMap<>();

        data.put("keyword",keyword);
        data.put("startNo",startNo);
        data.put("listOffset",Constants.listOffset);

        return sqlSession.selectList("mappers.board-mapper.getList", data);
    }

    public BoardEntity getOne(int id) throws Exception{
        return sqlSession.selectOne("mappers.board-mapper.getOne",id);
    }

    public Integer getTotalCnt(String keyword) throws Exception{
        return sqlSession.selectOne("mappers.board-mapper.getTotalCnt",keyword);
    }

    public int save(BoardEntity boardEntity) throws  Exception{
        return sqlSession.insert("mappers.board-mapper.insertBoard",boardEntity);
    }

    public Integer delete(Integer id) throws Exception {
        return sqlSession.delete("mappers.board-mapper.deleteBoard",id);
    }

    public int update(BoardEntity boardEntity) throws  Exception{
        return sqlSession.update("mappers.board-mapper.updateBoard",boardEntity);
    }
}
