package com.hacktiv.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.ClothingAdapter;

import java.util.ArrayList;

public class ClothingProductActivity extends AppCompatActivity {

    RecyclerView recyclerView_clothing;
    ArrayList<String> title, image;
    ClothingAdapter clothingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_product);

        recyclerView_clothing = findViewById(R.id.recycler_view_clothing);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Men");
        title.add("Women");
        image.add(String.valueOf(R.drawable.man_category));
        image.add(String.valueOf(R.drawable.woman_category));

        clothingAdapter = new ClothingAdapter(ClothingProductActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView_clothing.setLayoutManager(gridLayoutManager);
        recyclerView_clothing.setAdapter(clothingAdapter);
    }
}