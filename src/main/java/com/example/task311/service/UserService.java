package com.example.task311.service;

import com.example.task311.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> tableOfUsers();

    void add(User user);

    void delete(Long id);

    void edit(Long id, User user);

    Optional<User> getById(Long id);
}
