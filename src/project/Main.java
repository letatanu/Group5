package project;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.terminal.databasemenus.MemberEditMenu;
import project.terminal.databasemenus.MemberEntryMenu;

public final class Main {

    public static void main(String[] args) {

        /*
        AddressEntryMenu addressEntryMenu = new AddressEntryMenu();

        Address address = addressEntryMenu.runMenu();

        AddressEditMenu addressEditMenu = new AddressEditMenu(address);

        Address address1 = addressEditMenu.runMenu();

        System.out.println(address.getCity() + " " + address1.getCity());

       */

        ProfilesDatabase p = new ProfilesDatabase();

        p.initialize();

        MemberEntryMenu menu = new MemberEntryMenu("",p);

        Member m = menu.runMenu();

        Member m_test = p.getMember(m.getID());

        MemberEditMenu memberEditMenu = new MemberEditMenu(p, m_test);

        Member m_edited = memberEditMenu.runMenu();

        memberEditMenu = new MemberEditMenu(p, m_edited);

        memberEditMenu.runMenu();

        p.save();
    }
}