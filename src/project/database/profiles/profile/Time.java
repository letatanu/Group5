package project.database.profiles.profile;

import project.database.profiles.profile.editable.EditableTime;
import project.database.profiles.profile.editable.EditableType;

/**
 * Created by Ashton on 11/21/2016.
 */
public final class Time implements ImmutableType {
    private final int hours;
    private final int minutes;
    private final int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() { return hours; }

    public int getMinutes() { return minutes; }

    public int getSeconds() { return seconds; }

    @Override
    public EditableTime getEditableType() { return new EditableTime(this); }
}
