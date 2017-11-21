package com.android.musta.retroexample.rest;

import com.android.musta.retroexample.models.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by musta on 11/22/17.
 */

public interface ApiInterface {
    //base url
    String BASE_URL = "http://myradar.com.bd/api/";

    //specific api endpoint
    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
