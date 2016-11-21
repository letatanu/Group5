package project.terminal.databasemenus;

import project.database.profiles.ProfilesDatabase;

/**
 * Created by ahunger on 11/20/2016.
 */
public class MemberRemovalMenu extends ProfileIDEntryMenu {

    public MemberRemovalMenu(ProfilesDatabase profilesDatabase, String name, String body, String entry_prompt) {
        super(profilesDatabase, MEMBER_ONLY_FLAG, name, body, entry_prompt);

    }

    public MemberRemovalMenu(ProfilesDatabase profilesDatabase) {
        super(profilesDatabase, MEMBER_ONLY_FLAG, "Remove Member", "Member to be removed. Type \"Back\" to return.", "Member ID");
    }

    @Override
    public void processValidEntry() { profilesDatabase.removeProfile(entry); }
}
