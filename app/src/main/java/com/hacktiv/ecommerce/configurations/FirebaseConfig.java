package com.hacktiv.ecommerce.configurations;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConfig {
    final static FirebaseDatabase database = FirebaseDatabase.getInstance();

    public static DatabaseReference getReference(String path){
        return database.getReference(path);
    }

    public static DatabaseReference getRootReference(){
        return database.getReference();
    }


}
