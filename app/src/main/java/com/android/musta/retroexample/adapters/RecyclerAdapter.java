package com.android.musta.retroexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.musta.retroexample.R;
import com.android.musta.retroexample.models.DatumModel;

import java.util.List;

/**
 * Created by musta on 11/24/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<DatumModel> itemList;

    public RecyclerAdapter(List<DatumModel> itemList) {
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyViewHolder.time.setText("" + itemList.get(position).getWhen());
        MyViewHolder.lat.setText("" + itemList.get(position).getLat());
        MyViewHolder.lng.setText("" + itemList.get(position).getLng());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
