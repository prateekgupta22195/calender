package com.pg22195.calender.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pg22195.calender.interfaces.ExtremePositionListener;
import com.pg22195.calender.module_cell.Cell;
import com.pg22195.calender.R;

import java.util.List;

/**
 * Created by prateek on 23/12/17.
 */

public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.MyViewHolder> {
    private ExtremePositionListener extremePositionListener;
    private List<Cell> cellsList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public MyViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.text);
//            genre = (TextView) view.findViewById(R.id.genre);
//            year = (TextView) view.findViewById(R.id.year);
        }
    }
    public CalenderAdapter(List<Cell> cellsList) {
        this.cellsList = cellsList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_cell, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Cell cell = cellsList.get(position);
        holder.text.setText(cell.getText());
        if(position == 0) {
//            extremePositionListener.onReachingTop();
        } else if(position == cellsList.size()-1) {
            extremePositionListener.onReachingBottom(position);
        }
    }
    @Override
    public int getItemCount() {
        return cellsList.size();
    }

    public void setAdapterListener(ExtremePositionListener xpListener) {
        this.extremePositionListener = xpListener;
    }
}
