package com.example.myyahoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;

@Service
public class AuthService {
    @Autowired
    HttpSession session;

    public String getUserId(){
        var userIdx = session.getAttribute("id");

        return userIdx != null ? String.valueOf(userIdx):"";
    }
}
