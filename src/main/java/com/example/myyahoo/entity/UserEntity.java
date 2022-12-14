package com.example.myyahoo.entity;

import com.example.myyahoo.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name="users")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String email;
    @Column
    private String user_pwd;
    @Column
    private String lastdate;


    @Builder
    public UserEntity(Integer id,String email,String user_pwd){
        this.id=id;
        this.email = email;
        this.user_pwd= user_pwd;
    }

    public UserDto toDto(){
        return UserDto.builder().email(email).id(id).user_pwd(user_pwd).build();
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", lastdate='" + lastdate + '\'' +
                '}';
    }
}
