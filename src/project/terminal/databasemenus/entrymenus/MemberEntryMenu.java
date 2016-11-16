package project.terminal.databasemenus.entrymenus;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.database.profiles.profile.editable.EditableMember;
import project.terminal.MultiLineEntryMenu;

/**
 * Created by ashton on 10/11/16.
 */
public class MemberEntryMenu extends MultiLineEntryMenu<Member> {

    private ProfilesDatabase database;
    private EditableMember editableMember;

    public MemberEntryMenu(String name, ProfilesDatabase database) {
        super(name);
        this.database = database;
    }

    @Override
    protected void setupMenus() {
        addMenu(new ProfileNameEntryMenu());
        addMenu(new AddressEntryMenu());
    }

    @Override
    protected void initEntry() {
        editableMember = new EditableMember();
    }

    @Override
    protected void finalizeEntry() {
        entry = database.addMember(editableMember);
    }

    @Override
    protected void resolveMenu(int menu_index) {
        switch(menu_index) {
            case 0:
                editableMember.setFirstName(((ProfileNameEntryMenu)getMenu(menu_index)).getEntry());
                break;
            case 1:
                editableMember.setAddress(((AddressEntryMenu)getMenu(menu_index)).getEntry());
                break;
            default:
                System.out.println("Invalid Menu Index!");
        }
    }
}
