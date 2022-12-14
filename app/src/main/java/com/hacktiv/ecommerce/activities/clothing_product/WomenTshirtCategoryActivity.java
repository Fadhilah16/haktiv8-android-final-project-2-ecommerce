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
import com.hacktiv.ecommerce.configurations.TshirtWomenAdapter;

import java.util.ArrayList;

public class WomenTshirtCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewWomenClothingTshirtCategory;
    ArrayList<String> title, image;
    TshirtWomenAdapter TshirtWomenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_tshirt_category);

        recyclerViewWomenClothingTshirtCategory = findViewById(R.id.recycler_view_clothing_women_tshirt_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Green T-Shirt Women");
        title.add("Adidas Women's Badge of Sport Classic Tee Mauve White");
        title.add("Women's Short Sleeve Ribbed T-Shirt - A New Day™");
        image.add(String.valueOf(R.drawable.women_tshirt));
        image.add(String.valueOf(R.drawable.women_tshirt_2));
        image.add(String.valueOf(R.drawable.women_tshirt_3));

        TshirtWomenAdapter = new TshirtWomenAdapter(WomenTshirtCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewWomenClothingTshirtCategory.setLayoutManager(gridLayoutManager);
        recyclerViewWomenClothingTshirtCategory.setAdapter(TshirtWomenAdapter);


    }
}