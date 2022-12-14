package com.hacktiv.ecommerce.activities.clothing_product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.activities.ClothingProductActivity;
import com.hacktiv.ecommerce.configurations.BottomwearMenAdapter;
import com.hacktiv.ecommerce.configurations.ClothingAdapter;
import com.hacktiv.ecommerce.configurations.ClothingMenAdapter;

import java.util.ArrayList;

public class MenBottomwearCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewMenClothingBottomwearCategory;
    ArrayList<String> title, image;
    BottomwearMenAdapter bottomwearMenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_bottomwear_category);

        recyclerViewMenClothingBottomwearCategory = findViewById(R.id.recycler_view_clothing_men_bottom_wear_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Running Jogging Bottoms by Crosshatch");
        title.add("VIMAL JONNEY Men's Slim Fit Track pants");
        title.add("Sherpa Joggers");
        image.add(String.valueOf(R.drawable.men_bottomwear));
        image.add(String.valueOf(R.drawable.men_bottomwear_2));
        image.add(String.valueOf(R.drawable.men_bottomwear_3));

        bottomwearMenAdapter = new BottomwearMenAdapter(MenBottomwearCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewMenClothingBottomwearCategory.setLayoutManager(gridLayoutManager);
        recyclerViewMenClothingBottomwearCategory.setAdapter(bottomwearMenAdapter);


    }
}