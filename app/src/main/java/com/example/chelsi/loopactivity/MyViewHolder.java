package com.example.chelsi.loopactivity;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Chelsi on 12/6/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView stuff;


    public MyViewHolder(View itemView) {
        super(itemView);
        stuff = (TextView) itemView.findViewById(R.id.object);
    }

    public void onBind(Items items) {
        stuff.setText("Object " + items.getStuff());

    }

}