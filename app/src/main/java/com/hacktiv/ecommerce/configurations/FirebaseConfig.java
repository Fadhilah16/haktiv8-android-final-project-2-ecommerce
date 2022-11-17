package com.hacktiv.ecommerce.configurations;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseConfig {
    public final static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public final static FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    public final static FirebaseAuth auth = FirebaseAuth.getInstance();

    public static DatabaseReference getReference(String path){
        return database.getReference(path);
    }

    public static DatabaseReference getRootReference(){
        return database.getReference();
    }


}
