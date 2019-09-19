package com.example.newreads.ui;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.newreads.R;

import com.example.newreads.adapter.LibListAdapter;
import com.example.newreads.models.Books2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.newreads.constants.Constants1.GOODREADS_BASE_URL;

public class library1 extends AppCompatActivity {

    public static final String TAG = library1.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Books2> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        books = new ArrayList<>();
        loadRecyclerViewData();
    }

    private void loadRecyclerViewData() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                GOODREADS_BASE_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse (String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("items");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);

                                JSONObject volumeInfo = o.getJSONObject("volumeInfo");
                                Books2 books2 = new Books2(
                                         o.getString("kind"),
                                        o.getString("etag"),
                                        o.getString("id")
                                );

                                    books.add(books2);

                            }
                            mAdapter = new LibListAdapter(getApplicationContext(), books);
                            mRecyclerView.setAdapter(mAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    }