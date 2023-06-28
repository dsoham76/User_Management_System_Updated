package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void addUsers(List<User> user) {
        userRepo.addUsers(user);
    }

    public List<User> getListofUsers() {
        return userRepo.getListofUsers();
    }

    public String deleteUser(Integer userId) throws IOException{
        for(User user: getListofUsers()){
            if(user.getUserId()==userId) {
                getListofUsers().remove(user);
                return "User with user Id " + userId + " has been deleted.";
            }
        }
        throw new IOException("User with user Id "+userId+" does not exist");


    }

    public String updatePhoneNumber(Integer userId, String phoneNumber) throws IOException {
        for(User user: getListofUsers()){
            if(user.getUserId()==userId) {
                user.setPhoneNumber(phoneNumber);
                return "Phone number of User with user Id " + userId + " has been updated.";
            }
        }
        throw new IOException("User with user Id "+userId+" does not exist");

    }

    public User getUser(Integer userId) throws IOException {
        for(User user: getListofUsers()){
            if(user.getUserId()==userId){
                return user;
            }
        }
        throw new IOException("The user with given user id does not exist.");
    }
}
