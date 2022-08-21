package com.example.myyahoo.dto;

import com.example.myyahoo.entity.BoardEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class BoardDto {
    private  Integer id;
    @NotNull
    private  String titles;
    private  String contents;
    private String age;
    private Integer user_idx;

    private LocalDateTime regdate;

    @Builder
    public  BoardDto(Integer id,String title,String contents,Integer user_idx,LocalDateTime regdate){
        this.id=id;
        this.titles = title;
        this.contents = contents;
        this.user_idx = user_idx;
        this.regdate = regdate;
    }

    public BoardDto(BoardEntity boardEntity){
        this.id=boardEntity.getId();
        this.titles = boardEntity.getTitle();
        this.contents = boardEntity.getContents();
        this.user_idx = boardEntity.getUser_idx();
        this.regdate = boardEntity.getRegdate();
    }
    public BoardEntity toEntity(){
        BoardEntity boardEntity = BoardEntity.builder().title(titles).contents(contents).user_idx(user_idx).build();
        //BoardEntity build = BoardEntity.builder()
        return boardEntity;
    }


    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", title='" + titles + '\'' +
                ", contents='" + contents + '\'' +
                ", user_idx='" + user_idx + '\'' +
                '}';
    }
}
