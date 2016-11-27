package project.terminal.datemenus;

import project.terminal.IntEntryMenu;

/**
 * Created by Ashton on 11/21/2016.
 */
public class YearEntryMenu extends IntEntryMenu {

    public YearEntryMenu() { super("Year Entry", "", "", "Enter the year", 1900, 2100); }

    @Override
    protected void printMenu() {}
}
