package com.hacktiv.ecommerce.activities.electronics_product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.ClothingAdapter;
import com.hacktiv.ecommerce.configurations.ElectronicsAdapter;

import java.util.ArrayList;

public class ElectronicsProductActivity extends AppCompatActivity {

    RecyclerView recyclerView_electronics;
    ArrayList<String> title, image;
    ElectronicsAdapter electronicsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_product);

        recyclerView_electronics = findViewById(R.id.recycler_view_electronics);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Laptop");
        title.add("Smartphone");
        image.add(String.valueOf(R.drawable.computer));
        image.add(String.valueOf(R.drawable.smartphone));

        electronicsAdapter = new ElectronicsAdapter(ElectronicsProductActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView_electronics.setLayoutManager(gridLayoutManager);
        recyclerView_electronics.setAdapter(electronicsAdapter);
    }
}