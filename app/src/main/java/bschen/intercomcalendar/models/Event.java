package bschen.intercomcalendar.models;

import java.util.Calendar;
import java.util.Date;

public class Event {

    private String occasion;
    private int invited_count;
    private int year;
    private int month;
    private int day;

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(final String occasion) {
        this.occasion = occasion;
    }

    public int getInvitedCount() {
        return invited_count;
    }

    public void setInvitedCount(final int invited_count) {
        this.invited_count = invited_count;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(final int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(final int day) {
        this.day = day;
    }

    public Date getDate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
