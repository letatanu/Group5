package project.terminal.databasemenus.editmenus;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Address;
import project.database.profiles.profile.Member;
import project.database.profiles.profile.editable.EditableMember;
import project.terminal.ChangeConfirmationMenu;
import project.terminal.EditMenu;
import project.terminal.TerminalMenu;
import project.terminal.addressmenus.AddressEditMenu;
import project.terminal.databasemenus.entrymenus.ProfileNameEntryMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashton on 15/11/16.
 */
public class MemberEditMenu extends EditMenu<Member, EditableMember> {

    private ProfilesDatabase profilesDatabase;

    public MemberEditMenu(ProfilesDatabase profilesDatabase, String memberID) throws NullPointerException { super("Edit Member", "Member", profilesDatabase.getMember(memberID));
        if (immutableType == null)
            throw new NullPointerException("Invalid MemberID");
        this.profilesDatabase = profilesDatabase;
    }

    public MemberEditMenu(ProfilesDatabase profilesDatabase, Member immutableMember) {
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
    public String getEditMenuBody(EditableMember editableMember) {
        String body = "";

        Member m = editableMember.getImmutableType();

        body += "\n\tName: " + m.getName();

        Address a = m.getAddress();

        body += "\n\tStreet Address: " + a.getStreetAddress();
        body += "\n\tState: " + a.getState();
        body += "\n\tCity: " + a.getCity();
        body += "\n\tZip Code: " + a.getZip();

        return body;
    }

    @Override
    protected void setValue(EditableMember editableMember, int valueIndex, Object value) {
        switch (valueIndex) {
            case 0:
                editableMember.setName((String)value);
                break;
            case 1:
                editableMember.setAddress((Address)value);
                break;
            default:
                System.out.println("Invalid Value Index!");
        }
    }

    @Override
    protected boolean confirmChanges(EditableMember editableMember) {
        Member m = editableMember.getImmutableType();
        Address a = m.getAddress();

        ChangeConfirmationMenu changeConfirmationMenu = new ChangeConfirmationMenu();
        changeConfirmationMenu.addChange("Name", immutableType.getName(), m.getName());
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
    protected void onConfirmation(Member editedMember) {
        profilesDatabase.removeProfile(editedMember.getID());
        profilesDatabase.addMember(editedMember.getEditableType());
    }
}
