package com.denisandsoft.policeseniority;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimePeriodEditActivity extends AppCompatActivity {
    EditText etTypeOfJob;
    EditText etPlaceOfJob;
    TextView tvStartDatePicker;
    TextView tvEndDatePicker;
    TextView etCoefficient;
    Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_period_edit);
        initialize();
    }

    private void initialize() {
        etTypeOfJob = findViewById(R.id.etTypeOfJob);
        etPlaceOfJob = findViewById(R.id.etPlaceOfJob);
        tvStartDatePicker = findViewById(R.id.tvStartDatePicker);
        tvEndDatePicker = findViewById(R.id.tvEndDatePicker);
        etCoefficient = findViewById(R.id.etCoefficient);
        buttonAdd = findViewById(R.id.buttonAdd);
    }

    public void addTimePeriod(View view) {
        String typeOfJob = etTypeOfJob.getText().toString();
        String placeOfJob = etPlaceOfJob.getText().toString();
        String startDate = tvStartDatePicker.getText().toString();
        String endDate = tvEndDatePicker.getText().toString();
        double coefficient = Double.valueOf(etCoefficient.getText().toString());
        //TO DO:
        // Date startDate = Helper.stringToDate(tvStartDatePicker.getText().toString());
        // Date endDate = Helper.stringToDate(tvEndDatePicker.getText().toString());
        //TimePeriod timePeriod = new TimePeriod(typeOfJob,placeOfJob,startDate,endDate,coefficient);
        Intent intent = new Intent();
        intent.putExtra(Helper.TYPE_OF_JOB, typeOfJob);
        intent.putExtra(Helper.PLACE_OF_JOB, placeOfJob);
        intent.putExtra(Helper.START_DATE, startDate);
        intent.putExtra(Helper.END_DATE, endDate);
        intent.putExtra(Helper.COEFFICIENT, coefficient);
        setResult(RESULT_OK, intent);
        finish();
    }
}
