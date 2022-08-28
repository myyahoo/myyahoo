package com.example.myyahoo.dao;

import com.example.myyahoo.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;
import java.util.List;

public class BoardDao {
    @Resource(name = "sqlSession")
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.spring.board.boardMapper";


    /** 게시판 - 목록 조회 */
    public List<BoardDto> getBoardList(int name) throws Exception {
        return sqlSession.selectList("board.getBoardList", name);
    }

}
