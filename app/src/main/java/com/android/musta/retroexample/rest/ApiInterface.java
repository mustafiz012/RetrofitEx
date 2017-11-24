package com.android.musta.retroexample.rest;

import com.android.musta.retroexample.models.DatumModelParent;
import com.android.musta.retroexample.models.ParentModel;
import com.android.musta.retroexample.utils.MyConstants;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by musta on 11/22/17.
 */

public interface ApiInterface {
    @GET("" + MyConstants.API_END_POINT_LAST_LOCATION)
    Call<ParentModel> getLastLocation(@QueryMap Map<String, String> params);

    @POST("" + MyConstants.API_END_POINT_LOCATIONS)
    Call<DatumModelParent> getLocations(@QueryMap Map<String, String> params);
}
