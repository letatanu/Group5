package project.terminal.databasemenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.SingleLineEntryMenu;
import project.terminal.StringEntryMenu;

/**
 * Created by ashton on 10/11/16.
 */

public class ProfileIDEntryMenu extends StringEntryMenu {

    public static final int MEMBER_ONLY_FLAG = 1;
    public static final int PROVIDER_ONLY_FLAG = 2;
    public static final int MANAGER_ONLY_FLAG = 3;
    public static final int OPERATOR_ONLY_FLAG = 4;

    private final ProfilesDatabase profilesDatabase;
    private final int FILTER_FLAG;

    public ProfileIDEntryMenu(ProfilesDatabase profilesDatabase, String name, String body, String entry_prompt) {
        super(name, body, entry_prompt, 9, 9);
        this.profilesDatabase = profilesDatabase;
        FILTER_FLAG = 0;
    }

    public ProfileIDEntryMenu(ProfilesDatabase profilesDatabase, int filter_flag, String name, String body, String entry_prompt) {
        super(name, body, entry_prompt, 9, 9);
        this.profilesDatabase = profilesDatabase;
        FILTER_FLAG = filter_flag;
    }

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
        if (responseCode < -4) {
            switch (responseCode) {
                case -5:
                    System.out.println("Invalid Profile ID");
                    break;
                case -6:
                    System.out.println("Invalid Member ID");
                    break;
                case -7:
                    System.out.println("Invalid Provider ID");
                    break;
                case -8:
                    System.out.println("Invalid Manager ID");
                    break;
                case -9:
                    System.out.println("Invalid Operator ID");
                    break;
            }
        }
    }
}
