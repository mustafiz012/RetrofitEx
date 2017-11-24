package com.android.musta.retroexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.musta.retroexample.R;

/**
 * Created by musta on 11/24/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public static TextView time, lat, lng;

    public MyViewHolder(View itemView) {
        super(itemView);
        time = itemView.findViewById(R.id.time);
        lat = itemView.findViewById(R.id.lat);
        lng = itemView.findViewById(R.id.lng);
    }
}
