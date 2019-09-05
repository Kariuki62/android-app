package com.example.newreads.ui;


import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newreads.R;
import com.example.newreads.adapter.LibraryListAdapter;
import com.example.newreads.models.Bookss;
import com.example.newreads.service.ReadService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class library extends AppCompatActivity {
    public static final String TAG = library.class.getSimpleName();

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private LibraryListAdapter mAdapter;
    private ArrayList<Bookss> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);
        String title = "harry potter";
        getTitle(title);


        Intent intent = getIntent();
        String location = intent.getStringExtra("library");

    }
    private void getTitle(String title){
            final ReadService readService = new ReadService();
            readService.findTitle(title, new Callback() {

                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) {
                    books = readService.processResults(response);
                    library.this.runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            mAdapter = new LibraryListAdapter(getApplicationContext(), books);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager =
                                    new LinearLayoutManager(library.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);

                        }
                    });
                }
            });
        }
    }




