package com.hacktiv.ecommerce.activities.groceries_product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.ClothingAdapter;
import com.hacktiv.ecommerce.configurations.ElectronicsAdapter;
import com.hacktiv.ecommerce.configurations.GroceriesAdapter;

import java.util.ArrayList;

public class GroceriesProductActivity extends AppCompatActivity {

    RecyclerView recyclerView_groceries;
    ArrayList<String> title, image;
    GroceriesAdapter groceriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries_product);

        recyclerView_groceries = (RecyclerView) findViewById(R.id.recycler_view_groceries);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Spinach");
        title.add("Tomato");
        title.add("Cucumber");
        image.add(String.valueOf(R.drawable.spinach));
        image.add(String.valueOf(R.drawable.tomato));
        image.add(String.valueOf(R.drawable.cucumber));

        groceriesAdapter = new GroceriesAdapter(GroceriesProductActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView_groceries.setLayoutManager(gridLayoutManager);
        recyclerView_groceries.setAdapter(groceriesAdapter);
    }
}