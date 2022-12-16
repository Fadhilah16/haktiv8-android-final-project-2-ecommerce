package com.hacktiv.ecommerce.activities;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.FirebaseConfig;
import com.hacktiv.ecommerce.configurations.ProductTypeAdapter;
import com.hacktiv.ecommerce.models.ProductType;
import com.hacktiv.ecommerce.models.Promo;
import com.hacktiv.ecommerce.models.enums.RoleTypes;

import java.util.ArrayList;

public class HomepageActivity extends FragmentActivity {

    RecyclerView recyclerView;
    ArrayList<ProductType> list;
    ArrayList<Promo> listPromo;
    ProductTypeAdapter adapter;
    DatabaseReference productRef, categoriesProductRef, databasePromo;
    ImageSlider imageSlider;
    DrawerLayout drawer;
    ImageView menuImg, profileIcon;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        imageSlider = findViewById(R.id.promo_slider);
        recyclerView = findViewById(R.id.recycler_view);
        productRef = FirebaseConfig.database.getReference("products");
        databasePromo = FirebaseConfig.database.getReference("promo");
        recyclerView.setHasFixedSize(true);
        drawer = findViewById(R.id.drawer_layout);
        menuImg = findViewById(R.id.menu_icon);
        navView = findViewById(R.id.nav_view);
        profileIcon = findViewById(R.id.profile);

        FirebaseConfig.firestore.collection("users").document( FirebaseConfig.auth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()){
                        if (!document.getString("role").equals(RoleTypes.ADMIN.name())){
                            navView.getMenu().findItem(R.id.dashboard_menu).setVisible(false);
                        }
                    }
                }
            }
        });

        list = new ArrayList<>();
        listPromo = new ArrayList<>();
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        adapter = new ProductTypeAdapter(this, list);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        menuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);

            }
        });




        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case (R.id.home_menu):

                        break;

                    case (R.id.dashboard_menu):
                        startActivity(new Intent(HomepageActivity.this, AdminDashboardActivity.class));

                        break;

                    case (R.id.about_us_menu):
                        startActivity(new Intent(HomepageActivity.this, AboutUsActivity.class));

                        break;
                    case (R.id.logout):
                        FirebaseConfig.auth.signOut();
                        startActivity(new Intent(HomepageActivity.this, UserLoginActivity.class));

                        break;
                }
                return true;
            }

        });
        //Product

        productRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ProductType productType = dataSnapshot.getValue(ProductType.class);
                    list.add(productType);
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
//                    Log.d("ImageUrlPromo", promo.getImg());
                }
                adapter.notifyDataSetChanged();
                imageSlider.setImageList(slideModels, ScaleTypes.FIT);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomepageActivity.this, ProfileActivity.class));
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sliding_menu, menu);


        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case (R.id.home_menu):

                break;

            case (R.id.dashboard_menu):
                startActivity(new Intent(HomepageActivity.this, AdminDashboardActivity.class));

                break;
            case (R.id.about_us_menu):
                startActivity(new Intent(HomepageActivity.this, AboutUsActivity.class));

                break;
            case (R.id.logout):
                FirebaseConfig.auth.signOut();
                startActivity(new Intent(HomepageActivity.this, UserLoginActivity.class));

            break;
        }

        return true;
    }
}