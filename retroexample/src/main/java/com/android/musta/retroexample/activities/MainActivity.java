package com.android.musta.retroexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.musta.retroexample.R;
import com.android.musta.retroexample.models.Hero;
import com.android.musta.retroexample.rest.ApiClient;
import com.android.musta.retroexample.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getHeroes();
    }

    private void getHeroes() {
        Retrofit retrofit = ApiClient.getRetroClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Hero>> call = apiInterface.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                Log.i(TAG, "onResponse: " + response);
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
