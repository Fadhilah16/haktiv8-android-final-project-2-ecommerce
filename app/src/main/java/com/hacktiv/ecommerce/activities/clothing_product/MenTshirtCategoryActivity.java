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
import com.hacktiv.ecommerce.configurations.TshirtMenAdapter;

import java.util.ArrayList;

public class MenTshirtCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewMenTshirtCategory;
    ArrayList<String> title, image;
    TshirtMenAdapter tshirtMenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_tshirt_category);

        recyclerViewMenTshirtCategory = findViewById(R.id.recycler_view_clothing_men_tshirt_category);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Yellow Shirt");
        title.add("Namaste Shirt");
        title.add("Beard Shirt");
        image.add(String.valueOf(R.drawable.men_tshirt));
        image.add(String.valueOf(R.drawable.men_tshirt_2));
        image.add(String.valueOf(R.drawable.men_tshirt_3));

        tshirtMenAdapter = new TshirtMenAdapter(MenTshirtCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewMenTshirtCategory.setLayoutManager(gridLayoutManager);
        recyclerViewMenTshirtCategory.setAdapter(tshirtMenAdapter);


    }
}