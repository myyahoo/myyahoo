package com.example.myyahoo.controller;

import com.example.myyahoo.dto.BoardDto;
import com.example.myyahoo.entity.BoardEntity;
import com.example.myyahoo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.servlet.ServletContext;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    ServletContext servletContext;

    //@ResponseBody
    @GetMapping("/board/list")
    public String list(@RequestParam(value = "page",required = true,defaultValue = "0") Integer page, Model model){

        System.out.println("dddd");
        List<BoardDto> list = boardService.getList(page,2);



        model.addAttribute("list",list);
        return "/list";
    }

    @GetMapping("/board/write")
    public String write(){
        return "/write_form";
    }

    @PostMapping("/board/save")
    //@ResponseBody
    public String create(@ModelAttribute  BoardDto boardDto, MultipartFile[] files) throws  Exception{  //Board entity,  원래는 dto
       //public addUser(@RequestBody @Valid AddUserRequest addUserRequest)

        //entity 는 getTitle이 안된다. dto만 가능. 여기선 dto 사용안하고 Entity에 @Data를 넣어서 Entity 와 dto를 결합.
        // 이렇게 사용해선 안된다.
        System.out.println(boardDto.getTitle());
        System.out.println(boardDto.getContents());
        String realPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        //String realPath=servletContext.getRealPath("/resources/files");
        String today=new SimpleDateFormat("yyMMdd").format(new Date());
        String saveFolder=realPath+File.separator+today;

        File folder = new File(saveFolder);
        if(!folder.exists()){
            folder.mkdir();
        }
        for(MultipartFile file:files){
            if(!file.getOriginalFilename().isEmpty()) {

                UUID uuid = UUID.randomUUID();
                String fileName = uuid + "_" + file.getOriginalFilename();
                file.transferTo(new File(saveFolder, fileName));
            }
        }
        try{
            boardService.write(boardDto);
            //log.info(board.toString());
            return "redirect:/board/list";
        }catch(Exception e){
           return "error/error";
        }


    }

    @GetMapping("/board/test/{c}")
    @ResponseBody
    public String test(@PathVariable("c") String c, @RequestParam(value="a",required = true) String a, @RequestParam(value="b",required = false) String b ){
        System.out.println(a);

        System.out.println(c);
        return "";
    }

    @PostMapping("/board/post_test")
    @ResponseBody
    //public String postTest(@RequestBody Map<String,String> model){ body json
    //public String postTest(@RequestBody   BoardDto boardDto){  // only json body
    public String postTest(@ModelAttribute  BoardDto boardDto){  // only www-form-urlencode or multipart form data
    //public String postTest(@RequestParam(value="name") String name){  // form data

            //System.out.println(model.get("name"));
        //System.out.println(name);
        System.out.println(boardDto.getTitle());
        System.out.println("ddddddddd");
        return "";
    }

}
