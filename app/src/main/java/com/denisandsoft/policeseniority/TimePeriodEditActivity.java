package com.denisandsoft.policeseniority;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TimePeriodEditActivity extends AppCompatActivity {
    EditText etTypeOfJob;
    EditText etPlaceOfJob;
    TextView tvStartDate;
    TextView tvEndDate;
    TextView etCoefficient;
    Button buttonAdd;
    Calendar startDate = Calendar.getInstance();
    Calendar endDate = Calendar.getInstance();
    boolean hasEndDateChanged;
    int currentTimePeriodPosition;

    DatePickerDialog.OnDateSetListener startDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            startDate.set(Calendar.YEAR, year);
            startDate.set(Calendar.MONTH, monthOfYear);
            startDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setStartDate();
        }
    };
    DatePickerDialog.OnDateSetListener endDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            endDate.set(Calendar.YEAR, year);
            endDate.set(Calendar.MONTH, monthOfYear);
            endDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setEndDate();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_period_edit);
        initialize();
        Intent intent = getIntent();
        int editCode = intent.getIntExtra(Helper.EDIT_CODE,0);
        if (editCode == Helper.REQUEST_CODE_TIME_UNIT_EDIT){
            etTypeOfJob.setText(intent.getStringExtra(Helper.TYPE_OF_JOB));
            etPlaceOfJob.setText(intent.getStringExtra(Helper.PLACE_OF_JOB));
            tvStartDate.setText(intent.getStringExtra(Helper.START_DATE));
            tvEndDate.setText(intent.getStringExtra(Helper.END_DATE));
            etCoefficient.setText(intent.getStringExtra(Helper.COEFFICIENT));
            currentTimePeriodPosition = intent.getIntExtra(Helper.TIME_PERIOD_POSITION,0);
            buttonAdd.setText("Сохранить");
        }
    }

    private void initialize() {
        etTypeOfJob = findViewById(R.id.etTypeOfJob);
        etPlaceOfJob = findViewById(R.id.etPlaceOfJob);
        tvStartDate = findViewById(R.id.tvStartDate);
        tvEndDate = findViewById(R.id.tvEndDatePicker);
        etCoefficient = findViewById(R.id.etCoefficient);
        buttonAdd = findViewById(R.id.buttonAdd);
        hasEndDateChanged = false;
    }

    public void addTimePeriod(View view) {
        String typeOfJob = etTypeOfJob.getText().toString();
        String placeOfJob = etPlaceOfJob.getText().toString();
        String startDate = tvStartDate.getText().toString();
        String endDate = tvEndDate.getText().toString();
        String coefficient = etCoefficient.getText().toString();
        //double coefficient = Double.valueOf(etCoefficient.getText().toString());
        //TO DO:
        // Date startDate = Helper.stringToDate(tvStartDate.getText().toString());
        // Date endDate = Helper.stringToDate(tvEndDate.getText().toString());
        //TimePeriod timePeriod = new TimePeriod(typeOfJob,placeOfJob,startDate,endDate,coefficient);
        Intent intent = new Intent();
        intent.putExtra(Helper.TYPE_OF_JOB, typeOfJob);
        intent.putExtra(Helper.PLACE_OF_JOB, placeOfJob);
        intent.putExtra(Helper.START_DATE, startDate);
        intent.putExtra(Helper.END_DATE, endDate);
        intent.putExtra(Helper.COEFFICIENT, coefficient);
        intent.putExtra(Helper.TIME_PERIOD_POSITION, currentTimePeriodPosition);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void pickStartDate(View view) {
        new DatePickerDialog(TimePeriodEditActivity.this, startDateSetListener,
                startDate.get(Calendar.YEAR),
                startDate.get(Calendar.MONTH),
                startDate.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void setStartDate() {
        String s = Helper.stringFromDate(startDate.getTime());
        tvStartDate.setText(s);

    }

    public void pickEndDate(View view) {
        new DatePickerDialog(TimePeriodEditActivity.this, endDateSetListener,
                endDate.get(Calendar.YEAR),
                endDate.get(Calendar.MONTH),
                endDate.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void setEndDate() {
        String s = Helper.stringFromDate(endDate.getTime());
        tvEndDate.setText(s);
    }
}
