package project.terminal.databasemenus.entrymenus;

import project.database.profiles.ProfilesDatabase;
/**
 * Created by Alex on 11/19/2016.
 * This class is equivalent to Operator ID Entry Menu.
 * But it checks if the user ID is Manager ID only.
 * This class is necessary for creating a profiles since only manager can do this.
 * Didn't extended Operator ID Entry Menu since it should involve modifying
 * the arguments for base class constructor.
 */
public class ManagerIDEntryMenu extends IDEntryMenu {

    public ManagerIDEntryMenu(ProfilesDatabase profile) {
        super("Manager ID Entry Menu", "Manager ID Entry Menu", "Enter Manager ID: ", profile);
        this.profile = profile;
    }

    @Override
    protected int generateEntryResponseCode() {

        int response = 0;

        if(entry == null)
            response = -1;
        else if(!profile.isManager(entry))
            response = -1;

        return response;
    }
}
