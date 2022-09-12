package com.example.myyahoo.dto;

import com.example.myyahoo.entity.BoardEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Integer id;

    @NotBlank
    private String titles;
    private String contents;
    private String age;
    private Integer user_idx;


    private LocalDateTime regdate;

    private String images;


    private MultipartFile file;

    @Builder
    public  BoardDto(Integer id,String title,String contents,Integer user_idx,String images,LocalDateTime regdate){
        this.id=id;
        this.titles = title;
        this.contents = contents;
        this.user_idx = user_idx;
        this.regdate = regdate;
        this.images = images;
    }

    public BoardDto(BoardEntity boardEntity){
        this.id=boardEntity.getId();
        this.titles = boardEntity.getTitle();
        this.contents = boardEntity.getContents();
        this.user_idx = boardEntity.getUser_idx();
        this.regdate = boardEntity.getRegdate();
    }
    public BoardEntity toEntity(){
        BoardEntity boardEntity = BoardEntity.builder().id(id).title(titles).contents(contents).user_idx(user_idx).images(images).build();
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
