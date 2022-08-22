package com.example.task311.dao;



import com.example.task311.model.User;

import java.util.List;

public interface UserDao {

    List<User> tableOfUsers();
    void add(User user);
    void delete(int id);

    void edit(int id, User user);

    User getById(int id);

}
