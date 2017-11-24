package com.android.musta.retroexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.musta.retroexample.R;
import com.android.musta.retroexample.models.Data;
import com.android.musta.retroexample.models.LocationData;
import com.android.musta.retroexample.rest.ApiClient;
import com.android.musta.retroexample.rest.ApiInterface;
import com.android.musta.retroexample.utils.MyConstants;

import java.util.HashMap;
import java.util.Map;

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
        getLastLocation();
    }

    private void getLastLocation() {
        Log.i(TAG, "getLastLocation: ");
        Retrofit retrofit = ApiClient.getRetroClient(MyConstants.BASE_URL);
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Map<String, String> params = new HashMap<>();
        params.put("api_token", "9tHTR5Up1cVeK171D56uvZH4UfOEnnk00vaHoZyiIfnf3le3jF9BIGYHyKwJ");
        Call<LocationData> call = apiInterface.getLastLocation(params);
        call.enqueue(new Callback<LocationData>() {
            @Override
            public void onResponse(Call<LocationData> call, Response<LocationData> response) {
                if (response.isSuccessful()) {
                    Data data = response.body().data;
                    Double lat = data.getLat();
                    Double lng = data.getLng();
                    int time = data.getTime();
                    Log.i(TAG, lat + " :lat--lng: " + lng);
                }
            }

            @Override
            public void onFailure(Call<LocationData> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
