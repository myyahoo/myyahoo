package com.example.myyahoo.controller.api;

import com.example.myyahoo.dao.UserDao;
import com.example.myyahoo.dto.UserDto;
import com.example.myyahoo.entity.UserEntity;
import com.example.myyahoo.service.UserApiService;
import com.example.myyahoo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    UserApiService userApiService;

    @GetMapping("user/list")
    public ResponseEntity<List> list(@RequestParam(value = "page",defaultValue = "1") int page,
                                     @RequestParam(value="keyword", required = false) String keyword ) throws Exception{

        ///log.debug("page = {}, keyword = {}", page, keyword);
        List<UserDto> userDtos = userApiService.getList(page,keyword);

        Integer totalCnt = userApiService.getTotalCnt(keyword);
        System.out.println(totalCnt);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDtos);
    }

    @GetMapping("user/view/{id}")
    public ResponseEntity<UserDto> show(@PathVariable("id") Integer id) throws Exception{

        UserDto userDto = userApiService.getOne(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PostMapping("user/create")
    public ResponseEntity<Integer> create(@RequestParam("email") String email) throws  Exception{

        UserDto userDto = UserDto.builder().email(email).build();
        System.out.println(userDto);
        userApiService.insertUser(userDto);
        return null;
    }
}
