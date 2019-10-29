package com.example.mvcloginappttc.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mvcloginappttc.model.User;

import java.util.List;

@Dao public interface UserDao {
    @Query("select * from user")
    List<User> getAllUsers();

    @Query("select * from user where email = :email and password = :password")
    User getUser(String email, String password);

    @Insert
    void insert(User... user);
}
