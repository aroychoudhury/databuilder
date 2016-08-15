package org.abhishek.utilities.databuilder.build.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.abhishek.utilities.databuilder.build.AbstractBuilder;
import org.abhishek.utilities.databuilder.build.ctx.BuildContext;
import org.abhishek.utilities.databuilder.data.DateTimeData;

public class DateTimeBuilder extends AbstractBuilder {
    private String dateFormatString = "MM-dd-yyyy";
    private DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
    private Random random = new Random();

    public Date getDate(final int year, final int month, final int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day, 0, 0, 0);
        return cal.getTime();
    }

    public String getDateAsString(final int year, final int month, final int day) {
        return dateFormat.format(this.getDate(year, month, day));
    }

    public Date getDate() {
        return Calendar.getInstance().getTime();
    }

    public String getDateAsString() {
        return dateFormat.format(this.getDate());
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public Date parseDate(final String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Valid dates should follow the format: " + dateFormatString, e);
        }
    }

    public String getTime12HR() {
        return DateTimeData.TIME_12HR_FORMAT[random.nextInt(DateTimeData.TIME_12HR_FORMAT.length)];
    }

    public String getTime24HR() {
        return DateTimeData.TIME_24HR_FORMAT[random.nextInt(DateTimeData.TIME_24HR_FORMAT.length)];
    }

    @Override
    public void constructContext(BuildContext context) {
        context.put("date", this.getDate());
    }

    public static void main(String[] args) {
        DateTimeBuilder parser = new DateTimeBuilder();
        System.out.println(parser.getTime24HR());
        System.out.println(parser.getTime12HR());
        System.out.println(parser.getCurrentYear());
        System.out.println(parser.getCurrentDay());
        System.out.println(parser.getCurrentMonth());
        System.out.println(parser.parseDate("08-16-2016"));
        System.out.println(parser.random.nextDouble());
    }
}
