package project.terminal.databasemenus.entrymenus;

import project.terminal.StringEntryMenu;

/**
 * Created by ashton on 10/11/16.
 */
public class ProfileNameEntryMenu extends StringEntryMenu {

    public ProfileNameEntryMenu() {
        super("Profile Name Entry", "Profile names can only be alphabetical and between 1-25 characters", "Full Name", ALPHABET_ONLY_REGEX, 1, 25);
    }

    public void printMenu() {}
}
