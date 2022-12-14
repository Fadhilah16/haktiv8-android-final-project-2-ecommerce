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

import java.util.ArrayList;

public class WomenClothingActivity extends AppCompatActivity {

    RecyclerView recyclerViewWomenClothingCategory;
    ArrayList<String> title, image;
    ClothingWomenAdapter clothingWomenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_clothing);

        recyclerViewWomenClothingCategory = findViewById(R.id.recycler_view_clothing_women_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("T-Shirt");
        title.add("Formals");
        title.add("Bottom Wear");
        title.add("Shoes");
        image.add(String.valueOf(R.drawable.women_tshirt));
        image.add(String.valueOf(R.drawable.women_formal));
        image.add(String.valueOf(R.drawable.woman_bottomwear));
        image.add(String.valueOf(R.drawable.women_shoes));

        clothingWomenAdapter = new ClothingWomenAdapter(WomenClothingActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewWomenClothingCategory.setLayoutManager(gridLayoutManager);
        recyclerViewWomenClothingCategory.setAdapter(clothingWomenAdapter);


    }
}