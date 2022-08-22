package com.example.task311.service;


import com.example.task311.dao.UserDao;
import com.example.task311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> showTableOfUsers() {
        return userDao.tableOfUsers();
    }

    @Override
    @Transactional
    public void addNewUser(User user) {
        userDao.add(user);

    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);

    }

    @Override
    @Transactional
    public void edit(int id, User user) {
        userDao.edit(id,user);
    }


    @Override
    public User getUserById(int id) {
        return userDao.getById(id);
    }
}
