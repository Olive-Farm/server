package com.example.olivebookserver.controller;

import com.example.olivebookserver.dto.Info;
import com.example.olivebookserver.service.OliveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/olivebook")
public class Controller {
    private final OliveService oliveService;

    public Controller(OliveService oliveService) {
        this.oliveService = oliveService;
    }

    @GetMapping("/get")
    ResponseEntity<?> getHelloWorld(@RequestParam(required = false) String name){

        return new ResponseEntity<>(oliveService.myName(name), HttpStatus.OK);
    }

    @PostMapping("/post/{name}")
    ResponseEntity<?> postHelloWorld(@PathVariable("name") String name){
        return new ResponseEntity<>(oliveService.myName(name),HttpStatus.OK);
    }

    @PutMapping("/put")
    ResponseEntity<?> putHelloWorld(@RequestBody Info info){
        return new ResponseEntity<>(oliveService.myInfo(info),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<?> deleteHelloWorld(@RequestHeader String role, @RequestBody Info info){
        return new ResponseEntity<>(oliveService.myInfoWithRole(role, info),HttpStatus.OK);
    }
}


