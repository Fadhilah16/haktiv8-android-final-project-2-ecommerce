package com.hacktiv.ecommerce.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.FirebaseConfig;


public class StaffLoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginBtn;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.staffLoginBtn);
        progressBar = findViewById(R.id.staffLoginProgressBar);

        getSupportActionBar().hide();
        if(savedInstanceState!= null) {
           username.setText(savedInstanceState.getString("username"));
           password.setText(savedInstanceState.getString("password"));
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().trim().isEmpty() && password.getText().toString().trim().isEmpty()){
                    Toast.makeText(StaffLoginActivity.this, "Username and Password cannot be empty\n ", Toast.LENGTH_SHORT).show();
                }else if(username.getText().toString().trim().isEmpty()){
                        Toast.makeText(StaffLoginActivity.this, "Username cannot be empty\n ", Toast.LENGTH_SHORT).show();

                }else  if (password.getText().toString().trim().isEmpty()){
                    Toast.makeText(StaffLoginActivity.this, "Password cannot be empty\n ", Toast.LENGTH_SHORT).show();
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                    FirebaseConfig.firestore.collection("users").whereEqualTo("username", username.getText().toString().trim()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if (task.isSuccessful()){
                                for (QueryDocumentSnapshot document : task.getResult()){

                                    FirebaseConfig.auth.signInWithEmailAndPassword(document.getString("email"), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {

                                            if(task.isSuccessful()){
                                                startActivity(new Intent(StaffLoginActivity.this, MainActivity.class));
                                            }else{
                                                Toast.makeText(StaffLoginActivity.this, "Username or Password is wrong", Toast.LENGTH_SHORT).show();
                                            }
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    });
                                }
                            }else {
                                Toast.makeText(StaffLoginActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });


                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("username", username.getText().toString());
        outState.putString("password", password.getText().toString());
        super.onSaveInstanceState(outState);
    }
}