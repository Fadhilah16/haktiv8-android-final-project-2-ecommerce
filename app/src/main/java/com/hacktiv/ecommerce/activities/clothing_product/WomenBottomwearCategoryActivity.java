package com.hacktiv.ecommerce.activities.clothing_product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.activities.ClothingProductActivity;
import com.hacktiv.ecommerce.configurations.BottomwearWomenAdapter;
import com.hacktiv.ecommerce.configurations.ClothingAdapter;
import com.hacktiv.ecommerce.configurations.ClothingMenAdapter;
import com.hacktiv.ecommerce.configurations.ClothingWomenAdapter;
import com.hacktiv.ecommerce.databinding.ActivityWomenBottomwearCategoryBinding;

import java.util.ArrayList;

public class WomenBottomwearCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewWomenClothingBottomwearCategory;
    ArrayList<String> title, image;
    BottomwearWomenAdapter bottomwearWomenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_bottomwear_category);

        recyclerViewWomenClothingBottomwearCategory = findViewById(R.id.recycler_view_clothing_women_bottomwear_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Trousers Women Bottom Wear Pyjama");
        title.add("Denim Capris with Semi-Elasticated Waistband");
        title.add("Red Cotton Lycra Trippy Pants");
        image.add(String.valueOf(R.drawable.woman_bottomwear));
        image.add(String.valueOf(R.drawable.women_bottomwear_2));
        image.add(String.valueOf(R.drawable.women_bottomwear_3));
        bottomwearWomenAdapter = new BottomwearWomenAdapter(WomenBottomwearCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewWomenClothingBottomwearCategory.setLayoutManager(gridLayoutManager);
        recyclerViewWomenClothingBottomwearCategory.setAdapter(bottomwearWomenAdapter);


    }
}