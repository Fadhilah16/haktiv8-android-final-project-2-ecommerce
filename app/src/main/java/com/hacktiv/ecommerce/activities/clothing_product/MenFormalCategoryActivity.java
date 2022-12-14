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
import com.hacktiv.ecommerce.configurations.FormalMenAdapter;

import java.util.ArrayList;

public class MenFormalCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewMenClothingFormalCategory;
    ArrayList<String> title, image;
    FormalMenAdapter clothingMenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_formal_category);

        recyclerViewMenClothingFormalCategory = findViewById(R.id.recycler_view_clothing_men_formal_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("C-3525");
        title.add("COOFANDY Men's Suit");
        title.add("C2S Men's British Gentleman Dress Suit");
        image.add(String.valueOf(R.drawable.men_formal));
        image.add(String.valueOf(R.drawable.men_formal_2));
        image.add(String.valueOf(R.drawable.men_formal_3));

        clothingMenAdapter = new FormalMenAdapter(MenFormalCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewMenClothingFormalCategory.setLayoutManager(gridLayoutManager);
        recyclerViewMenClothingFormalCategory.setAdapter(clothingMenAdapter);


    }
}