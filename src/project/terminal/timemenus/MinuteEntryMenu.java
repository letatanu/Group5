package project.terminal.timemenus;

import project.terminal.IntEntryMenu;

/**
 * Created by ashton on 22/11/16.
 */
public class MinuteEntryMenu extends IntEntryMenu {

    public MinuteEntryMenu() {
        super("", "", "", "Enter minutes of the current time (0-59)", 0, 59);
    }

    @Override
    public void printMenu() {}
}
