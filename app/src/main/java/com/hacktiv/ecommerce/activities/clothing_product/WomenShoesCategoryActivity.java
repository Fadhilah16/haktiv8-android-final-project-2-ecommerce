package com.hacktiv.ecommerce.activities.clothing_product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.activities.ClothingProductActivity;
import com.hacktiv.ecommerce.configurations.ClothingAdapter;
import com.hacktiv.ecommerce.configurations.ClothingMenAdapter;
import com.hacktiv.ecommerce.configurations.ClothingWomenAdapter;
import com.hacktiv.ecommerce.configurations.ShoesWomenAdapter;

import java.util.ArrayList;

public class WomenShoesCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewWomenClothingShoesCategory;
    ArrayList<String> title, image;
    ShoesWomenAdapter shoesWomenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_shoes_category);

        recyclerViewWomenClothingShoesCategory = findViewById(R.id.recycler_view_clothing_women_shoes_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("J. Adams Shirley Women's Chunky Block Strappy High Heel");
        title.add("Women's Lightweight Sock Sneakers");
        title.add("INC International Concepts Womens Kenjay Leather Pointed Toe D-orsay Pumps");

        image.add(String.valueOf(R.drawable.women_shoes_1));
        image.add(String.valueOf(R.drawable.women_shoes_2));
        image.add(String.valueOf(R.drawable.women_shoes_3));

        shoesWomenAdapter = new ShoesWomenAdapter(WomenShoesCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewWomenClothingShoesCategory.setLayoutManager(gridLayoutManager);
        recyclerViewWomenClothingShoesCategory.setAdapter(shoesWomenAdapter);


    }
}