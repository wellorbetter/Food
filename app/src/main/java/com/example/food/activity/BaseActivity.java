package com.example.food.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.food.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


/**
 * @author wellorbetter
 */
public class BaseActivity extends AppCompatActivity {
    public String TAG = "SPECIFIC_TAG";
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance("https://food-2eafa-default-rtdb.asia-southeast1.firebasedatabase.app");
        mAuth = FirebaseAuth.getInstance();

        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }
}