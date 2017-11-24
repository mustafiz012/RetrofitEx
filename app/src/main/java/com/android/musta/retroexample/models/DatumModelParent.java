package com.android.musta.retroexample.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatumModelParent {

    @SerializedName("status")
    public Integer status;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public List<DatumModel> data = null;

}