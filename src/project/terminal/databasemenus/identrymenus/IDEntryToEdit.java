package project.terminal.databasemenus.identrymenus;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.terminal.SelectionMenu;
import project.terminal.StringEntryMenu;
import project.terminal.TerminalMenu;
import project.terminal.databasemenus.ProfileEditMenu;
import project.terminal.databasemenus.ProfileIDEntryMenu;

/**
 * Created by Anders on 11/22/2016.
 * Prompts the user to enter an ID, then enters the edit menu specific
 * to that ID
 * Accessed from any menu that edits an kind of database object.
 */
public class IDEntryToEdit extends ProfileIDEntryMenu {

    //private static final int MEMBER_FLAG = 0;
    //private static final int PROVIDER_FLAG = 1;
    //private static final int MANAGER_FLAG = 2;

    private final ProfilesDatabase profilesDatabase;

    public IDEntryToEdit(String name, String body, String entry_prompt, ProfilesDatabase profilesDatabase, int FLAG) {
        super(profilesDatabase, FLAG, name, body, entry_prompt);
        this.profilesDatabase = profilesDatabase;
    }

    @Override
    protected void processValidEntry() {
        ProfileEditMenu profileEditMenu = new ProfileEditMenu(profilesDatabase, entry);
        profileEditMenu.runMenu();

        //sends back ID of flag type
    }
}
