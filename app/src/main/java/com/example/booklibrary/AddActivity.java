package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.booklibrary.SQLiteDatabase.SQLiteHelper;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AddActivity extends AppCompatActivity {

    private MaterialButton addBook;
    private TextInputEditText bookTitle, bookAuthor, noOfPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addBook = findViewById(R.id.addBook);
        bookTitle = findViewById(R.id.bookTitle);
        bookAuthor = findViewById(R.id.bookAuthor);
        noOfPages = findViewById(R.id.noOfPages);

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteHelper myDB = new SQLiteHelper(AddActivity.this);
                myDB.addBook(bookTitle.getText().toString(), bookAuthor.getText().toString(), Integer.parseInt(noOfPages.getText().toString()));
            }
        });

    }
}