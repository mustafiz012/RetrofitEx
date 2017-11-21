package com.android.musta.retrofitex.rest;

import com.android.musta.retrofitex.models.LocationDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by musta on 11/22/17.
 */

public interface ApiInterface {
    @GET
    Call<LocationDataResponse> getLastLocation(@Query("api_token") String apiToken);
}
