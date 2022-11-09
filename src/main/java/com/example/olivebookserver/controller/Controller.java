package com.example.olivebookserver.controller;

import com.example.olivebookserver.dto.Info;
import com.example.olivebookserver.service.OliveService;

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

    private Map<String, Info> itemMap;

    @PostConstruct
    public void init() {
        itemMap = new HashMap<String, Info>();
        itemMap.put("1", new Info("1", "abc", "20221108", "2022-11-08 00:11:30", "테스트1", "50000", "음식"));
        itemMap.put("2", new Info("2", "abc", "20221108", "2022-11-08 00:11:30", "테스트2", "-50000", "음식"));
        itemMap.put("3", new Info("3", "abc", "20221108", "2022-11-08 00:11:30", "테스트3", "40000", "음식"));
    }

    @GetMapping("/list/{id}")
    public Info getInfo(@PathVariable("id") String id) {
        return itemMap.get(id);
    }

    @GetMapping("/list/all")
    public List<Info> getInfoList() {
        return new ArrayList<Info>(itemMap.values());
    }

    @PostMapping("/list/{id}")
    public void postInfo(@PathVariable("id") String id, @RequestParam("user_id") String user_id
            , @RequestParam("list_item_date") String list_item_date, @RequestParam("list_item_time") String list_item_time,
            @RequestParam("list_item_name") String list_item_name,
            @RequestParam("list_item_amount") String list_item_amount, @RequestParam("list_item_cat") String list_item_cat) {
        Info itemInfo = new Info(id, user_id, list_item_date, list_item_time, list_item_name, list_item_amount, list_item_cat);
        itemMap.put(id, itemInfo);
    }

    @PutMapping("/list/{id}")
    public void putInfo(@PathVariable("id") String id, @RequestParam("user_id") String user_id
            , @RequestParam("list_item_date") String list_item_date, @RequestParam("list_item_time") String list_item_time,
                        @RequestParam("list_item_name") String list_item_name,
                        @RequestParam("list_item_amount") String list_item_amount, @RequestParam("list_item_cat") String list_item_cat) {
        Info itemInfo = itemMap.get(id);
        itemInfo.setUSER_ID(user_id);
        itemInfo.setList_Date(list_item_date);
        itemInfo.setList_Time(list_item_time);
        itemInfo.setList_Item_Name(list_item_name);
        itemInfo.setList_Item_Amount(list_item_amount);
        itemInfo.setList_Item_Cat(list_item_cat);
    }

    @DeleteMapping("/list/{id}")
    public void deleteInfo(@PathVariable("id") String id) {
        itemMap.remove(id);
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


