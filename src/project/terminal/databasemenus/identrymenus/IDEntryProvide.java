package project.terminal.databasemenus.identrymenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.databasemenus.ProfileIDEntryMenu;
import project.terminal.navmenus.ProvideToMemberMenu;

/**
 * Created by Anders on 11/24/2016.
 * Prompts the user for a member ID, then runs the
 * ProvideToMemberMenu, using that member's ID as
 * the member to provide to.
 * Accessed from the ProviderNavMenu
 */
public class IDEntryProvide extends ProfileIDEntryMenu {

    private final ProfilesDatabase profilesDatabase;

    public IDEntryProvide(ProfilesDatabase profilesDatabase, String name) {
        super(profilesDatabase, name, "Provide to Member", "Enter Member ID to Provide to");
        this.profilesDatabase = profilesDatabase;
    }

    @Override
    protected void processValidEntry() {
        ProvideToMemberMenu provideToMemberMenu = new ProvideToMemberMenu(profilesDatabase, entry);
        provideToMemberMenu.runMenu();
    }
}
