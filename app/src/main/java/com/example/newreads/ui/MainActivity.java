package com.example.newreads.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, library.class);
                intent.putExtra("he", mEnterBookName.getText().toString());
                startActivity(intent);
            }
        }
}
