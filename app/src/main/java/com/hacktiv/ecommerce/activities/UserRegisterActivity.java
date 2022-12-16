package com.hacktiv.ecommerce.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.FirebaseConfig;
import com.hacktiv.ecommerce.models.enums.RoleTypes;

import java.util.HashMap;
import java.util.Map;

public class UserRegisterActivity extends AppCompatActivity {

    private EditText username, email, password, confirmPassword;
    private Button registerBtn;
    private ProgressBar progressBar;
    private TextView loginLink, loginAsStaffLink, loginAsAdminLink;
    private ImageView passwordVisibility, confirmPasswordVisibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        registerBtn = findViewById(R.id.userRegisterBtn);
        progressBar = findViewById(R.id.userRegisterProgressBar);
        loginLink = findViewById(R.id.moveToLogin);
        loginAsStaffLink = findViewById(R.id.moveToLoginAsStaff);
        loginAsAdminLink = findViewById(R.id.moveToLoginAsAdmin);
        passwordVisibility = findViewById(R.id.passwordVisibility);
        confirmPasswordVisibility = findViewById(R.id.confirmPasswordVisibility);

        if(FirebaseConfig.auth.getCurrentUser() != null){
            startActivity(new Intent(UserRegisterActivity.this, HomepageActivity.class));
            finish();
        }

        if(savedInstanceState!= null) {
            username.setText(savedInstanceState.getString("username"));
            email.setText(savedInstanceState.getString("email"));
            password.setText(savedInstanceState.getString("password"));
        }

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserRegisterActivity.this, UserLoginActivity.class));
                finish();
            }
        });

        loginAsStaffLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserRegisterActivity.this, StaffLoginActivity.class));
                finish();
            }
        });

        loginAsAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserRegisterActivity.this, AdminLoginActivity.class));
                finish();
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

        confirmPasswordVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(confirmPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    confirmPasswordVisibility.setImageResource(R.drawable.hide);
                    confirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    confirmPasswordVisibility.setImageResource(R.drawable.show);
                    confirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });



        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().trim().isEmpty() || email.getText().toString().trim().isEmpty() ||password.getText().toString().trim().isEmpty()){
                    Toast.makeText(UserRegisterActivity.this, "You must fill in all fields", Toast.LENGTH_SHORT).show();
                }else if(username.getText().toString().trim().isEmpty()){
                    Toast.makeText(UserRegisterActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();

                }else if (email.getText().toString().trim().isEmpty()){
                    Toast.makeText(UserRegisterActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches()){
                    Toast.makeText(UserRegisterActivity.this, "Email is not valid", Toast.LENGTH_SHORT).show();
                }
                else  if (password.getText().toString().trim().isEmpty()){
                    Toast.makeText(UserRegisterActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    if(!password.getText().toString().trim().equals(confirmPassword.getText().toString().trim())){
                        Toast.makeText(UserRegisterActivity.this, "Password dan password confirmation do not match.",  Toast.LENGTH_SHORT).show();
                    }else{
                        progressBar.setVisibility(View.VISIBLE);

                        FirebaseConfig.firestore.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                Boolean usernameExists = false;
                                Boolean emailExists = false;

                                if(task.isSuccessful()){
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                       if (document.getString("username").equals(username.getText().toString().trim())){
                                           usernameExists = true;

                                       }
                                       if(document.getString("email").equals(email.getText().toString().trim())){
                                           emailExists = true;
                                       }
                                    }
                                    if(usernameExists){
                                        Toast.makeText(UserRegisterActivity.this, "Username has already taken.",  Toast.LENGTH_SHORT).show();
                                    }
                                    if(emailExists){
                                        Toast.makeText(UserRegisterActivity.this, "Email has already taken.",  Toast.LENGTH_SHORT).show();
                                    }

                                    if(!usernameExists && !emailExists){
                                        createUser();
                                    }
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });
//

                    }

                }
            }
        });
    }

    private void createUser(){
        FirebaseConfig.auth.createUserWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString()).addOnCompleteListener(UserRegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseConfig.auth.getCurrentUser();
                    Map<String, Object> userDetail = new HashMap<>();
                    userDetail.put("email", email.getText().toString().trim());
                    userDetail.put("username", username.getText().toString().trim());
                    userDetail.put("role", RoleTypes.CUSTOMER.name());

                    FirebaseConfig.firestore.collection("users").document(user.getUid()).set(userDetail).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(UserRegisterActivity.this, "successfully registered",  Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(UserRegisterActivity.this, UserLoginActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(UserRegisterActivity.this, "Failed to register",  Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(UserRegisterActivity.this, task.getException().getMessage().toString(),  Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("username", username.getText().toString());
        outState.putString("email", password.getText().toString());
        outState.putString("password", password.getText().toString());
        super.onSaveInstanceState(outState);
    }
}