package project.database.profiles.profile.editable;

import project.database.profiles.profile.Time;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by Ashton on 11/21/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EditableTime implements EditableType{
    @XmlAttribute(name = "hours")
    private int hours;
    @XmlAttribute(name = "minutes")
    private int minutes;
    @XmlAttribute(name = "seconds")
    private int seconds;

    public EditableTime() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public EditableTime(Time t) {
        hours = t.getHours();
        minutes = t.getMinutes();
        seconds = t.getSeconds();
    }

    public EditableTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void setHours(int hours) { this.hours = hours; }

    public void setMinutes(int minutes) { this.minutes = minutes; }

    public void setSeconds(int seconds) { this.seconds = seconds; }

    @XmlTransient
    public int getHours() { return hours; }

    public int getMinutes() { return minutes; }

    public int getSeconds() { return seconds; }

    @Override
    public Time getImmutableType() { return new Time(hours, minutes, seconds); }
}
