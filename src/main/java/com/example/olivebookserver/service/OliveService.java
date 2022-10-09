package com.example.olivebookserver.service;

import org.springframework.stereotype.Service;

@Service
public class OliveService {
    public String myName(String name) {
        if (name != null) {
            return "my name is " + name;
        } else {
            return "no name param";
        }
    }

    public String myName(Integer age) {
        if (age != null) {
            return "my age is " + age;
        } else {
            return "no age param";
        }
    }
}
