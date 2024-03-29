package com.example.mvcloginappttc.model;

import android.content.Context;

import com.example.mvcloginappttc.model.database.UserDao;

import java.util.List;

public class UserRepository {
    private static UserRepository instance;
    private static UserDao userDao;

    public static UserRepository getInstance(Context context) {
        if (instance == null) {
            instance = new UserRepository(context);
        }
        return instance;
    }
    private UserRepository(Context context) {
        userDao = UserDataBase.getDb(context).getUserDao();
    }
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    public User getUser(String email, String password) {
        return userDao.getUser(email,password);
    }
    public void insert(User user) {
        userDao.insert(user);
    }
}
