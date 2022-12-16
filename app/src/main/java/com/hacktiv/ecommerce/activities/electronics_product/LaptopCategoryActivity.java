package com.hacktiv.ecommerce.activities.electronics_product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.ClothingAdapter;
import com.hacktiv.ecommerce.configurations.LaptopAdapter;

import java.util.ArrayList;

public class LaptopCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView_electronics_laptop;
    ArrayList<String> title, image;
    LaptopAdapter laptopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_category);

        recyclerView_electronics_laptop = findViewById(R.id.recycler_view_electronics_laptop);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("MacBook PRO 16 MK1E3ID/A(Apple M1 PRO/16GB/512GB SSD/16\"/MAC OS/SILVER");
        title.add("Asus VivoBook S412");
        title.add("ASUS 15.6\" Republic of Gamers Zephyrus Duo 15 Gaming Laptop,");
        image.add(String.valueOf(R.drawable.computer));
        image.add(String.valueOf(R.drawable.laptop_2));
        image.add(String.valueOf(R.drawable.laptop_3));

        laptopAdapter = new LaptopAdapter(LaptopCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView_electronics_laptop.setLayoutManager(gridLayoutManager);
        recyclerView_electronics_laptop.setAdapter(laptopAdapter);
    }
}