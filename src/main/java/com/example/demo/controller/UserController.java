package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("users")
    public String addUsers(@RequestBody @Valid List<User> user){
        userService.addUsers(user);
        return "List of users has been added.";
    }

    @GetMapping("users/{userId}")
    public User getUser(@PathVariable Integer userId) throws IOException{
        return userService.getUser(userId);

    }

    @GetMapping("users")
    public List<User> getAllUser(){
        return userService.getListofUsers();
    }

    @PutMapping("user/{userId}/{phoneNumber}")
    public String updateUserPhoneNumber(@PathVariable Integer userId,@PathVariable String phoneNumber) throws IOException {
         return userService.updatePhoneNumber(userId,phoneNumber);
    }

    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable Integer userId) throws IOException{
            return userService.deleteUser(userId);
    }


}
