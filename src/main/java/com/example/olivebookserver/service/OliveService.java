package com.example.olivebookserver.service;

import com.example.olivebookserver.dto.Info;
//import com.example.olivebookserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OliveService {
    /*@Autowired
    public UserRepository mapper;

    public List<Info> getList(){
        return mapper.getList();
    }*/

    public String myName(String ID) {
        if (ID != null) {
            return "my name is " + ID;
        } else {
            return "no name param";
        }
    }

    public String myAge(Integer age) {
        if (age != null) {
            return "my age is " + age;
        } else {
            return "no name param";
        }
    }




    public String myInfo(Info info){
        return myName(info.getId_LIST_ITEM())+" / ";
    }

    public String myInfoWithRole(String role, Info info){
        return role +" / "+ myInfo(info);
    }
}
