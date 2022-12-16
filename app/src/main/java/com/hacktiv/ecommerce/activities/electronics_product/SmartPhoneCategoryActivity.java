package com.hacktiv.ecommerce.activities.electronics_product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.ClothingAdapter;
import com.hacktiv.ecommerce.configurations.LaptopAdapter;
import com.hacktiv.ecommerce.configurations.SmartPhoneAdapter;

import java.util.ArrayList;

public class SmartPhoneCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView_electronics_smartphone;
    ArrayList<String> title, image;
    SmartPhoneAdapter smartPhoneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_phone_category);

        recyclerView_electronics_smartphone = findViewById(R.id.recycler_view_electronics_smartphone);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Samsung Galaxy Z Flip");
        title.add("Samsung Galaxy A13");
        title.add("Apple iPhone 11 Pro");
        image.add(String.valueOf(R.drawable.smartphone_1));
        image.add(String.valueOf(R.drawable.smartphone_2));
        image.add(String.valueOf(R.drawable.smartphone_3));

        smartPhoneAdapter = new SmartPhoneAdapter(SmartPhoneCategoryActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView_electronics_smartphone.setLayoutManager(gridLayoutManager);
        recyclerView_electronics_smartphone.setAdapter(smartPhoneAdapter);
    }
}