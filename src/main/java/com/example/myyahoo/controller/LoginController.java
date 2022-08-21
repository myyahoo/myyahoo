package com.example.myyahoo.controller;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.service.AuthService;
import com.example.myyahoo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    AuthService authService;

    @GetMapping("/login")
    public String login(){
        String userIdx = authService.getUserId();
        if(!userIdx.isEmpty()){
            return "redirect:/board/list";
        }
        return "login/index";
    }
    @PostMapping("/login/do")
    public String doLogin(@RequestParam("email") String email, @RequestParam("passwd") String passwd){

        try{
            Boolean result = loginService.doLogin(email,passwd);

            if(result == false){
                throw new Exception("");
            }
            return "redirect:/board/list";
        }catch(Exception e){
            return "redirect:/login";

        }
    }
}
