package project.terminal.databasemenus;

import project.database.profiles.ProfilesDatabase;

/**
 * Created by ahunger on 11/20/2016.
 */
public class ProfileRemovalMenu extends ProfileIDEntryMenu {

    public ProfileRemovalMenu(ProfilesDatabase profilesDatabase, String name, String body, String entry_prompt) {
        super(profilesDatabase, name, body, entry_prompt);
    }

    public ProfileRemovalMenu(ProfilesDatabase profilesDatabase, int FILTER_FLAG, String name, String body, String entry_prompt) {
        super(profilesDatabase, FILTER_FLAG, name, body, entry_prompt);
    }

    public ProfileRemovalMenu(ProfilesDatabase profilesDatabase, String name) {
        super(profilesDatabase, name, "Type the ID of the profile to be removed or \"Back\" to return to the previous menu", "Enter ID: ");
    }

    public ProfileRemovalMenu(ProfilesDatabase profilesDatabase, int FILTER_FLAG, String name) {
        super(profilesDatabase, FILTER_FLAG, name, "Type the ID of the profile to be removed or \"Back\" to return to the previous menu", "Enter ID: ");
    }

    @Override
    public void processValidEntry() { profilesDatabase.removeProfile(entry); }
}
