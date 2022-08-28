package com.example.myyahoo.controller;

import com.example.myyahoo.exceptions.BoardNotFoundException;
import com.example.myyahoo.exceptions.MemberNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static com.example.myyahoo.controller.GlobalRestControllerAdvice.ORDER;

@Order(ORDER + 1)
@ControllerAdvice
public class GlobalHtmlControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BoardNotFoundException.class)
    public String handle(BoardNotFoundException e, Model model, HttpServletRequest request) {
        model.addAttribute("1timestamp", LocalDateTime.now());
        model.addAttribute("error", "BOARD_NOT_FOUND");
        model.addAttribute("path", request.getRequestURI());
        model.addAttribute("message", e.getMessage());
        return "/error/error";
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public String handle(MemberNotFoundException e,Model model,HttpServletRequest request){
        model.addAttribute("2timestamp", LocalDateTime.now());
        model.addAttribute("error", "BOARD_NOT_FOUND");
        model.addAttribute("path", request.getRequestURI());
        model.addAttribute("message", e.getMessage());
        return "/error/error";
    }
}
