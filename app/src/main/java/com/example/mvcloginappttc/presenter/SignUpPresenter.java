package com.example.mvcloginappttc.presenter;

import android.content.Context;

import com.example.mvcloginappttc.model.User;
import com.example.mvcloginappttc.view.signup.SignUpContract;
import com.example.mvcloginappttc.view.signup.SignUpManager;


public class SignUpPresenter implements SignUpContract.Presenter {

    private SignUpContract.View mView;
    private SignUpManager manager = new SignUpManager();

    public void setView(SignUpContract.View view){
        mView = view;
    }

    @Override
    public void handleRegister(Context context, String email, String username, String password) {
        if (email.isEmpty() || username.isEmpty() || password.isEmpty()){
            mView.registerFail("nhập lại email và password");
        }else{
            User user = new User(email, password, username);
            if (manager.register(context, user)) {
                mView.registerSuccess();
            }else{
                mView.registerFail("User đã tồn tại !");
            }
        }
    }
}
