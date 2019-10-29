package com.example.mvcloginappttc.view.signup;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mvcloginappttc.model.UserRepository;
import com.example.mvcloginappttc.view.fragment.ShowFragment;
import com.example.mvcloginappttc.R;

public class MainActivity extends AppCompatActivity {

    private Fragment shownFragment;
    private UserRepository userRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            showFragment(ShowFragment.newInstance());
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.showfragment, fragment);
        transaction.commitNow();
        shownFragment = fragment;
    }
}
