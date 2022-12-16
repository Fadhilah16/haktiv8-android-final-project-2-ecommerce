package com.hacktiv.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.hacktiv.ecommerce.R;

public class AboutUsActivity extends AppCompatActivity {
   private TextView[] members;
   private TextView[] memberCodes;
    private ImageView backIcon, profileIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Resources res = getResources();
        backIcon = findViewById(R.id.back_icon);
        profileIcon = findViewById(R.id.profile);

        members = new TextView[4];
        memberCodes = new TextView[4];
        for(int i=0;i<4;i++){
            members[i] = new TextView(getApplicationContext());
            memberCodes[i] = new TextView(getApplicationContext());
        }

        String[] membersNames = res.getStringArray(R.array.member);
        String[] membersCodes = res.getStringArray(R.array.member_code);
        members[0] = findViewById(R.id.member1);
        memberCodes[0] = findViewById(R.id.memberCode1);
        members[1] = findViewById(R.id.member2);
        memberCodes[1] = findViewById(R.id.memberCode2);
        members[2] = findViewById(R.id.member3);
        memberCodes[2] = findViewById(R.id.memberCode3);
        members[3] = findViewById(R.id.member4);
        memberCodes[3] = findViewById(R.id.memberCode4);
        for (int i=0;i<4;i++){
            members[i].setText(membersNames[i]);
            memberCodes[i].setText(membersCodes[i]);
        }
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AboutUsActivity.this, ProfileActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}