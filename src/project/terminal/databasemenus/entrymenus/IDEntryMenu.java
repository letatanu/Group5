package project.terminal.databasemenus.entrymenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.SingleLineEntryMenu;
import project.terminal.StringEntryMenu;

/**
 * Created by Anders on 11/16/2016.
 * I recreated this to help teach myself the existing software system.
 * This menu is to be used by operators when logging into the ChocAn DPS.
 */

class IDEntryMenu extends StringEntryMenu {
    protected ProfilesDatabase profile;

    IDEntryMenu(String name, String body, String entry_prompt, ProfilesDatabase profile) {
        super(name, body, entry_prompt, 9, 9);
    }

    @Override
    protected int generateEntryResponseCode() {

        int responsecode = 0;
        if(entry!=null && !profile.isProfile(entry))
                responsecode = -1;

        return responsecode;
    }
}
