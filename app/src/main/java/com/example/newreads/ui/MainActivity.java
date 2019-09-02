package com.example.newreads.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newreads.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bookstorebutton) Button mBookStoreButton;
    @BindView(R.id.EnterBookName)
    EditText mEnterBookName;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBookStoreButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mBookStoreButton) {
            String location = mAppNameTextView.getText().toString();
            Intent intent = new Intent(MainActivity.this, books.class);
            intent.putExtra("", location);
            startActivity(intent);
        }
    }
}
