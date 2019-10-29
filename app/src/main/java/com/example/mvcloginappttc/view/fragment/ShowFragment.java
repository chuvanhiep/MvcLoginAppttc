package com.example.mvcloginappttc.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvcloginappttc.R;


public class ShowFragment extends Fragment implements View.OnClickListener {
    TextView tvSignUp;
    TextView tvLogin;
    Button btnSigupwith;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chosse, container, false);
        initViews(view);
        registerListeners();
        return view;
    }

    private void registerListeners() {
        tvSignUp.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        btnSigupwith.setOnClickListener(this);
    }

    private void initViews(View view) {
        tvLogin = view.findViewById(R.id.tv_login);
        tvSignUp = view.findViewById(R.id.tv_sign_up);
        btnSigupwith=view.findViewById(R.id.btn_email_or_phone);
    }


    public static ShowFragment newInstance(){
        return new ShowFragment();
    }

    private void showFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.showfragment, fragment, fragment.getTag())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                showFragment(LoginFragment.newInstance());
                break;
            case R.id.tv_sign_up:
                showFragment(SignUpFragment.newInstance());
                break;
            case R.id.btn_email_or_phone:
                showFragment(SignUpFragment.newInstance());
        }
    }
}
