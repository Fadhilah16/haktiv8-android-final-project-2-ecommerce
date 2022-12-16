package com.hacktiv.ecommerce.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.FirebaseConfig;
import com.hacktiv.ecommerce.models.enums.RoleTypes;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginBtn;
    private ProgressBar progressBar;
    private TextView loginLink, registerLink, loginAsStaffLink;
    private ImageView passwordVisibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.adminLoginBtn);
        progressBar = findViewById(R.id.adminLoginProgressBar);
        loginLink = findViewById(R.id.moveToLogin);
        registerLink = findViewById(R.id.moveToRegister);
        loginAsStaffLink = findViewById(R.id.moveToLoginAsStaff);
        passwordVisibility = findViewById(R.id.passwordVisibility);

        if(FirebaseConfig.auth.getCurrentUser() != null){
            startActivity(new Intent(AdminLoginActivity.this, HomepageActivity.class));
            finish();
        }

        if(savedInstanceState!= null) {
            username.setText(savedInstanceState.getString("username"));
            password.setText(savedInstanceState.getString("password"));
        }

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminLoginActivity.this, UserLoginActivity.class));
            }
        });

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminLoginActivity.this, UserRegisterActivity.class));
            }
        });

        loginAsStaffLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminLoginActivity.this, StaffLoginActivity.class));
            }
        });

        passwordVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    passwordVisibility.setImageResource(R.drawable.hide);
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    passwordVisibility.setImageResource(R.drawable.show);
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().trim().isEmpty() && password.getText().toString().trim().isEmpty()){
                    Toast.makeText(AdminLoginActivity.this, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show();
                }else if(username.getText().toString().trim().isEmpty()){
                    Toast.makeText(AdminLoginActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();

                }else  if (password.getText().toString().trim().isEmpty()){
                    Toast.makeText(AdminLoginActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
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
                                                if (document.getString("role").equals(RoleTypes.ADMIN.name())){
                                                    startActivity(new Intent(AdminLoginActivity.this, HomepageActivity.class));
                                                    finish();
                                                }else{
                                                    Toast.makeText(AdminLoginActivity.this, "You are not admin.", Toast.LENGTH_SHORT).show();
                                                }

                                            }else{
                                                Toast.makeText(AdminLoginActivity.this, "Username or Password is wrong", Toast.LENGTH_SHORT).show();
                                            }
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    });
                                }
                            }else {
                                Toast.makeText(AdminLoginActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });


                }
            }
        });
    }


}