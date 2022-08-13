package com.example.myyahoo.entity;

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
    public BoardEntity(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
