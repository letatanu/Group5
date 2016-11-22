package project.terminal.datemenus;

import project.terminal.IntEntryMenu;

/**
 * Created by Ashton on 11/21/2016.
 */
public class DayEntryMenu extends IntEntryMenu {

    public DayEntryMenu() { super("Day Entry", "", "", "Enter the day", 1, 31); }

    @Override
    protected void printMenu() {}
}
