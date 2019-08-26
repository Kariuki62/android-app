package com.example.newreads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class books extends AppCompatActivity {
    @BindView(R.id.booksTextView) TextView mTextView;
    @BindView(R.id.appNameTextView) ListView mListView;
    private String[] books = new String[]{"Android Point", "purple", "azkaban", "gatsby", "flights"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        ButterKnife.bind(this);

        mTextView= (TextView) findViewById(R.id.booksTextView);
        mListView = (ListView) findViewById(R.id.listView);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, books);
        mListView.setAdapter(adapter);

        Intent intent = getIntent();
        String location = intent.getStringExtra("books");
        mTextView.setText("Here are all the books: ");

    }
}
