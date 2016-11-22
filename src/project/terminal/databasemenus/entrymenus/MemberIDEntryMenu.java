package project.terminal.databasemenus.entrymenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.StringEntryMenu;

/**
 * Created by Anders on 11/18/2016.
 * Checks a member ID with the database, returning success if a match,
 * otherwise failure.
 */
public class MemberIDEntryMenu extends StringEntryMenu{
    private ProfilesDatabase profile;

    public MemberIDEntryMenu(String name, ProfilesDatabase profile) {
        super(name, "Member ID Entry Menu", "Enter Member ID: ");
        this.profile = profile;
    }

    @Override
    protected int generateEntryResponseCode() {

        int response = 0;

        if(entry == null || !profile.isMember(entry)) {
            response = -1;
        }

        return response;
    }
}
