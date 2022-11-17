package com.hacktiv.ecommerce.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.ProductAdapter;
import com.hacktiv.ecommerce.models.Product;
import com.hacktiv.ecommerce.models.Promo;

import java.util.ArrayList;

public class HomepageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Product> list;
    ArrayList<Promo> listPromo;
    ProductAdapter adapter;
    DatabaseReference productRef, categoriesProductRef, databasePromo;
    ImageSlider imageSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        imageSlider = findViewById(R.id.promo_slider);
        recyclerView = findViewById(R.id.recycler_view);
        productRef = FirebaseDatabase.getInstance().getReference("products");
        databasePromo = FirebaseDatabase.getInstance().getReference("promo");
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        listPromo = new ArrayList<>();
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        adapter = new ProductAdapter(this, list);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        productRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Product product = dataSnapshot.getValue(Product.class);
                    list.add(product);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databasePromo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Promo promo = dataSnapshot.getValue(Promo.class);
                    slideModels.add(new SlideModel(promo.getImg(), ScaleTypes.FIT));
                    Log.d("ImageUrlPromo", promo.getImg());
                }
                adapter.notifyDataSetChanged();
                imageSlider.setImageList(slideModels, ScaleTypes.FIT);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}