package com.example.myyahoo.entity;

import com.example.myyahoo.dto.BoardDto;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="boards")
@NoArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer bbs_id;

    @Column
    private String title;

    @Column
    private String contents;

    @Column
    private String user_name;

    @Column
    private Integer user_idx;

    @Column
    private String nick_name;

    @Column
    private String email;

    @Column
    private Integer view_cnt=0;

    @Column
    private String write_ip;

    @Column
    private Integer comments_cnt=0;

    @Column
    private Integer is_notice=1;

    @Column
    private String images;

    @Column
    private String thumbnail;

    @Column
    @CreationTimestamp
    private LocalDateTime regdate;

    @Builder
    public BoardEntity(Integer id,String title, String contents, String user_name, Integer user_idx, String nick_name, String email,String images) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.user_name = user_name;
        this.user_idx = user_idx;
        this.nick_name = nick_name;
        this.email = email;
        this.images = images;
    }

    public BoardDto toDto(){
        return BoardDto.builder().title(this.title).contents(this.contents).id(this.id).images(this.images).build();
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "id=" + id +
                ", bbs_id=" + bbs_id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_idx=" + user_idx +
                ", nick_name='" + nick_name + '\'' +
                ", email='" + email + '\'' +
                ", view_cnt=" + view_cnt +
                ", write_ip='" + write_ip + '\'' +
                ", comments_cnt=" + comments_cnt +
                ", is_notice=" + is_notice +
                ", images='" + images + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}
