package com.hacktiv.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.FirebaseConfig;

public class MainActivity extends AppCompatActivity {

    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoutBtn = findViewById(R.id.logoutBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseConfig.auth.signOut();
                startActivity(new Intent(MainActivity.this, UserLoginActivity.class));
                finish();
            }
        });

    }
}