package com.denisandsoft.policeseniority;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_TIME_UNIT_CREATE = 1001;
    private ArrayList<TimePeriod> timePeriods;
    private RecyclerView recyclerView;
    private TextView tvResultSeniority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializeData();
        timePeriods = new ArrayList<>();

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        tvResultSeniority = findViewById(R.id.tvResultSeniority);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(timePeriods);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

//    private void initializeData() {
//        timePeriods = new ArrayList<>();
//        TimePeriod timePeriod1 = new TimePeriod("Учеба в ВУЗе", "Хабаровск", Helper.stringToDate("01.09.2001"), Helper.stringToDate("15.07.2006"), 0.5);
//        timePeriods.add(timePeriod1);
//        TimePeriod timePeriod2 = new TimePeriod("Служба", "Хабаровск", Helper.stringToDate("01.08.2006"), Helper.stringToDate("01.10.2018"), 1.5);
//        timePeriods.add(timePeriod2);
//    }


    public void addNewTimeUnit(View view) {
        Intent intent = new Intent(this, TimePeriodEditActivity.class);
        startActivityForResult(intent, REQUEST_CODE_TIME_UNIT_CREATE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == REQUEST_CODE_TIME_UNIT_CREATE) {

            String typeOfJob = data.getStringExtra(Helper.TYPE_OF_JOB);
            String placeOfJob = data.getStringExtra(Helper.PLACE_OF_JOB);
            Date startDate = Helper.stringToDate(data.getStringExtra(Helper.START_DATE));
            Date endDate = Helper.stringToDate(data.getStringExtra(Helper.END_DATE));
            double coefficient = Double.valueOf(data.getStringExtra(Helper.COEFFICIENT));
            TimePeriod timePeriod = new TimePeriod(typeOfJob, placeOfJob, startDate, endDate, coefficient);
            //TO DO
            //TimePeriod timePeriod = (TimePeriod) data.getSerializableExtra("name");
            timePeriods.add(timePeriod);
            calculateSeniority();
        }


    }

    private void calculateSeniority() {
        int days = 0;
        for (TimePeriod period :
                timePeriods) {
            days += period.getSeniority();
        }
        int years = (days / 365);
        int months = (days % 365) / 30;
        days = (days % 365) % 7;
        tvResultSeniority.setText(String.format("%d Лет, %d Месяцев, %d Дней", years, months, days));
    }
}
