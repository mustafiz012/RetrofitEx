
package com.android.musta.retrofitex.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationData {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("time")
    @Expose
    private Integer time;

    /**
     * No args constructor for use in serialization
     */
    public LocationData() {
    }

    /**
     * @param time
     * @param lng
     * @param lat
     */
    public LocationData(Double lat, Double lng, Integer time) {
        super();
        this.lat = lat;
        this.lng = lng;
        this.time = time;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
