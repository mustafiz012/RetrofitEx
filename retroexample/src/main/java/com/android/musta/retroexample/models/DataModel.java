package com.android.musta.retroexample.models;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("lat")
    private Double lat;
    @SerializedName("lng")
    private Double lng;
    @SerializedName("time")
    private Integer time;

    /**
     * @param time
     * @param lng
     * @param lat
     */
    public DataModel(Double lat, Double lng, Integer time) {
        super();
        this.lat = lat;
        this.lng = lng;
        this.time = time;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public Integer getTime() {
        return time;
    }
}