package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// lomboc
@Data
@NoArgsConstructor
@AllArgsConstructor
// user table
public class User {

    private int id;
    private String fname;
    private String lname;
    private String email;

    
}
