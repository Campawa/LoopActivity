package com.example.chelsi.loopactivity;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Chelsi on 12/6/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private List<Items> List;

    public MyAdapter(List<Items> List) {
        this.List = List;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
        return new MyViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Items items = List.get(position);
        holder.onBind(items);
    }

    @Override
    public int getItemCount() {
        return List.size();
    }
}