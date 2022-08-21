package com.example.myyahoo.repository;

import com.example.myyahoo.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {

    @Query("select b from BoardEntity b where b.user_idx=:user_idx")
    List<BoardEntity> getByUserIdx(Pageable pageable);

    @Query("select b from BoardEntity b where b.bbs_id=:bbs_id and email=:email" )
    List<BoardEntity> findArticle(@Param("bbs_id") Integer bbs_id, @Param("email") String email,Pageable pageable);

    @Query("select b from BoardEntity b " )
    Page<BoardEntity> listAll(Pageable pageable);

    Page<BoardEntity> findAll(Pageable pageable);

    @Query("select b from BoardEntity b  where b.id=:id")
    BoardEntity getReferenceById(@Param("id") Integer id);

    @Modifying
    @Query("update BoardEntity b set b.title=:title, b.contents=:contents where b.id=:id")
    void update(@Param("title") String title, @Param("contents") String contents, @Param("id") int id);
}
