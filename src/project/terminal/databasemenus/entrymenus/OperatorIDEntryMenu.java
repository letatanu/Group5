package project.terminal.databasemenus.entrymenus;

import project.database.profiles.ProfilesDatabase;

/**
 * Created by Anders on 11/18/2016.
 * Checks a provider or manager ID with the database, returning
 *
 */
public class OperatorIDEntryMenu extends IDEntryMenu {

    public OperatorIDEntryMenu(ProfilesDatabase profile) {
        super("Operator ID Entry Menu", "Operator ID Entry Menu", "Enter Operator ID: ", profile);
        this.profile = profile;

    }

    @Override
    protected int generateEntryResponseCode() {

        int response = 0;

        if(entry == null)
            response = -1;
        else if(!profile.isManager(entry))
            response = -1;
        else if(!profile.isProvider(entry))
            response = -1;

        return response;
    }
}
