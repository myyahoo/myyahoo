package com.example.myyahoo.controller;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.service.AuthService;
import com.example.myyahoo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

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
    public String doLogin(@RequestParam("email") String email, @RequestParam("passwd") String passwd,
                          BindingResult bindingResult){

        try{
            if(bindingResult.hasErrors()){
                StringBuilder sb = new StringBuilder();
                List<ObjectError> errors = bindingResult.getAllErrors();
                errors.forEach(objectError -> {
                    FieldError fieldError = (FieldError) objectError;
                    String field = fieldError.getField();
                    String message = fieldError.getDefaultMessage();
                    sb.append("field"+field+"\n").append("message"+message+"\n");
                });

            }
            StringBuilder stringBuilder = new StringBuilder();

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
