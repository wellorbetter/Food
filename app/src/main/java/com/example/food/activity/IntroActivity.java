package com.example.food.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.food.R;
import com.example.food.databinding.ActivityIntroBinding;

/**
 * @author wellorbetter
 */
public class IntroActivity extends BaseActivity implements View.OnClickListener {

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
            // 如果当前已经有用户了，就自动登录
            if (mAuth.getCurrentUser() != null) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
        } else if (id == R.id.tv_signup) {
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
        }
    }
}