package com.example.myyahoo.service;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.common.Encryption;
import com.example.myyahoo.entity.UserEntity;
import com.example.myyahoo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Service

public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

    public Boolean doLogin(String email,String passwd) {
        UserEntity userEntity = userRepository.getByEmail(email);

        try {
            if (userEntity != null) {
                if (userEntity.getUser_pwd().equals(Encryption.encrypt(passwd))) {
                    session.setAttribute("id", userEntity.getId());
                    session.setAttribute("name", userEntity.getEmail());
                }
            } else {
                throw new Exception("wrong passwd");
            }
            return true;
        }catch(Exception e){
            return false;
        }

    }

}
