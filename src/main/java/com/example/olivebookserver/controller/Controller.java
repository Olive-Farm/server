package com.example.olivebookserver.controller;

import com.example.olivebookserver.dto.AllSpending;
import com.example.olivebookserver.mybatis.SpendingMapper;
import com.example.olivebookserver.dto.Spending;
import java.sql.Timestamp;

import com.example.olivebookserver.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/olivebook")
public class Controller {
    @Autowired
    private SpendingMapper mapper;

    @Autowired
    private SpendingService spendingService;
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

    @GetMapping("/list/user")
    public List<AllSpending> getAll(){
        return spendingService.getAll();
    }

    //데이터 삽입
    @PutMapping("/list/insert")
    public void postSpending(@RequestParam("userID") String userID
            , @RequestParam("spTime") Timestamp spTime, @RequestParam("spName") String spName,
            @RequestParam("spAmount") Integer spAmount, @RequestParam("spCategory") String spCategory,
            @RequestParam("spMethod") String spMethod, @RequestParam("spMemo") String spMemo) {
        mapper.insertSpending(userID, spTime, spName, spAmount, spCategory, spMethod, spMemo);
    }

    //데이터 수정
    @PostMapping("/list/{spID}")
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

}


