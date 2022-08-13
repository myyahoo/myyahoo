package com.example.myyahoo.dto;

import com.example.myyahoo.entity.BoardEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
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

    /*
    public  BoardDto(String title,String contents){
        this.title = title;
        this.contents = contents;
    }*/

    public String getTitle(){
        return title;
    }

    public BoardEntity toEntity(){
        BoardEntity boardEntity = new BoardEntity(title,contents);
        //BoardEntity build = BoardEntity.builder()
        return boardEntity;
    }
    public void setTitle(String title){
        this.title= title;
    }
}
