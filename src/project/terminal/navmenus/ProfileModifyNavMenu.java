package project.terminal.navmenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.SelectionMenu;
import project.terminal.StringEntryMenu;
import project.terminal.databasemenus.ProfileEditMenu;
import project.terminal.databasemenus.ProfileEntryMenu;
import project.terminal.databasemenus.ProfileRemovalMenu;
import project.terminal.databasemenus.identrymenus.IDEntryToEdit;

/**
 * Created by Anders on 11/22/2016.
 * Selection menu to add, create, or edit
 * a profile in the database
 */
public class ProfileModifyNavMenu extends SelectionMenu {

    private static final int MEMBER_FLAG = 0;
    private static final int PROVIDER_FLAG = 1;
    private final int profileEntryFlag;
    private String titleID;

    public ProfileModifyNavMenu(String name, String title, String body, int PROFILE_ENTRY_FLAG, ProfilesDatabase profile) {
        super(name, title, body);

        this.profileEntryFlag = PROFILE_ENTRY_FLAG;

        if(profileEntryFlag == MEMBER_FLAG)
            titleID = "Member ";
        else if(profileEntryFlag == PROVIDER_FLAG)
            titleID = "Provider ";

        addMenu(new ProfileEntryMenu(titleID + "Entry Menu", profile, profileEntryFlag));
        addMenu(new IDEntryToEdit(titleID + "Edit Menu", "Profile Edit Menu", "Enter ID to modify", profile, profileEntryFlag));
        addMenu(new ProfileRemovalMenu(profile, profileEntryFlag, "Profile Removal Menu"));
    }


}
