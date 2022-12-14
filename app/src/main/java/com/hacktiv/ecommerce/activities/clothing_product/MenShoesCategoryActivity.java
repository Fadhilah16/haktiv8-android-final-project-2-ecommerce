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
import com.hacktiv.ecommerce.configurations.ShoesMenAdapter;

import java.util.ArrayList;

public class MenShoesCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewMenClothingShoesCategory;
    ArrayList<String> title, image;
    ShoesMenAdapter shoesMenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_shoes_category);

        recyclerViewMenClothingShoesCategory = findViewById(R.id.recycler_view_clothing_men_shoes_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Camfoot Men's Formal Shoes");
        title.add("Sketchers Men's Arch Fit Banlin Oxford Black");
        title.add("Sketchers Arch Fit Lace up Trainers Taupe");
        image.add(String.valueOf(R.drawable.men_shoes));
        image.add(String.valueOf(R.drawable.men_shoes_2));
        image.add(String.valueOf(R.drawable.men_shoes_3));

        shoesMenAdapter = new ShoesMenAdapter(MenShoesCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewMenClothingShoesCategory.setLayoutManager(gridLayoutManager);
        recyclerViewMenClothingShoesCategory.setAdapter(shoesMenAdapter);


    }
}