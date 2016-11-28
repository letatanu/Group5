package project.terminal.timemenus;

import project.terminal.IntEntryMenu;

/**
 * Created by ashton on 22/11/16.
 */
public class SecondEntryMenu extends IntEntryMenu {

    public SecondEntryMenu() {
        super("", "", "", "Enter seconds of the current time (0-59)", 0, 59);
    }

    @Override
    public void printMenu() {}
}