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
import com.hacktiv.ecommerce.configurations.FormalWomenAdapter;

import java.util.ArrayList;

public class WomenFormalCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewWomenClothingFormalCategory;
    ArrayList<String> title, image;
    FormalWomenAdapter FormalWomenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_formal_category);

        recyclerViewWomenClothingFormalCategory = findViewById(R.id.recycler_view_clothing_women_formal_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Women’s Coats Suit Set");
        title.add("Women's Formal Waistcoat");
        title.add("Fabric Formal Uniform Designs Pantsuits Vest Coat & Waistcoat Ladies Blazers Women");

        image.add(String.valueOf(R.drawable.women_formal));
        image.add(String.valueOf(R.drawable.women_formal_2));
        image.add(String.valueOf(R.drawable.women_formal_3));

        FormalWomenAdapter = new FormalWomenAdapter(WomenFormalCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewWomenClothingFormalCategory.setLayoutManager(gridLayoutManager);
        recyclerViewWomenClothingFormalCategory.setAdapter(FormalWomenAdapter);


    }
}