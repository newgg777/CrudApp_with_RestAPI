package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class UserRepistoryImpl implements UserRepository {

    // sql
    private static final String INSERT_USER_QUERY = "INSERT INTO USER(id,fname,lname,email) values(?,?,?,?)";
    private static final String UPDATE_USER_ID_QUERY = "UPDATE USER SET fname=? WHERE ID=?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USER WHERE ID=?";
    private static final String DELETE_USER_BY_QUERY = "DELETE FROM USER WHERE ID=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM USER";

    // jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(
                INSERT_USER_QUERY,
                user.getId(),
                user.getFname(),
                user.getLname(),
                user.getEmail());
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER_ID_QUERY, user.getFname(), user.getId());
        return user;
    }


    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY,(rs, rowNum) -> {
            return new User(
                    rs.getInt("id"),
                    rs.getString("fname"),
                    rs.getString("lname"),
                    rs.getString("email"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_QUERY, id);
        return "User got deleted by id " + id;
    }

    @Override
    public List<User> AllUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        });
    }
}
