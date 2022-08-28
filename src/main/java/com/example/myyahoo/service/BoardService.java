package com.example.myyahoo.service;

import com.example.myyahoo.dto.BoardDto;
import com.example.myyahoo.entity.BoardEntity;
import com.example.myyahoo.exceptions.BoardNotFoundException;
import com.example.myyahoo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Page<BoardDto> getList(int page, int size){

        Pageable pageable = (Pageable) PageRequest.of(page,size ,Sort.by(Sort.Direction.DESC, "id"));
        //Pageable pageable = (Pageable) PageRequest.of(page,size);

        //List<BoardEntity> boardEntityList = boardRepository.findArticle(1,"aa",pageable);
        //List<BoardEntity> boardEntityList = boardRepository.listAll(pageable);
        Page<BoardEntity> boardEntityList = boardRepository.findAll(pageable);

        Page<BoardDto> boardDtoList = boardEntityList.map(obj->
                BoardDto.builder().id(obj.getId())
                        .title(obj.getTitle())
                        .contents(obj.getContents())
                        .regdate(obj.getRegdate())
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

    public BoardDto write(BoardDto boardDto){
        //System.out.println(boardDto.getContents());
        BoardEntity boardEntity = boardRepository.save(boardDto.toEntity());
        //System.out.println(boardEntity.getId());
        //System.out.println(boardEntity.toString());
        return boardEntity.toDto();
    }

    public BoardDto getOne(int id){

        BoardEntity boardEntity = boardRepository.getReferenceById(id);
        //BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 글이 존재하지 않습니다"));
        if(boardEntity == null ) {
            throw new BoardNotFoundException("존재 하지 않는 게시물입니다.");
            //throw new MemberNotFoundException("존재하지 않는 회원입니다.");
            //return null;
        }else {
            BoardDto boardDto = new BoardDto(boardEntity);
            return boardDto;
        }
    }

    @Transactional
    public void update(BoardDto boardDto){

        //BoardEntity boardEntity = boardRepository.findById(boardDto.getId()).orElseThrow(()->new IllegalArgumentException("해당 글이 존재하지 않습니다"));
        boardRepository.update(boardDto.getTitles(),boardDto.getContents(),boardDto.getId());
    }
    public void deleteById(int id){
        boardRepository.deleteById(id);
    }

}
