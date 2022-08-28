package com.example.myyahoo.controller;

import com.example.myyahoo.exceptions.BoardNotFoundException;
//import lombok.extern.slf4j.Slf4j;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import static com.example.myyahoo.controller.GlobalRestControllerAdvice.ORDER;


//@Slf4j
@Order(ORDER)
@RestControllerAdvice(annotations = RestController.class)
//@Controller 즉, 전역에서 발생할 수 있는 예외를 잡아 처리해주는 annotation이다.
public class GlobalRestControllerAdvice {
    public static final int ORDER = 0;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NullPointerException.class})
    protected Map<String, String> handle(Exception e) {
        //log.error(e.getMessage(), e);
        Map<String, String> errorAttributes = new HashMap<>();
        errorAttributes.put("result", "BOARD_NOT_FOUND");
        errorAttributes.put("result_message", e.getMessage());
        return errorAttributes;

    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity handelXXXXXX(ConstraintViolationException e){

        HashMap<String,Object> result = new HashMap<>();

        result.put("result","999");
        result.put("result_msg",e.getMessage());
        result.put("data","");
        return ResponseEntity.badRequest().body(result);
    }

    @ExceptionHandler(BoardNotFoundException.class)
    protected ResponseEntity handleBoardNotFoundException(BoardNotFoundException e){
        HashMap<String,Object> result = new HashMap<>();

        result.put("result","error");
        result.put("result_message", e.getMessage());
        return ResponseEntity.badRequest().body(result);
    }

}

