package com.example.mvcloginappttc.view.signup;

import android.content.Context;

public interface SignUpContract {
    interface View{
        void registerSuccess();

        void registerFail(String message);

    }

    interface Presenter{
        void handleRegister(Context context, String email, String username, String password);
    }
}
