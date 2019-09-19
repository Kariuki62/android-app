package com.example.newreads.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.newreads.R;
import com.example.newreads.constants.Constants1;
import com.example.newreads.signup.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
                Intent intent = new Intent(MainActivity.this, library1.class);
                intent.putExtra("he", mEnterBookName.getText().toString());
                startActivity(intent);
                Animatoo.animateSpin(this);
            }
        }




}
