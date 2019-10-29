package com.example.mvcloginappttc.view.signup;

import android.content.Context;

import com.example.mvcloginappttc.model.User;
import com.example.mvcloginappttc.model.UserRepository;


public class SignUpManager {
    public Boolean register(Context context, User user){
        if (!UserRepository.getInstance(context).getAllUsers().contains(user)){
            UserRepository.getInstance(context).insert(user);
            return true;
        }
        return false;
    }
}
