package project.terminal.addressmenus;

import project.terminal.StringEntryMenu;

/**
 * Created by ashton on 15/11/16.
 */
public class CityEntryMenu extends StringEntryMenu {

    public CityEntryMenu() {
        super("", "", "Enter City", 1, 14);
    }

    public CityEntryMenu(String name) {
        super(name, "", "Enter City", 1, 14);
    }

    @Override
    public void printMenu() {}
}
