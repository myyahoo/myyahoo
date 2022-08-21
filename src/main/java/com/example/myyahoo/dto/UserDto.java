package com.example.myyahoo.dto;

import com.example.myyahoo.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String email;
    private String user_pwd;
    private String lastdate;

    public String getEmail() {
        return email;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public String getLastdate() {
        return lastdate;
    }

    @Builder
    public UserDto(){

    }

    public UserEntity toEntity(){
        return UserEntity.builder().email(email).user_pwd(user_pwd).build();
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", lastdate='" + lastdate + '\'' +
                '}';
    }
}
