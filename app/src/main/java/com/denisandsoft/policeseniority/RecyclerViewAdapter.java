package com.denisandsoft.policeseniority;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TimeUnitHolder> {

    private ArrayList<TimePeriod> timePeriods;

    public RecyclerViewAdapter(ArrayList<TimePeriod> timePeriods) {
        this.timePeriods = timePeriods;
    }

    @NonNull
    @Override
    public TimeUnitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_period_item, parent, false);
        return new TimeUnitHolder(view, view.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull TimeUnitHolder timeUnitHolder, int position) {
        timeUnitHolder.currentCardPosition = position;
        CardView cardView = timeUnitHolder.cardView;
        TimePeriod timePeriod = timePeriods.get(position);
        TextView tvTypeOfJob = cardView.findViewById(R.id.tvTypeOfJob);
        tvTypeOfJob.setText(timePeriod.getTypeOfJob());
        TextView tvPlaceOfJob = cardView.findViewById(R.id.tvPlaceOfJob);
        tvPlaceOfJob.setText(timePeriod.getPlaceOfJob());
        TextView tvStartDate = cardView.findViewById(R.id.tvStartDate);
        tvStartDate.setText(timePeriod.getStartDate());
        TextView tvEndDate = cardView.findViewById(R.id.tvEndDate);
        tvEndDate.setText(timePeriod.getEndDate());
        TextView tvCoefficient = cardView.findViewById(R.id.tvCoefficient);
        tvCoefficient.setText(timePeriod.getCoefficient());
    }

    @Override
    public int getItemCount() {
        if (timePeriods == null) return 0;
        return timePeriods.size();
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
