
package com.android.musta.retroexample.models;

import com.google.gson.annotations.SerializedName;

public class LocationData {

    @SerializedName("status")
    public Integer status;
    @SerializedName("data")
    public Data data;

    /**
     * @param status
     * @param data
     */
    public LocationData(Integer status, Data data) {
        super();
        this.status = status;
        this.data = data;
    }
}