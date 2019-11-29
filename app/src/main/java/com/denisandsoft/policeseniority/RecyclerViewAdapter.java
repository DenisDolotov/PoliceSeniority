package com.denisandsoft.policeseniority;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_unit_item, parent, false);
        return new TimeUnitHolder(view, view.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull TimeUnitHolder timeUnitHolder, int position) {
        timeUnitHolder.currentCardPosition = position;
        CardView cardView = timeUnitHolder.cardView;
        TimeUnit timeUnit = timeUnits.get(position);
        TextView tvTypeOfJob = cardView.findViewById(R.id.tvTypeOfJob);
        tvTypeOfJob.setText(timeUnit.getTypeOfJob());
        TextView tvPlaceOfJob = cardView.findViewById(R.id.tvPlaceOfJob);
        tvPlaceOfJob.setText(timeUnit.getPlaceOfJob());
        TextView tvStartDate = cardView.findViewById(R.id.tvStartDate);
        tvStartDate.setText(timeUnit.getStartDate());
        TextView tvEndDate = cardView.findViewById(R.id.tvEndDate);
        tvEndDate.setText(timeUnit.getEndDate());
        TextView tvCoefficient = cardView.findViewById(R.id.tvCoefficient);
        tvCoefficient.setText(timeUnit.getCoefficient());
    }

    @Override
    public int getItemCount() {
        return timeUnits.size();
    }

    public static class TimeUnitHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        int currentCardPosition;
        Context mContext;
        TextView tvTypeOfJob;
        TextView tvPlaceOfJob;
        TextView tvStartDate;
        TextView tvEndDate;
        TextView tvCoefficient;


        public TimeUnitHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            mContext = context;
            cardView = itemView.findViewById(R.id.cardView);
            tvTypeOfJob = itemView.findViewById(R.id.tvTypeOfJob);
            tvPlaceOfJob = itemView.findViewById(R.id.tvPlaceOfJob);
            tvStartDate = itemView.findViewById(R.id.tvStartDate);
            tvEndDate = itemView.findViewById(R.id.tvEndDate);
            tvCoefficient = itemView.findViewById(R.id.tvCoefficient);
            //TO DO: cardView.setOnClickListener()
        }
    }


}
