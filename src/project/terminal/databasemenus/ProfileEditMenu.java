package project.terminal.databasemenus;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Address;
import project.database.profiles.profile.Member;
import project.database.profiles.profile.Profile;
import project.database.profiles.profile.editable.EditableMember;
import project.database.profiles.profile.editable.EditableProfile;
import project.terminal.ChangeConfirmationMenu;
import project.terminal.EditMenu;
import project.terminal.TerminalMenu;
import project.terminal.addressmenus.AddressEditMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashton on 15/11/16.
 */
public class ProfileEditMenu extends EditMenu<Profile, EditableProfile> {

    private ProfilesDatabase profilesDatabase;

    public ProfileEditMenu(ProfilesDatabase profilesDatabase, String memberID) throws NullPointerException { super("Edit Profile", "Profile", profilesDatabase.getMember(memberID));
        if (immutableType == null)
            throw new NullPointerException("Invalid Profile ID");
        this.profilesDatabase = profilesDatabase;
    }

    public ProfileEditMenu(ProfilesDatabase profilesDatabase, Member immutableMember) {
        super("Edit Member", "Member", immutableMember);
        this.profilesDatabase = profilesDatabase;
    }

    @Override
    protected List<TerminalMenu> getEditSelectionMenus() {
        ArrayList<TerminalMenu> editSelectionMenus = new ArrayList<>();

        editSelectionMenus.add(new ProfileNameEntryMenu("Edit Name"));
        editSelectionMenus.add(new AddressEditMenu(immutableType.getAddress()));

        return editSelectionMenus;
    }

    @Override
    public String getEditMenuBody(EditableProfile editableProfile) {
        String body = "";

        Profile p = (Profile)editableProfile.getImmutableType();

        body += "\n\tName: " + p.getName();

        Address a = p.getAddress();

        body += "\n\tStreet Address: " + a.getStreetAddress();
        body += "\n\tState: " + a.getState();
        body += "\n\tCity: " + a.getCity();
        body += "\n\tZip Code: " + a.getZip();

        return body;
    }

    @Override
    protected void setValue(EditableProfile editableProfile, int valueIndex, Object value) {
        switch (valueIndex) {
            case 0:
                editableProfile.setName((String)value);
                break;
            case 1:
                editableProfile.setAddress((Address)value);
                break;
            default:
                System.out.println("Invalid Value Index!");
        }
    }

    @Override
    protected boolean confirmChanges(EditableProfile editableProfile) {
        Profile p = (Profile)editableProfile.getImmutableType();
        Address a = p.getAddress();

        ChangeConfirmationMenu changeConfirmationMenu = new ChangeConfirmationMenu();
        changeConfirmationMenu.addChange("Name", immutableType.getName(), p.getName());
        changeConfirmationMenu.addChange("Street Address", immutableType.getAddress().getStreetAddress(), a.getStreetAddress());
        changeConfirmationMenu.addChange("State", immutableType.getAddress().getState(), a.getState());
        changeConfirmationMenu.addChange("City", immutableType.getAddress().getCity(), a.getCity());
        changeConfirmationMenu.addChange("Zip Code", immutableType.getAddress().getZip(), a.getZip());

        if (changeConfirmationMenu.hasChanges())
            return changeConfirmationMenu.runMenu();
        else
            return true;
    }

    @Override
    protected void onConfirmation(Profile editedProfile) { profilesDatabase.updateProfile(editedProfile); }
}
