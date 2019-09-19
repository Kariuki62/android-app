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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newreads.R;
import com.example.newreads.constants.Constants1;
import com.example.newreads.signup.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class intro1 extends AppCompatActivity implements View.OnClickListener{




    @BindView(R.id.EditName) TextView mEditTextView;
    @BindView(R.id.welcomeView1button) Button mViewButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);



        mViewButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v == mViewButton) {
            String location = mEditTextView.getText().toString();
            Intent intent = new Intent(intro1.this, MainActivity.class);
            intent.putExtra("MainActivity",location);
            startActivity(intent);
        }
    }





}
