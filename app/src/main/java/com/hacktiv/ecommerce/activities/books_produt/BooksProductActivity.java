package com.hacktiv.ecommerce.activities.books_produt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.configurations.BooksAdapter;
import com.hacktiv.ecommerce.configurations.ClothingAdapter;
import com.hacktiv.ecommerce.configurations.ElectronicsAdapter;

import java.util.ArrayList;

public class BooksProductActivity extends AppCompatActivity {

    RecyclerView recyclerView_book;
    ArrayList<String> title, image;
    BooksAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_product);

        recyclerView_book = findViewById(R.id.recycler_view_book);
        title = new ArrayList<>();
        image = new ArrayList<>();

        title.add("Rich Dad Poor Dad by Kiyosaki");
        title.add("Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones");
        title.add("Good to Great: Why Some Companies Make the Leap...and Others Don't");
        image.add(String.valueOf(R.drawable.book_1));
        image.add(String.valueOf(R.drawable.book_2));
        image.add(String.valueOf(R.drawable.book_3));

        booksAdapter = new BooksAdapter(BooksProductActivity.this, title, image);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView_book.setLayoutManager(gridLayoutManager);
        recyclerView_book.setAdapter(booksAdapter);
    }
}