package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.booklibrary.Adapter.CustomAdapter;
import com.example.booklibrary.SQLiteConnection.SQLiteHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton addButton;
    private SQLiteHelper sqLiteHelper;
    private ArrayList<String> book_id, book_title, book_author, book_pages;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.floatingActionButton);
        sqLiteHelper = new SQLiteHelper(MainActivity.this);

        book_id = new ArrayList<>();
        book_title = new ArrayList<>();
        book_author = new ArrayList<>();
        book_pages = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        storeDataInArrays();
        customAdapter = new CustomAdapter(book_id, book_title, book_author, book_pages, MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(customAdapter);
    }

    public void storeDataInArrays(){
        Cursor cursor = sqLiteHelper.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        } else {
             while (cursor.moveToNext()) {
                 book_id.add(cursor.getString(0));
                 book_title.add(cursor.getString(1));
                 book_author.add(cursor.getString(2));
                 book_pages.add(cursor.getString(3));
                 Log.e("Title", String.valueOf(book_title));
             }
        }
    }

}