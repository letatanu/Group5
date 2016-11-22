package project.terminal.navmenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.SelectionMenu;
import project.terminal.StringEntryMenu;
import project.terminal.databasemenus.ProfileEditMenu;
import project.terminal.databasemenus.ProfileEntryMenu;
import project.terminal.databasemenus.ProfileRemovalMenu;

/**
 * Created by Anders on 11/22/2016.
 * Selection menu to add, create, or edit
 * a profile in the database
 */
public class ProfileModifyNavMenu extends SelectionMenu {

    private static final int MEMBER_FLAG = 1;
    private static final int PROVIDER_FLAG = 2;
    private final int profileEntryFlag;
    private String titleID;

    public ProfileModifyNavMenu(String name, String title, String body, int PROFILE_ENTRY_FLAG, ProfilesDatabase profile) {
        super(name, title, body);

        this.profileEntryFlag = PROFILE_ENTRY_FLAG;

        if(profileEntryFlag == 1)
            titleID = "Member ";
        else if(profileEntryFlag == 2)
            titleID = "Provider ";

        addMenu(new ProfileEntryMenu(titleID + "Entry Menu", profile, profileEntryFlag));
        addMenu(new StringEntryMenu(titleID + "Edit Menu", "", "Enter " + titleID + "ID"));
        addMenu(new StringEntryMenu(titleID + "Removal Menu", "", "Enter " + titleID + "ID"));
    }


}
