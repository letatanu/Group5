package project.terminal.databasemenus.entrymenus;

import project.terminal.SingleLineEntryMenu;
import project.terminal.StringEntryMenu;

/**
 * Created by Anders on 11/16/2016.
 * I recreated this to help teach myself the existing software system.
 * This menu is to be used by operators when logging into the ChocAn DPS.
 */

public class IDEntryMenu extends StringEntryMenu {

    public IDEntryMenu(String body, String entry_prompt) {
        super("ID Entry Menu", body, entry_prompt, 9, 9);
    }
}
