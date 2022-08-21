package com.example.myyahoo.controller.api;

import com.example.myyahoo.dto.BoardDto;
import com.example.myyahoo.entity.BoardEntity;
import com.example.myyahoo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.util.annotation.Nullable;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardApiController {
    @Autowired
    BoardService boardService;

    @GetMapping("board/list")
    public ResponseEntity<List> list(@RequestParam(value = "page",required = true,defaultValue = "0") Integer page){
        Page<BoardDto> list = boardService.getList(page,15);
        HttpHeaders headers = new HttpHeaders();
        //return "hello";
        //return list.getContent();
        return new ResponseEntity<List>(list.getContent(),headers, HttpStatus.valueOf(200));
        //return ResponseEntity.ok(list.getContent());
    }

    @PostMapping("board/save")
    public ResponseEntity<BoardDto> save(@RequestParam @Nullable MultipartFile image, @RequestParam("title") String title,
                                         @RequestParam("contents") String contents
                                        ) throws Exception{
    //public ResponseEntity<BoardDto> save(@RequestBody BoardDto boardDto){  //json 데이타를 받을때

        String fullFileName = "";
        if(image!= null && !image.getOriginalFilename().isEmpty()){
            String realPath = System.getProperty("user.dir") + "/src/main/resources/static/files";
            String toDay    = new SimpleDateFormat("yyMMdd").format(new Date());
            String saveFoler = realPath+File.separator+toDay;

            File folder = new File(saveFoler);
            if(!folder.exists()){
                folder.mkdir();
            }

            File file = new File(image.getOriginalFilename());
            String fileName = file.getName();
            String ext = fileName.substring(fileName.lastIndexOf(".")+1);
            fileName = System.currentTimeMillis()/1000+"."+ext;

            image.transferTo(new File(saveFoler,fileName));
            fullFileName = saveFoler+File.separator+fileName;
            System.out.println(fullFileName);
        }
        BoardDto boardDto = BoardDto.builder().title(title).contents(contents).images(fullFileName).build();
        BoardDto response = boardService.write(boardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(boardDto);
    }
}