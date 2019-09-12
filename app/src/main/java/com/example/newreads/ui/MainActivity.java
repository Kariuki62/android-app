package com.example.newreads.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newreads.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Constants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.bookstorebutton) Button mBookStoreButton;
    @BindView(R.id.EnterBookName)
    EditText mEnterBookName;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mBookStoreButton.setOnClickListener(this);
    }

    @Override
        public void onClick(View v) {
            if(v == mBookStoreButton) {
                Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, library1.class);
                intent.putExtra("he", mEnterBookName.getText().toString());
                startActivity(intent);
            }
        }
    private void addToSharedPreferences(String books) {
        mEditor.putString(Constants1.GOODREADS_TOKEN,books).apply();
    }

}
