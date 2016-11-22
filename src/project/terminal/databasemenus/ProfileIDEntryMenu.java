package project.terminal.databasemenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.StringEntryMenu;

/**
 * Created by ashton on 10/11/16.
 */

public class ProfileIDEntryMenu extends StringEntryMenu {

    public static final int MEMBER_ONLY_FLAG = 1;
    public static final int PROVIDER_ONLY_FLAG = 2;
    public static final int MANAGER_ONLY_FLAG = 3;
    public static final int OPERATOR_ONLY_FLAG = 4;

    protected final ProfilesDatabase profilesDatabase;
    private final int FILTER_FLAG;

    public ProfileIDEntryMenu(ProfilesDatabase profilesDatabase, String name, String body, String entry_prompt) {
        super(name, body, entry_prompt, 9, 9);
        this.profilesDatabase = profilesDatabase;
        FILTER_FLAG = 0;
        setExitInput("Back");
    }

    public ProfileIDEntryMenu(ProfilesDatabase profilesDatabase, int filter_flag, String name, String body, String entry_prompt) {
        super(name, body, entry_prompt, 9, 9);
        this.profilesDatabase = profilesDatabase;
        FILTER_FLAG = filter_flag;
        setExitInput("Back");
    }

    @Override
    protected void printMenu() { System.out.println('\n' + getBody()); }

    @Override
    protected int generateEntryResponseCode() {
        int response = super.generateEntryResponseCode();

        if (response == 0) {
            switch (FILTER_FLAG) {
                case 1:
                    response = (profilesDatabase.isMember(entry) ? 0 : -6);
                    break;
                case 2:
                    response = (profilesDatabase.isProvider(entry) ? 0 : -7);
                    break;
                case 3:
                    response = (profilesDatabase.isManager(entry) ? 0 : -8);
                    break;
                case 4:
                    response = ((profilesDatabase.isManager(entry) || profilesDatabase.isProvider(entry)) ? 0 : -9);
                    break;
                default:
                    response = (profilesDatabase.isProfile(entry) ? 0 : -5);
            }
        }

        return response;
    }

    @Override
    protected void printEntryResponse(int responseCode) {
        super.printEntryResponse(responseCode);
        if (responseCode < -4 && responseCode >= -9) {
            String profileDescriptor = "Profile";
            switch (responseCode) {
                case -6:
                    profileDescriptor = "Member";
                    break;
                case -7:
                    profileDescriptor = "Provider";
                    break;
                case -8:
                    profileDescriptor = "Manager";
                    break;
                case -9:
                    profileDescriptor = "Operator";
                    break;
                case -5:
                    profileDescriptor = "Profile";
                    break;
            }

            System.out.println("The " + profileDescriptor + " ID entered does not match any account! Please try again.");
        }
    }
}
