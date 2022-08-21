package com.example.myyahoo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/*
@Slf4j
@Order(ORDER)
@RestControllerAdvice(annotations = RestController.class)
public class GlobalRestControllerAdvice {

    public static final int ORDER = 0;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BoardNotFoundException.class)
    public Map<String, String> handle(BoardNotFoundException e) {
        log.error(e.getMessage(), e);
        Map<String, String> errorAttributes = new HashMap<>();
        errorAttributes.put("code", "BOARD_NOT_FOUND");
        errorAttributes.put("message", e.getMessage());
        return errorAttributes;
    }
}

@Order(GlobalRestControllerAdvice.ORDER + 1)
@ControllerAdvice
public class GlobalHtmlControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BoardNotFoundException.class)
    public String handle(BoardNotFoundException e, Model model, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        model.addAttribute("timestamp", LocalDateTime.now());
        model.addAttribute("error", "BOARD_NOT_FOUND");
        model.addAttribute("path", request.getRequestURI());
        model.addAttribute("message", e.getMessage());
        return "/error/404";
    }
}

 */
