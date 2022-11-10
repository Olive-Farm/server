package com.example.olivebookserver.controller;

import com.example.olivebookserver.mybatis.SpendingMapper;
import com.example.olivebookserver.dto.Spending;
import java.sql.Timestamp;
//import com.example.olivebookserver.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/olivebook")
public class Controller {

    private SpendingMapper mapper;

    public Controller(SpendingMapper mapper) {
        this.mapper = mapper;
    }

    //데이터 특정 조회
    @GetMapping("/list/{spID}")
    public Spending getSpending(@PathVariable("spID") Integer spID) {
        return mapper.getSpending(spID);
    }

    //데이터 전체 조회
    @GetMapping("/list/all")
    public List<Spending> getSpendingList() {
        return mapper.getSpendingList();
    }

    //데이터 삽입
    @PostMapping("/list/{spID}")
    public void postSpending(@PathVariable("spID") Integer spID, @RequestParam("userID") String userID
            , @RequestParam("spTime") Timestamp spTime, @RequestParam("spName") String spName,
            @RequestParam("spAmount") Integer spAmount, @RequestParam("spCategory") String spCategory,
            @RequestParam("spMethod") String spMethod, @RequestParam("spMemo") String spMemo) {
        mapper.insertSpending(spID, userID, spTime, spName, spAmount, spCategory, spMethod, spMemo);
    }

    //데이터 수정
    @PutMapping("/list/{spID}")
    public void putSpending(@PathVariable("spID") Integer spID, @RequestParam("userID") String userID
            , @RequestParam("spTime") Timestamp spTime, @RequestParam("spName") String spName,
                            @RequestParam("spAmount") Integer spAmount, @RequestParam("spCategory") String spCategory,
                            @RequestParam("spMethod") String spMethod, @RequestParam("spMemo") String spMemo) {
        mapper.updateSpending(spID, userID, spTime, spName, spAmount, spCategory, spMethod, spMemo);
    }

    //데이터 삭제
    @DeleteMapping("/list/{spID}")
    public void deleteSpending(@PathVariable("spID") Integer spID) {
        mapper.deleteSpending(spID);
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


