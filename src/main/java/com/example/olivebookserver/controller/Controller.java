package com.example.olivebookserver.controller;

import com.example.olivebookserver.dto.Info;
import com.example.olivebookserver.service.OliveService;
import com.example.olivebookserver.mybatis.InfoMapper;

import java.util.*;

import javax.annotation.PostConstruct;

//import com.example.olivebookserver.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/olivebook")
public class Controller {

    private InfoMapper mapper;

    public Controller(InfoMapper mapper) {
        this.mapper = mapper;
    }

    //데이터 특정 조회
    @GetMapping("/list/{id}")
    public Info getInfo(@PathVariable("id") String id) {
        return mapper.getInfo(id);
    }

    //데이터 전체 조회
    @GetMapping("/list/all")
    public List<Info> getInfoList() {
        return mapper.getInfoList();
    }

    //데이터 삽입
    @PostMapping("/list/{id}")
    public void postInfo(@PathVariable("id") String id, @RequestParam("user_id") String user_id
            , @RequestParam("list_item_date") String list_item_date, @RequestParam("list_item_time") String list_item_time,
            @RequestParam("list_item_name") String list_item_name,
            @RequestParam("list_item_amount") String list_item_amount, @RequestParam("list_item_cat") String list_item_cat) {
        mapper.insertInfo(id, user_id, list_item_date, list_item_time, list_item_name, list_item_amount, list_item_cat);
    }

    //데이터 수정
    @PutMapping("/list/{id}")
    public void putInfo(@PathVariable("id") String id, @RequestParam("user_id") String user_id
            , @RequestParam("list_item_date") String list_item_date, @RequestParam("list_item_time") String list_item_time,
                        @RequestParam("list_item_name") String list_item_name,
                        @RequestParam("list_item_amount") String list_item_amount, @RequestParam("list_item_cat") String list_item_cat) {
        mapper.updateInfo(id, user_id, list_item_date, list_item_time, list_item_name, list_item_amount, list_item_cat);
    }

    //데이터 삭제
    @DeleteMapping("/list/{id}")
    public void deleteInfo(@PathVariable("id") String id) {
        mapper.deleteInfo(id);
    }

    /*@Autowired
    private final OliveService oliveService;
    //private UserRepository userRepository;

    public Controller(OliveService oliveService) {
        this.oliveService = oliveService;
    }*/



    /*@GetMapping("/list")
    ResponseEntity<?> getHelloWorld(@RequestParam(required = false) Integer ID){

        return new ResponseEntity<>(oliveService.myName(ID), HttpStatus.OK);
    }*/

    /*@PostMapping("/list/{name}")
    ResponseEntity<?> postHelloWorld(@PathVariable("name") String name){
        return new ResponseEntity<>(oliveService.myName(name),HttpStatus.OK);
    }

    @PutMapping("/put")
    ResponseEntity<?> putHelloWorld(@RequestBody Info info){
        return new ResponseEntity<>(oliveService.myInfo(info),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<?> deleteHelloWorld(@RequestHeader String role, @RequestBody Info info) {
        return new ResponseEntity<>(oliveService.myInfoWithRole(role, info), HttpStatus.OK);
    }*/
}


