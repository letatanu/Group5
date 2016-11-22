package project;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.terminal.databasemenus.MemberEditMenu;
import project.terminal.databasemenus.MemberEntryMenu;
import project.terminal.databasemenus.MemberRemovalMenu;

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

        //MemberEditMenu memberEditMenu = new MemberEditMenu(p, m);

        //memberEditMenu.runMenu();

        //menu = new MemberEntryMenu("",p);

        //menu.runMenu();

        MemberRemovalMenu memberRemovalMenu = new MemberRemovalMenu(p);

        memberRemovalMenu.runMenu();

        p.save();
    }
}