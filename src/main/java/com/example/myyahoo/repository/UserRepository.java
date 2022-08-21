package com.example.myyahoo.repository;

import com.example.myyahoo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public  interface  UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query("select b from UserEntity b where b.email=:email")
    UserEntity getByEmail(@Param("email") String email);
}
