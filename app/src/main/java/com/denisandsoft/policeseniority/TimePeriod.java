package com.denisandsoft.policeseniority;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
        return Helper.stringFromDate(startDate);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return Helper.stringFromDate(endDate);
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

    public int getSeniority(){
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return (int)Math.floor(diff*coefficient);
    }

    public TimePeriod(String typeOfJob, String placeOfJob, Date startDate, Date endDate, double coefficient) {
        this.typeOfJob = typeOfJob;
        this.placeOfJob = placeOfJob;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coefficient = coefficient;
    }

}
