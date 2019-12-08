package com.denisandsoft.policeseniority;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePeriod {
    private String typeOfJob;
    private String placeOfJob;
    private Date startDate;
    private Date endDate;
    private double coefficient;


    public String getTypeOfJob() {
        return typeOfJob;
    }

    public void setTypeOfJob(String typeOfJob) {
        this.typeOfJob = typeOfJob;
    }

    public String getPlaceOfJob() {
        return placeOfJob;
    }

    public void setPlaceOfJob(String placeOfJob) {
        this.placeOfJob = placeOfJob;
    }

    public String getStartDate() {
        return stringFromData(startDate);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return stringFromData(endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCoefficient() {
        return String.valueOf(coefficient);
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public TimePeriod(String typeOfJob, String placeOfJob, Date startDate, Date endDate, double coefficient) {
        this.typeOfJob = typeOfJob;
        this.placeOfJob = placeOfJob;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coefficient = coefficient;
    }

    private String stringFromData(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Helper.FORMAT_DATE);
        return simpleDateFormat.format(date);
    }
}
