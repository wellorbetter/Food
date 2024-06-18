package com.example.food.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.food.R;
import com.example.food.databinding.ActivityIntroBinding;

/**
 * @author wellorbetter
 */
public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5"));
        initEvent();
    }

    private void initEvent() {
        binding.tvLogin.setOnClickListener(this);
        binding.tvSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_login) {

        } else if (id == R.id.tv_signup) {

        }
    }
}