package project.terminal.datemenus;

import project.terminal.IntEntryMenu;

/**
 * Created by Ashton on 11/21/2016.
 */
public class MonthEntryMenu extends IntEntryMenu {
    public MonthEntryMenu() { super("Month Entry", "", "", "Enter the month", 1, 12); }

    @Override
    protected void printMenu() {}
}
