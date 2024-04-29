package com.example.myyahoo.controller;

import com.example.myyahoo.dto.BoardDto;
import com.example.myyahoo.entity.BoardEntity;
import com.example.myyahoo.service.AuthService;
import com.example.myyahoo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    AuthService authService;

    @Autowired
    ServletContext servletContext;


    @Value("${spring.datasource.username}")
    private String dataUsername;



    //@ResponseBody
    @GetMapping("/board/list")
    public String list(@RequestParam(value = "page",required = true,defaultValue = "0") Integer page, Model model){
        log.debug("page = {}", page);

        Page<BoardDto> list = boardService.getList(page,15);
        String userIdx = authService.getUserId();


        model.addAttribute("list",list.getContent());
        model.addAttribute("userIdx",userIdx);

        //return new ModelAndView("/board/list");
        return "board/list";
    }

    @GetMapping("/board/view/{id}")
    public String view(@PathVariable("id") String id,Model model){
        BoardDto boardDto = boardService.getOne(Integer.parseInt(id));

        if(boardDto == null){
            //return "error/error";
        }
        String user_idx = authService.getUserId();

        model.addAttribute("item",boardDto);
        model.addAttribute("user_idx",user_idx);

        return "board/view";
    }
    @GetMapping("/board/write")
    public String write(){
        return "board/write";
        /*String userId = authService.getUserId();
        if(userId == null || userId.isEmpty()){
            return "redirect:/login";
        }else{
            return "board/write";
        }*/
    }

    @PostMapping("/board/save")
    //@ResponseBody
    public String save(@ModelAttribute  BoardDto boardDto) throws  Exception{   //@ReqestBody 는 json 만 가능
       //public addUser(@RequestBody @Valid AddUserRequest addUserRequest)

        //entity 는 getTitle이 안된다. dto만 가능. 여기선 dto 사용안하고 Entity에 @Data를 넣어서 Entity 와 dto를 결합.
        // 이렇게 사용해선 안된다.

        String userIdx = authService.getUserId();

        if(userIdx == null || userIdx.isEmpty()){
            return "redirect:/login";
        }

            boardDto.setUser_idx(Integer.valueOf(userIdx));
            boardService.write(boardDto);
            //log.info(board.toString());
            return "redirect:/board/list";

    }

    @PostMapping("/board/image_upload")
    public void imageUpload(@RequestParam MultipartFile[] files) throws Exception{

            String realPath = System.getProperty("user.dir") + "/src/main/resources/static/files";

            //String realPath=servletContext.getRealPath("/resources/files");
            String today = new SimpleDateFormat("yyMMdd").format(new Date());

            String saveFolder = realPath + File.separator + today;

            File folder = new File(saveFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }
            for (MultipartFile file : files) {
                if (!file.getOriginalFilename().isEmpty()) {

                    UUID uuid = UUID.randomUUID();
                    String fileName = uuid + "_" + file.getOriginalFilename();
                    file.transferTo(new File(saveFolder, fileName));
                }
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
        System.out.println(boardDto.getTitles());
        System.out.println("ddddddddd");
        return "";
    }

    @GetMapping("/board/delete/{id}")
    public String delete(@PathVariable("id") Integer id){

        String user_idx = authService.getUserId();
        BoardDto boardDto = boardService.getOne(id);

        if(boardDto != null){
            if(user_idx.equals(boardDto.getUser_idx())){
                boardService.deleteById(id);
                return "redirect:/board/list";
            }else{
                return "";
            }
        }else{
            return "";
        }
    }

    @GetMapping("/board/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){

        String userIdx = authService.getUserId();

        if(userIdx == null || userIdx.isEmpty()){
            return "redirect:/login";
        }

        if(id == null){
            return "error/error";
        }else{
            BoardDto boardDto = boardService.getOne(id);

            if(!userIdx.equals(String.valueOf(boardDto.getUser_idx()))){
                return "error/error";
            }else{
                model.addAttribute("item",boardDto);
            }
        }

        return "board/edit";
    }

    @PostMapping("/board/update/{id}")
    public String update(@PathVariable("id") Integer id,@ModelAttribute BoardDto boardDto){
        String userIdx = authService.getUserId();
        //인증
        if(userIdx == null || userIdx.isEmpty()){
            return "redirect:/login";
        }
        if(id == null){
            return "error/error";
        }else{
            BoardDto data = boardService.getOne(id);
            if(!userIdx.equals(String.valueOf(data.getUser_idx()))){
                return "error/error";
            }
        }
        boardDto.setId(id);
        boardDto.setUser_idx(Integer.parseInt(userIdx));
        boardService.update(boardDto);

        return "redirect:/board/list";
    }

}
