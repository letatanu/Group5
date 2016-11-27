package project.terminal.addressmenus;

import project.terminal.StringEntryMenu;

/**
 * Created by ashton on 15/11/16.
 */

public class StreetAddressEntryMenu extends StringEntryMenu {

    public StreetAddressEntryMenu() {
        super("", "", "Enter Street Address", 1, 25);
    }

    public StreetAddressEntryMenu(String name) {
        super(name, "", "Enter Street Address", 1, 25);
    }

    @Override
    public void printMenu() {}
}
