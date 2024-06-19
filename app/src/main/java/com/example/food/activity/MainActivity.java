package com.example.food.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.food.R;
import com.example.food.adapter.BestFoodsAdapter;
import com.example.food.adapter.CategoryAdapter;
import com.example.food.bean.Category;
import com.example.food.bean.Food;
import com.example.food.bean.Location;
import com.example.food.bean.Price;
import com.example.food.bean.Time;
import com.example.food.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author wellorbetter
 */
public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
    }

    private void initData() {
        initLocation();
        initTime();
        initPrice();
        initBestFood();
        initCategory();
    }

    private void initCategory() {
        DatabaseReference mRef = database.getReference("Category");
        binding.pbCategory.setVisibility(View.VISIBLE);
        List<Category> categories = new ArrayList<>();
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        categories.add(issue.getValue(Category.class));
                    }
                    if (categories.size() > 0) {
                        binding.rvCategory.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
                        CategoryAdapter categoryAdapter = new CategoryAdapter(R.layout.item_category, categories);
                        binding.rvCategory.setAdapter(categoryAdapter);
                    }
                    binding.pbCategory.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initBestFood() {
        DatabaseReference mRef = database.getReference("Foods");
        binding.pbBest.setVisibility(View.VISIBLE);
        List<Food> foods = new ArrayList<>();
        Query query = mRef.orderByChild("BestFood").equalTo(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        foods.add(issue.getValue(Food.class));
                    }
                    if (foods.size() > 0) {
                        binding.rvBest.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
                        BestFoodsAdapter bestFoodsAdapter = new BestFoodsAdapter(R.layout.item_best_food, foods);
                        binding.rvBest.setAdapter(bestFoodsAdapter);
                    }
                    binding.pbBest.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initLocation() {
        DatabaseReference mRef = database.getReference("Location");
        List<Location> locations = new ArrayList<>();
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        locations.add(issue.getValue(Location.class));
                    }
                    ArrayAdapter<Location> spinnerAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.item_spinner, locations);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.snLocation.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void initTime() {
        DatabaseReference mRef = database.getReference("Time");
        List<Time> times = new ArrayList<>();
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        times.add(issue.getValue(Time.class));
                    }
                    ArrayAdapter<Time> spinnerAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.item_spinner, times);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.snTime.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void initPrice() {
        DatabaseReference mRef = database.getReference("Price");
        List<Price> prices = new ArrayList<>();
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        prices.add(issue.getValue(Price.class));
                    }
                    ArrayAdapter<Price> spinnerAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.item_spinner, prices);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.snPrice.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}