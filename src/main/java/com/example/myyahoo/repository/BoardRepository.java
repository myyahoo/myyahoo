package com.example.myyahoo.repository;

import com.example.myyahoo.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {

    @Query("select b from BoardEntity b where b.user_idx=:user_idx")
    List<BoardEntity> getByUserIdx(Pageable pageable);

    @Query("select b from BoardEntity b where b.bbs_id=:bbs_id and email=:email" )
    List<BoardEntity> findArticle(@Param("bbs_id") Integer bbs_id, @Param("email") String email,Pageable pageable);

    @Query("select b from BoardEntity b " )
    Page<BoardEntity> listAll(Pageable pageable);

}
