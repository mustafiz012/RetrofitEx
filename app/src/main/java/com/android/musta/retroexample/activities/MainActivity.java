package com.android.musta.retroexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.musta.retroexample.R;
import com.android.musta.retroexample.adapters.RecyclerAdapter;
import com.android.musta.retroexample.models.DataModel;
import com.android.musta.retroexample.models.DatumModel;
import com.android.musta.retroexample.models.DatumModelParent;
import com.android.musta.retroexample.models.ParentModel;
import com.android.musta.retroexample.rest.ApiClient;
import com.android.musta.retroexample.rest.ApiInterface;
import com.android.musta.retroexample.utils.MyConstants;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    private List<DatumModel> dataModel;
    private ApiInterface apiInterface = null;
    private Retrofit retrofit = null;
    private HashMap<String, String> params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        getLastLocation();
    }

    private void setupRecyclerView() {
        if (retrofit == null) retrofit = ApiClient.getRetroClient(MyConstants.BASE_URL);
        if (apiInterface == null) apiInterface = retrofit.create(ApiInterface.class);
        if (params == null) params = new HashMap<>();
        params.put("from_hr", "9");
        params.put("to_hr", "12");
        params.put("from_mn", "27");
        params.put("to_mn", "27");
        params.put("from_am", "AM");
        params.put("to_am", "PM");
        params.put("date", "11/20/2017");
        params.put("device_id", "59803f57dac1777e472e6322");
        params.put("login_token", "ed9d4a498f290f6056dcfafd1945e0f8bfa3ad20");
        Call<DatumModelParent> locationDataCall = apiInterface.getLocations(params);
        locationDataCall.enqueue(new Callback<DatumModelParent>() {
            @Override
            public void onResponse(Call<DatumModelParent> call, Response<DatumModelParent> response) {
                Log.i(TAG, "onResponse: " + response.raw());
                if (response.isSuccessful()) {
                    dataModel = response.body().data;
                    recyclerAdapter = new RecyclerAdapter(dataModel);
                    recyclerView.setAdapter(recyclerAdapter);
                }
            }

            @Override
            public void onFailure(Call<DatumModelParent> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getLastLocation() {
        Log.i(TAG, "getLastLocation: ");
        retrofit = ApiClient.getRetroClient(MyConstants.BASE_URL);
        apiInterface = retrofit.create(ApiInterface.class);
        params = new HashMap<>();
        params.put("api_token", "9tHTR5Up1cVeK171D56uvZH4UfOEnnk00vaHoZyiIfnf3le3jF9BIGYHyKwJ");
        Call<ParentModel> call = apiInterface.getLastLocation(params);
        call.enqueue(new Callback<ParentModel>() {
            @Override
            public void onResponse(Call<ParentModel> call, Response<ParentModel> response) {
                if (response.isSuccessful()) {
                    DataModel data = response.body().data;
                    Double lat = data.getLat();
                    Double lng = data.getLng();
                    int time = data.getTime();
                    Log.i(TAG, lat + " :lat--lng: " + lng);
                    setupRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<ParentModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
