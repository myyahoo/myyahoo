package com.example.myyahoo.dto;

import com.example.myyahoo.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Integer id;
    @NotBlank(message = "이메일을 입력해주세요11.")
    @Email
    private String email;
    @NotBlank
    @Min(5)
    private String user_pwd;
    private String lastdate;

    @Builder
    public UserDto(String email, Integer id,String user_pwd){
        this.email = email;
        this.id = id;
        this.user_pwd = user_pwd;
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
