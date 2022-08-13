package com.example.myyahoo.dto;

import com.example.myyahoo.entity.BoardEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class BoardDto {
    private  Integer id;

    @NotNull
    private  String title;
    private  String contents;

    private String age;


    @Builder
    public  BoardDto(String title,String contents){
        this.title = title;
        this.contents = contents;
    }

    public BoardEntity toEntity(){
        BoardEntity boardEntity = BoardEntity.builder().title(title).build();
        //BoardEntity build = BoardEntity.builder()
        return boardEntity;
    }



}
