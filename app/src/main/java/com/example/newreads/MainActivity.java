package com.example.newreads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bookstorebutton) Button mBookStoreButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        Typeface pacificFont = Typeface.createFromAsset(getAssets(), "fonts/pacific.ttf");
//        mAppNameTextView.setTypeface(pacificFont);

        mBookStoreButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mBookStoreButton) {
            String location = mAppNameTextView.getText().toString();
            Intent intent = new Intent(MainActivity.this, books.class);
            intent.putExtra("books", location);
            startActivity(intent);
        }
    }
}
