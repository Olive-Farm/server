package com.example.olivebookserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/olivebook")
public class Controller {
    @GetMapping("/get")
    ResponseEntity<?> getHelloWorld(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PostMapping("/post")
    ResponseEntity<?> postHelloWorld(){
        return new ResponseEntity<>("Hello World By Post Method",HttpStatus.OK);
    }

    @PutMapping("/put")
    ResponseEntity<?> putHelloWorld(){
        return new ResponseEntity<>("Hello World By Put Method",HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<?> deleteHelloWorld(){
        return new ResponseEntity<>("Hello World By Delete Method",HttpStatus.OK);
    }
}

