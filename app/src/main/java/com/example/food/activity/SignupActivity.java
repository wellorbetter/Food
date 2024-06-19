package com.example.food.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.food.R;
import com.example.food.databinding.ActivitySignupBinding;
import com.example.food.util.ToastUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * @author wellorbetter
 */
public class SignupActivity extends BaseActivity implements View.OnClickListener, OnCompleteListener<AuthResult> {
    ActivitySignupBinding binding;
    final int MIN_PASSWORD_LEN = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initEvent();
    }

    private void initEvent() {
        binding.btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_signup) {
            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();
            if (password.length() < MIN_PASSWORD_LEN) {
                ToastUtil.newInstance(getApplicationContext()).toastShort("密码至少需要六位");
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this);
        }
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            Log.i(TAG, "onComplete: ");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Log.i(TAG, "failure: " + task.getException());
            ToastUtil.newInstance(getApplicationContext()).toastShort("登录失败");
        }
    }
}