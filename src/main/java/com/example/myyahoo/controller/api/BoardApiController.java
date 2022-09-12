package com.example.myyahoo.controller.api;

import com.example.myyahoo.common.Constants;
import com.example.myyahoo.dto.BoardDto;
import com.example.myyahoo.entity.BoardEntity;
import com.example.myyahoo.service.BoardApiService;
import com.example.myyahoo.service.BoardService;
import lombok.AllArgsConstructor;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.util.annotation.Nullable;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.Bidi;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class BoardApiController {

    private BoardApiService boardApiService;
    @RequestMapping("board/list")
    public ResponseEntity list(@RequestParam(value = "page",required = true,defaultValue = "0") Integer page,
                                     @RequestParam(value="keyword",required = false) String keyword,@ModelAttribute BoardDto boardDto) throws Exception {
        //Page<BoardDto> list = boardApiService.getList(page,15);
        System.out.println(page);
        System.out.println("========================");
        System.out.println(boardDto.getTitles());

        HttpHeaders headers = new HttpHeaders();
        HashMap<String,Object> result = boardApiService.getList(page, Constants.listOffset,keyword);

        System.out.println(result);
        //return "hello";
        //return list.getContent();
       // return new ResponseEntity<List>(list.getContent(),headers, HttpStatus.valueOf(200));
        //return ResponseEntity.ok(list.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("board/save")
    public ResponseEntity save(@ModelAttribute @Valid BoardDto request, BindingResult bindingResult) throws Exception {
    //public ResponseEntity<BoardDto> save(@RequestBody BoardDto boardDto){  //json 데이타를 받을때

        MultipartFile image = request.getFile();
        String title        = request.getTitles();
        String contents     = request.getContents();

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
        BoardDto oardDto = BoardDto.builder().title(title).contents(contents).images(fullFileName).build();
        boardApiService.insertBoard(oardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(oardDto);
    }

    @GetMapping("/board/view/{id}")
    public ResponseEntity<BoardDto> view(@PathVariable("id") String id) throws Exception {

        BoardDto boardDto = boardApiService.view(Integer.valueOf(id));
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<BoardDto>(boardDto,headers, HttpStatus.valueOf(200));
    }

    @DeleteMapping("/board/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) throws Exception {

        System.out.println("==================");
        boardApiService.deleteBoard(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.CREATED).body(1);
    }

    @PostMapping("/board/update/{id}")
    public ResponseEntity update(@ModelAttribute @Valid BoardDto request,@PathVariable("id") Integer id,
                                 BindingResult bindingResult ) throws Exception{
        String title    = request.getTitles();
        String contents = request.getContents();

        BoardDto boardDto = BoardDto.builder().id(id).title(title).contents(contents).build();
        System.out.println(boardDto);
        boardApiService.updateBoard(boardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(1);
    }

}
