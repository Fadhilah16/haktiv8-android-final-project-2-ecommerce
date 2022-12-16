package com.hacktiv.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.FirebaseConfig;

public class AddStockActivity extends AppCompatActivity {
    private ImageView backIcon, profileIcon;
    private TextView code, productName, stock;
    private EditText quantity;
    private Button addQuantityBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);
        code = findViewById(R.id.code);
        productName = findViewById(R.id.productName);
        stock = findViewById(R.id.stock);
        addQuantityBtn = findViewById(R.id.addQuantityBtn);
        quantity = findViewById(R.id.quantity);
        profileIcon = findViewById(R.id.profile);

        Intent i =getIntent();
        Bundle data = i.getExtras();
        String typeCodeString = data.getString("type_code");
        String codeString = data.getString("code");
        String productNameString =  data.getString("product_name");
        String stockString = data.getString("stock");

        code.setText( codeString);
        productName.setText(productNameString);
        stock.setText(stockString);
        backIcon = findViewById(R.id.back_icon);

        addQuantityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q = Integer.parseInt(stockString);

                q += Integer.parseInt( quantity.getText().toString().trim());

                FirebaseConfig.getReference("products").child(typeCodeString).child("product_list").child(codeString).child("stock").setValue(q);
                stock.setText(String.valueOf(q));
                Toast.makeText(AddStockActivity.this, "Successfully add quantity", Toast.LENGTH_SHORT).show();
                quantity.setText("");
            }
        });

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStockActivity.this, ProfileActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}