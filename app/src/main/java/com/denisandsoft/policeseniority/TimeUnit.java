package com.denisandsoft.policeseniority;

import java.util.Date;

public class TimeUnit {
    private String typeOfJob;
    private String placeOfJob;
    private Date startDate;
    private Date endDate;
    private float coefficient;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public TimeUnit(String typeOfJob, String placeOfJob, Date startDate, Date endDate, float coefficient) {
        this.typeOfJob = typeOfJob;
        this.placeOfJob = placeOfJob;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coefficient = coefficient;
    }
}
