package com.android.musta.retroexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.musta.retroexample.R;
import com.android.musta.retroexample.interfaces.OnItemClickListener;
import com.android.musta.retroexample.models.DatumModel;

import java.util.List;

/**
 * Created by musta on 11/24/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> implements OnItemClickListener {

    private List<DatumModel> itemList;
    private OnItemClickListener optionClickListener;
    private Context mContext;

    public RecyclerAdapter(List<DatumModel> itemList, Context context, OnItemClickListener listener) {
        this.itemList = itemList;
        this.mContext = context;
        this.optionClickListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item, parent, false);
        return new MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        MyViewHolder.time.setText("" + itemList.get(position).getWhen());
        MyViewHolder.lat.setText("" + itemList.get(position).getLat());
        MyViewHolder.lng.setText("" + itemList.get(position).getLng());
        MyViewHolder.clicking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionClickListener.onOptionClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(mContext, "" + itemList.get(position).getLat().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOptionClickListener(int position) {

    }
}
