package com.denisandsoft.policeseniority;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    final static String TYPE_OF_JOB = "typeOfJob";
    final static String PLACE_OF_JOB = "placeOfJob";
    final static String START_DATE = "startDate";
    final static String END_DATE = "endDate";
    final static String COEFFICIENT = "coefficient";


    final static String FORMAT_DATE = "dd.MM.yyyy";

    protected static Date stringToDate(String date) {
        String format = FORMAT_DATE;
        if (date == null) return null;
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat(format);
        Date stringDate = simpledateformat.parse(date, pos);
        return stringDate;
    }
}
