package com.example.food.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.food.R;
import com.example.food.databinding.ActivityLoginBinding;
import com.example.food.util.ToastUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * @author wellorbetter
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener, OnCompleteListener<AuthResult> {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initEvent();
    }

    private void initEvent() {
        binding.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_login) {
            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();
            if (!email.isEmpty() && !password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this);
            } else {
                ToastUtil.newInstance(getApplicationContext()).toastShort("请输入完整的邮箱和密码");
            }
        }
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            ToastUtil.newInstance(getApplicationContext()).toastShort("登录失败");
        }
    }
}