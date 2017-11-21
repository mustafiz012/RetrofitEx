package com.android.musta.retrofitex.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by musta on 11/22/17.
 */

public class ApiClient {
    public static final String BASE_URL = "http://myradar.com.bd/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetroClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
