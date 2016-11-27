package project.terminal.addressmenus;

import project.terminal.StringEntryMenu;

/**
 * Created by ashton on 15/11/16.
 */
public class ZipCodeEntryMenu extends StringEntryMenu {

    public ZipCodeEntryMenu() {
        super("", "", "Enter Zip Code", 5, 5);
    }

    public ZipCodeEntryMenu(String name) {
        super(name, "", "Enter Zip Code", 5, 5);
    }

    @Override
    public void printMenu() {}
}
