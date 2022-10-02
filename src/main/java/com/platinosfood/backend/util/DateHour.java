package com.platinosfood.backend.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHour {

    Date date = Calendar.getInstance().getTime();

    public String date() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/YYYY");
        String dateString = sdf.format(date);
        return dateString;
    }

    public String hour() {
        SimpleDateFormat sdfHour = new SimpleDateFormat("hh:mm:ss aa");
        String hourString = sdfHour.format(date);
        return hourString;
    }
}
