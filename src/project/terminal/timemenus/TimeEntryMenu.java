package project.terminal.timemenus;

import project.database.profiles.profile.Time;
import project.database.profiles.profile.editable.EditableTime;
import project.terminal.IntEntryMenu;
import project.terminal.MultiLineEntryMenu;

/**
 * Created by Ashton on 22/11/2016.
 */
public class TimeEntryMenu extends MultiLineEntryMenu<Time> {

    private EditableTime editableTime;

    //Constructors
    public TimeEntryMenu(String name) {
        super(name);
    }

    public TimeEntryMenu() {
        super("Date Entry");
    }

    /** Setup for the menus used for Date entry */
    @Override
    protected void setupMenus() {
        addMenu(new HourEntryMenu());

        addMenu(new MinuteEntryMenu());

        addMenu(new SecondEntryMenu());
    }

    /** Initializes the Time */
    @Override
    protected void initEntry() {
        editableTime = new EditableTime();
    }

    /** Finalizes the Time */
    @Override
    protected void finalizeEntry() { entry = editableTime.getImmutableType(); }

    /** Resolves the Hours, Minutes, and Seconds singleLineEntry menus */
    @Override
    protected void resolveMenu(int menu_index) {
        switch (menu_index) {
            case 0:
                editableTime.setHours(((IntEntryMenu) getMenu(menu_index)).getEntry());
                break;
            case 1:
                editableTime.setMinutes(((IntEntryMenu) getMenu(menu_index)).getEntry());
                break;
            case 2:
                editableTime.setSeconds(((IntEntryMenu) getMenu(menu_index)).getEntry());
                break;
            default:
                System.out.println("Invalid Menu Index!");
        }
    }
}
