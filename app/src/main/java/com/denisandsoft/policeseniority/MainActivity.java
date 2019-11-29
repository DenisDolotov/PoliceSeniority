package com.denisandsoft.policeseniority;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    final static String FORMAT_DATE = "dd.MM.yyyy";
    private ArrayList<TimeUnit> timeUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(timeUnits);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void initializeData() {
        timeUnits = new ArrayList<>();
        TimeUnit timeUnit1 = new TimeUnit("Учеба в ВУЗе", "Хабаровск", stringToDate("01.09.2001"),stringToDate("15.07.2006"),0.5);
        timeUnits.add(timeUnit1);
        TimeUnit timeUnit2 = new TimeUnit("Служба", "Хабаровск", stringToDate("01.08.2006"),stringToDate("01.10.2018"),1.5);
        timeUnits.add(timeUnit2);
    }


    private Date stringToDate(String date) {
        String format = FORMAT_DATE;
        if (date == null) return null;
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat(format);
        Date stringDate = simpledateformat.parse(date, pos);
        return stringDate;
    }

}
