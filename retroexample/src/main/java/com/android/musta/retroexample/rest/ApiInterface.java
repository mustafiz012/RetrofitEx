package com.android.musta.retroexample.rest;

import com.android.musta.retroexample.models.LocationData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by musta on 11/22/17.
 */

public interface ApiInterface {
    //base url
    String BASE_URL = "http://myradar.com.bd/api/";

    //specific api endpoint
    @GET("59803f57dac1777e472e6322")
    Call<LocationData> getLastLocation(@QueryMap Map<String, String> params);
}
