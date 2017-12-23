package com.pg22195.calender.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by prateek on 23/12/17.
 */

public class DateTimeParser {

    private static SimpleDateFormat dateMonth = new SimpleDateFormat("dd'\n'MMM", Locale.ENGLISH);

    public static String calenderFormat(Date date) {
        return dateMonth.format(date);
    }
}
