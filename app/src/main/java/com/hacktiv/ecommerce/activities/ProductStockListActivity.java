package com.hacktiv.ecommerce.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.FirebaseConfig;
import com.hacktiv.ecommerce.configurations.ProductStockAdapter;
import com.hacktiv.ecommerce.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductStockListActivity extends AppCompatActivity {
    private RecyclerView listView;
    private ImageView backIcon, profileIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_stock_list);

        backIcon = findViewById(R.id.back_icon);
        profileIcon = findViewById(R.id.profile);
        listView = findViewById(R.id.product_stock_list);
        List<Product> products = new ArrayList<>();

        ProductStockAdapter productStockAdapter = new ProductStockAdapter(this, products);
        listView.setAdapter(productStockAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);

        FirebaseConfig.getReference("products").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                products.clear();
                for(DataSnapshot typeSnapshot: snapshot.getChildren()){

                    for (DataSnapshot productSnapshot: typeSnapshot.child("product_list").getChildren()){
                        Product product = new Product();
                        product.setType(typeSnapshot.child("name").getValue().toString());
                        product.setTypeCode(typeSnapshot.getKey());
                        product.setCode(productSnapshot.getKey());
                        product.setName(productSnapshot.child("name").getValue().toString());
                        product.setCategory(productSnapshot.child("category").getValue().toString());
                        product.setStock(Integer.parseInt(productSnapshot.child("stock").getValue().toString()));
                        product.setPrice(Double.parseDouble(productSnapshot.child("price").getValue().toString()));
                        product.setImg(productSnapshot.child("img").getValue().toString());

                        products.add(product);
                    }

                }
                productStockAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Log.d("SIZE : ", String.valueOf(products.size()));

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductStockListActivity.this, ProfileActivity.class));
            }
        });

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}