package com.denisandsoft.policeseniority;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TimeUnitHolder> {

    private ArrayList<TimeUnit> timeUnits;

    public RecyclerViewAdapter(ArrayList<TimeUnit> timeUnits) {
        this.timeUnits = timeUnits;
    }

    @NonNull
    @Override
    public TimeUnitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_unit_item,parent,false);
        return new TimeUnitHolder(view,view.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull TimeUnitHolder holder, int position) {
        //TO DO
    }

    @Override
    public int getItemCount() {
        return timeUnits.size();
    }

    public static class TimeUnitHolder extends RecyclerView.ViewHolder {

        public TimeUnitHolder(@NonNull View itemView, final Context context) {
            super(itemView);
        }
    }




}
