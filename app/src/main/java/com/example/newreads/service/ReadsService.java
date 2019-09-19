package com.example.newreads.service;

import android.util.Log;

import com.example.newreads.models.Books2;
import com.example.newreads.constants.Constants1;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ReadsService {
    private static final String TAG = ReadsService.class.getSimpleName();

    public static void findTitle(String q, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants1.GOODREADS_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants1.GOODREADS_BOOKS_QUERY_PARAMETER, q);
        String url = urlBuilder.build().toString();
        Log.e(TAG, url);

        Request request = new Request.Builder()
                .url(url)
                .header("key", Constants1.GOODREADS_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static ArrayList<Books2> processResults(Response response) {
        ArrayList<Books2> books = new ArrayList<>();
        Gson gson = new Gson();
        try {
            String xmlData = response.body().string();
            JSONObject obj = new JSONObject(xmlData);
            JSONArray worksJSONArray = obj.getJSONArray("results");
            if (response.isSuccessful()){
                Type listType = new TypeToken<List<Books2>>(){}.getType();
                books = gson.fromJson(worksJSONArray.toString(),listType);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return books;
    }
}