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

import java.util.ArrayList;

public class MenClothingActivity extends AppCompatActivity {

    RecyclerView recyclerViewMenClothingCategory;
    ArrayList<String> title, image;
    ClothingMenAdapter clothingMenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_clothing);

        recyclerViewMenClothingCategory = findViewById(R.id.recycler_view_clothing_men_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("T-Shirt");
        title.add("Formals");
        title.add("Bottom Wear");
        title.add("Shoes");
        image.add(String.valueOf(R.drawable.men_tshirt));
        image.add(String.valueOf(R.drawable.men_formal));
        image.add(String.valueOf(R.drawable.men_bottomwear));
        image.add(String.valueOf(R.drawable.men_shoes));

        clothingMenAdapter = new ClothingMenAdapter(MenClothingActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewMenClothingCategory.setLayoutManager(gridLayoutManager);
        recyclerViewMenClothingCategory.setAdapter(clothingMenAdapter);


    }
}