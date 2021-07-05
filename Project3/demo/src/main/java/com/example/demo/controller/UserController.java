package com.example.demo.controller;



import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;



    // post User
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userRepository.saveUser(user);
    }

    // update user
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return userRepository.updateUser(user);
    }

    // get user by id
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id){
        return userRepository.getById(id);
    }


    // get all users
    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.AllUsers();
    }

    // delete user by id
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userRepository.deleteById(id);
    }
}
