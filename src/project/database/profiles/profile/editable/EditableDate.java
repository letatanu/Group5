package project.database.profiles.profile.editable;

import project.database.profiles.profile.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Ashton on 10/28/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EditableDate {
    @XmlAttribute(name="month")
    private int month;
    @XmlAttribute(name="day")
    private int day;
    @XmlAttribute(name="year")
    private int year;

    public EditableDate() {
        month = 0;
        day = 0;
        year = 0;
    }

    public EditableDate(Date date) {
        month = date.getMonth();
        day = date.getDay();
        year = date.getYear();
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date exportDate() { return new Date(month, day, year); }
}
