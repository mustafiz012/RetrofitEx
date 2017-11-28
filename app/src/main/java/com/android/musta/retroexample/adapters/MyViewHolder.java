package com.android.musta.retroexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.musta.retroexample.R;

/**
 * Created by musta on 11/24/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "MyViewHolder";
    public static TextView time, lat, lng;
    public static ImageButton clicking;

    public MyViewHolder(final View itemView) {
        super(itemView);
        time = itemView.findViewById(R.id.time);
        lat = itemView.findViewById(R.id.lat);
        lng = itemView.findViewById(R.id.lng);
        clicking = itemView.findViewById(R.id.clicking);
    }
}
