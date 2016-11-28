package project.terminal.databasemenus.identrymenus;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Profile;
import project.terminal.databasemenus.ProfileIDEntryMenu;
import project.terminal.navmenus.ManagerNavMenu;
import project.terminal.navmenus.ProviderNavMenu;

/**
 * Created by Anders on 11/24/2016.
 * Handles the log in of providers or managers (operators)
 * to the ChocAn DPS
 * Shall be the first menu a user encounters when
 * starting up the system.
 */
public class OperatorLogInEntry extends ProfileIDEntryMenu {

    private final ProfilesDatabase profilesDatabase;

    public OperatorLogInEntry(ProfilesDatabase profilesDatabase) {
        super(profilesDatabase, "Operator Log-in Menu", "Welcome to the ChocAn DPS system", "Enter Operator ID for Log-in");

        this.profilesDatabase = profilesDatabase;
    }

    @Override
    protected void processValidEntry() {
        if(profilesDatabase.isProvider(entry)) {
            /*start a provider nav menu if a provider logs in, sending the entry as
            that provider's ID*/
            ProviderNavMenu providerNavMenu = new ProviderNavMenu(profilesDatabase, entry);
            providerNavMenu.runMenu();
        }
        if(profilesDatabase.isManager(entry)) {
            //if a manager logs in, send the manager to their navigaiton menu
            ManagerNavMenu managerNavMenu = new ManagerNavMenu(profilesDatabase);
            managerNavMenu.runMenu();
        }
    }
}
