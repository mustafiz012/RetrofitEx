package com.android.musta.retroexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.musta.retroexample.R;
import com.android.musta.retroexample.interfaces.OnItemClickListener;
import com.android.musta.retroexample.models.DatumModel;

import java.util.List;

/**
 * Created by musta on 11/24/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private static final String TAG = "RecyclerAdapter";
    public static List<DatumModel> itemList;
    private OnItemClickListener listener;
    private Context mContext;

    public RecyclerAdapter(List<DatumModel> itemList, Context context, OnItemClickListener listener) {
        RecyclerAdapter.itemList = itemList;
        this.mContext = context;
        this.listener = listener;
        for (int i = 0; i < itemList.size(); i++) {
            Log.i(TAG, i + ". " + itemList.get(i).getLat());
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        MyViewHolder.time.setText("" + itemList.get(position).getWhen());
        MyViewHolder.lat.setText("" + itemList.get(position).getLat());
        MyViewHolder.lng.setText("" + itemList.get(position).getLng());
        //Log.i(TAG, position + " :onBindViewHolder: " + itemList.get(position).getLat());
        MyViewHolder.clicking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOptionClickListener(holder.itemView);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag(position);
                listener.onItemClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (itemList != null) ? itemList.size() : 0;
    }
}
