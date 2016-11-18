package project;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Address;
import project.database.profiles.profile.Member;
import project.terminal.BooleanEntryMenu;
import project.terminal.addressmenus.AddressEditMenu;
import project.terminal.addressmenus.AddressEntryMenu;
import project.terminal.databasemenus.entrymenus.ChangeConfirmationMenu;
import project.terminal.databasemenus.entrymenus.MemberEntryMenu;

public final class Main {

    public static void main(String[] args) {

        AddressEntryMenu addressEntryMenu = new AddressEntryMenu();

        Address address = addressEntryMenu.runMenu();

        /*
        ProfilesDatabase p = new ProfilesDatabase();

        p.initialize();

        MemberEntryMenu menu = new MemberEntryMenu("",p);

        Member m = menu.runMenu();

        Member m_test = p.getMember(m.getID());

        System.out.println(m.getName() + " " + m_test.getName());

        p.save();
        */
    }
}