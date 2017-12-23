package com.pg22195.calender.module_cell;

import com.pg22195.calender.module_cell.Cell;

import java.util.Date;

/**
 * Created by prateek on 23/12/17.
 */

public class CustomCell extends Cell {
    private String text;

    CustomCell(Date startTime, Date endTime) {
        super(startTime, endTime);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
