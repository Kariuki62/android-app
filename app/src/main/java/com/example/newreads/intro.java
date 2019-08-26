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

public class intro extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.EditName) TextView mEditTextView;
    @BindView(R.id.welcomeView1button) Button mViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);

//        Typeface pacificFont = Typeface.createFromAsset(getAssets(), "fonts/pacific.ttf");
//        mEditTextView.setTypeface(pacificFont);

        mViewButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v == mViewButton) {
            String location = mEditTextView.getText().toString();
            Intent intent = new Intent(intro.this, MainActivity.class);
            intent.putExtra("MainActivity",location);
            startActivity(intent);
        }
    }


}
