package project.terminal.databasemenus;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Profile;
import project.database.profiles.profile.editable.EditableMember;
import project.database.profiles.profile.editable.EditableProfile;
import project.database.profiles.profile.editable.EditableProvider;
import project.terminal.MultiLineEntryMenu;
import project.terminal.addressmenus.AddressEntryMenu;

/**
 * Created by ashton on 10/11/16.
 */
public class ProfileEntryMenu extends MultiLineEntryMenu<Profile> {

    public static final int MEMBER_FLAG = 0;
    public static final int PROVIDER_FLAG = 1;
    public static final int MANAGER_FLAG = 2;

    private final ProfilesDatabase database;
    private final int profileEntryFlag;

    private EditableProfile editableProfile;

    public ProfileEntryMenu(String name, ProfilesDatabase database, int PROFILE_ENTRY_FLAG) {
        super(name);
        this.database = database;
        this.profileEntryFlag = PROFILE_ENTRY_FLAG;
    }

    @Override
    protected void setupMenus() {
        addMenu(new ProfileNameEntryMenu());
        addMenu(new AddressEntryMenu());
    }

    @Override
    protected void initEntry() {
        switch(profileEntryFlag) {
            case MEMBER_FLAG:
                editableProfile = new EditableMember();
                break;
            case PROVIDER_FLAG:
                editableProfile = new EditableProvider();
                break;
            case MANAGER_FLAG:
        }
    }

    @Override
    protected void finalizeEntry() {
        switch(profileEntryFlag) {
            case MEMBER_FLAG:
                entry = database.addMember((EditableMember)editableProfile);
                break;
            case PROVIDER_FLAG:
                entry = database.addProvider((EditableProvider)editableProfile);
                break;
            case MANAGER_FLAG:
        }
    }

    @Override
    protected void resolveMenu(int menu_index) {
        switch(menu_index) {
            case 0:
                editableProfile.setName(((ProfileNameEntryMenu)getMenu(menu_index)).getEntry());
                break;
            case 1:
                editableProfile.setAddress(((AddressEntryMenu)getMenu(menu_index)).getEntry());
                break;
            default:
                System.out.println("Invalid Menu Index!");
        }
    }
}
