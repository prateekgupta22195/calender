package com.pg22195.calender.module_cell;

import java.util.Date;

/**
 * Created by prateek on 23/12/17.
 */

public class Cell {
    private Date startTime;
    private Date endTime;
    private String text;

    public Cell(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        // calculate start time and time from date object
        //set startTime
        //set endTime
        //set text
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
