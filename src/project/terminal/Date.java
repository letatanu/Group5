package project.terminal;

/**
 * Created by Ashton on 10/23/2016.
 */
public class Date {

    private int month;
    private int day;
    private int year;

    public Date() {
        month = 0;
        day = 0;
        year = 0;
    }

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return month+"/"+day+"/"+year;
    }
}
