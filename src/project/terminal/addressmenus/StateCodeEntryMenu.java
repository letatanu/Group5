package project.terminal.addressmenus;

import project.terminal.StringEntryMenu;

/**
 * Created by ashton on 15/11/16.
 */
public class StateCodeEntryMenu extends StringEntryMenu {

    public StateCodeEntryMenu() {
        super("", "", "Enter State Code", 2, 2);
    }

    public StateCodeEntryMenu(String name) {
        super(name, "", "Enter State Code", 2, 2);
    }

    @Override
    public void printMenu() {}
}
