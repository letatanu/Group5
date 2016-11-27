package project.database.profiles.profile;

import project.database.profiles.profile.editable.EditableDate;

/**
 * Created by Ashton on 10/23/2016.
 */
public final class Date implements ImmutableType {
    private final int month;
    private final int day;
    private final int year;

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

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return month+"/"+day+"/"+year;
    }

    public EditableDate getEditableType() { return new EditableDate(this); }
}
