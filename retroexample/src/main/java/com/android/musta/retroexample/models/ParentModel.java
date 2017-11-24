
package com.android.musta.retroexample.models;

import com.google.gson.annotations.SerializedName;

public class ParentModel {

    @SerializedName("status")
    public Integer status;
    @SerializedName("data")
    public DataModel data;

    /**
     * @param status
     * @param data
     */
    public ParentModel(Integer status, DataModel data) {
        super();
        this.status = status;
        this.data = data;
    }
}