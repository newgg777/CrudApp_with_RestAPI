package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserRepository {


    // interface methods
    User saveUser(User user);
    User updateUser(User user);
    User getById(int id);
    List<User> AllUsers();
    String deleteById(int id);
}




