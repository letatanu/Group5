package project;

import project.database.profiles.profile.Address;
import project.terminal.addressmenus.AddressEditMenu;
import project.terminal.addressmenus.AddressEntryMenu;

public final class Main {

    public static void main(String[] args) {

        AddressEntryMenu addressEntryMenu = new AddressEntryMenu();

        Address address = addressEntryMenu.runMenu();

        AddressEditMenu addressEditMenu = new AddressEditMenu(address);

        Address address1 = addressEditMenu.runMenu();

        System.out.println(address.getCity() + " " + address1.getCity());

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