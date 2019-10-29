package com.example.mvcloginappttc.presenter;

import android.content.Context;

import com.example.mvcloginappttc.view.login.LoginContract;
import com.example.mvcloginappttc.view.login.LoginManager;

public class LoginPresenter implements LoginContract.Presenter {
    LoginContract.View mView;
    LoginManager manager = new LoginManager();

    public void setView(LoginContract.View view){
        mView = view;
    }

    @Override
    public void handleLogin(Context context, String email, String password) {
        if (email.isEmpty() || password.isEmpty()){
            mView.loginFail("Nhập emailaddress và password!");
        }else{
            if (manager.login(context, email, password)){
                mView.loginSuccess();
            }else{
                mView.loginFail("sai password hoặc email!");
            }
        }

    }
}
