package com.example.demo.repository;

import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepo {
    @Autowired
    List<User> users;

    public List<User> getListofUsers(){
        return users;
    }

    public void addUsers(List<User> newUserList){
        users.addAll(newUserList);
    }

}
