package com.example.myyahoo.service;

import com.example.myyahoo.dto.BoardDto;
import com.example.myyahoo.entity.BoardEntity;
import com.example.myyahoo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;


    public Page<BoardDto> getList(int page, int size){

        //Pageable pageable = (Pageable) PageRequest.of(page,size ,Sort.by(Sort.Direction.DESC, "regdate"));
        Pageable pageable = (Pageable) PageRequest.of(page,size);

        //List<BoardEntity> boardEntityList = boardRepository.findArticle(1,"aa",pageable);
        //List<BoardEntity> boardEntityList = boardRepository.listAll(pageable);
        Page<BoardEntity> boardEntityList = boardRepository.findAll(pageable);

//System.out.println(boardEntityList.getNumber());
        Page<BoardDto> boardDtoList = boardEntityList.map(obj->
                BoardDto.builder()
                        .title(obj.getTitle())
                        .contents(obj.getContents())
                        .build());
        //Page<BoardDto> boardDtoList = new ArrayList<>();

        /*
        for(BoardEntity boardEntity : boardEntityList){
            //System.out.println();
            //BoardDto boardDto = new BoardDto(boardEntity.getTitle());
            //BoardDto boardDto = new BoardDto();
            //boardDto.setTitle(boardEntity.getTitle());

            BoardDto boardDto = BoardDto.builder().title(boardEntity.getTitle()).build();
            boardDtoList.add(boardDto);
        }*/
        return boardDtoList;
    }

    public void write(BoardDto boardDto){
        System.out.println(boardDto.getContents());
        boardRepository.save(boardDto.toEntity());


    }


}
