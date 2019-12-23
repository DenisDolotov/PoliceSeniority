package com.denisandsoft.policeseniority;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    protected final static String TYPE_OF_JOB = "typeOfJob";
    protected final static String PLACE_OF_JOB = "placeOfJob";
    protected final static String START_DATE = "startDate";
    protected final static String END_DATE = "endDate";
    protected final static String COEFFICIENT = "coefficient";
    protected final static String EDIT_CODE = "edit";
    protected final static String TIME_PERIOD_POSITION = "position";


    protected final static String FORMAT_DATE = "dd.MM.yyyy";

    protected final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);

    protected static final int REQUEST_CODE_TIME_UNIT_CREATE = 1001;
    protected static final int REQUEST_CODE_TIME_UNIT_EDIT = 1002;


    protected static Date stringToDate(String date) {
        if (date == null) return null;
        ParsePosition pos = new ParsePosition(0);
        Date stringDate = simpleDateFormat.parse(date, pos);
        return stringDate;
    }

    static String stringFromDate(Date date){
        return simpleDateFormat.format(date);
    }
}
