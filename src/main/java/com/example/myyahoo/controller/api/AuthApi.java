package com.example.myyahoo.controller.api;

import com.example.myyahoo.common.AuthToken;
import com.example.myyahoo.common.Constants;
import com.example.myyahoo.common.Encryption;
import com.example.myyahoo.dto.UserDto;
import com.example.myyahoo.exceptions.BoardNotFoundException;
import com.example.myyahoo.service.AuthService;
import com.example.myyahoo.service.UserApiService;
import com.example.myyahoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthApi {

    @Autowired
    UserApiService userApiService;


    @PostMapping("login")

    public ResponseEntity doLogin(@ModelAttribute @Valid  UserDto uDto,BindingResult bindingResult
    ){


        HashMap<String, Object> result = new HashMap<>();
        String resultCode="";
        String resultMsg="";
        HashMap<String,Object> data = new HashMap<>();
        String email = uDto.getEmail();
        String password = uDto.getUser_pwd();

        try {
/*
            @Validated 에서만 아래 가능.  @Validated는 exception 발생안 시킴
            @Valid는 그 전에 Exception
            if(bindingResult.hasErrors()){
                StringBuilder sb = new StringBuilder();
                List<ObjectError> errors = bindingResult.getAllErrors();
                errors.forEach(objectError -> {
                    sb.append("field"+((FieldError) objectError).getField()+"\n");
                    sb.append("message"+objectError.getDefaultMessage()+"\n");
                });

                System.out.println(sb.toString());
                //throw new NullPointerException("fdsa");
                return ResponseEntity.badRequest().body(sb.toString());
            }
*/
            StringBuilder stringBuilder = new StringBuilder();

            UserDto userDto = userApiService.getOneByEmail(email);

            if (userDto == null) {
                throw new Exception("no parameter");
            }
            String encPassword = Encryption.encrypt(password);

            if(encPassword.equals(userDto.getUser_pwd())==false){
                throw new Exception("wrong password");
            }
            //password 1234


            String encryptedString = AuthToken.encrypt(userDto.getEmail());

            resultCode="100";
            resultMsg="success";
            data.put("authToken",encryptedString);

        }catch (Exception e){
            resultMsg=e.getMessage();
        }

        result.put("result", resultCode);
        result.put("result_msg", resultMsg);
        result.put("data",data);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }












}
