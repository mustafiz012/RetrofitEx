package com.android.musta.retroexample.models;

import com.google.gson.annotations.SerializedName;

public class DatumModel {

    @SerializedName("_id")
    public String id;
    @SerializedName("lng")
    public String lng;
    @SerializedName("lat")
    public String lat;
    @SerializedName("when")
    public String when;

    public String getId() {
        return id;
    }

    public String getLng() {
        return lng;
    }

    public String getLat() {
        return lat;
    }

    public String getWhen() {
        return when;
    }

}