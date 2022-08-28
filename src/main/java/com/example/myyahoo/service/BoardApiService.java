package com.example.myyahoo.service;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.dao.BoardDao;
import com.example.myyahoo.dto.BoardDto;
import com.example.myyahoo.dto.UserDto;
import com.example.myyahoo.entity.BoardEntity;
import com.example.myyahoo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BoardApiService {
    @Autowired
    BoardDao boardDao;
    public BoardDto getOne(Integer id) throws  Exception{
        BoardEntity boardEntity = boardDao.getOne(id);

        return boardEntity.toDto();
    }

    public HashMap getList(int page, int size,String keyword) throws Exception {

        Integer startNo = (page-1)* Constants.listOffset;

        HashMap<String,Object> result = new HashMap<>();


        Integer totalCnt = boardDao.getTotalCnt(keyword);


        List<BoardEntity> boardEntities =  boardDao.getBoardList(page, size, keyword);

        List<BoardDto> boardDtoList = new ArrayList<>();
        for(BoardEntity boardEntity:boardEntities){
            boardDtoList.add(boardEntity.toDto());
        }

        result.put("list",boardDtoList);
        result.put("totalCnt",totalCnt);
        return result;
    }
}
