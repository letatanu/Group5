package project.terminal.timemenus;

import project.terminal.IntEntryMenu;

/**
 * Created by ashton on 22/11/16.
 */
public class HourEntryMenu extends IntEntryMenu {

    public HourEntryMenu() {
        super("", "", "", "Enter minutes of the current time (0-23)", 0, 23);
    }

    @Override
    public void printMenu() {}
}