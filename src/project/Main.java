package project;

import project.database.profiles.ProfilesDatabase;
import project.terminal.databasemenus.identrymenus.OperatorLogInEntry;
import project.terminal.navmenus.ManagerNavMenu;
import project.terminal.navmenus.ProviderNavMenu;

public final class Main {

    public static void main(String[] args) {

        /*
        AddressEntryMenu addressEntryMenu = new AddressEntryMenu();

        Address address = addressEntryMenu.runMenu();

        AddressEditMenu addressEditMenu = new AddressEditMenu(address);

        Address address1 = addressEditMenu.runMenu();

        System.out.println(address.getCity() + " " + address1.getCity());

        */

        String id = "aaaa";
        ProfilesDatabase p = new ProfilesDatabase();
        ManagerNavMenu c = new ManagerNavMenu(p);

        c.runMenu();


        /*ProfilesDatabase p = new ProfilesDatabase();

        p.initialize();

        ProfileEntryMenu menu = new ProfileEntryMenu("", p, ProfileEntryMenu.MEMBER_FLAG);

        Member m = (Member)menu.runMenu();

        ProfileEditMenu profileEditMenu = new ProfileEditMenu(p, m);

        profileEditMenu.runMenu();

        menu = new ProfileEntryMenu("", p, ProfileEntryMenu.PROVIDER_FLAG);

        menu.runMenu();

        ProfileRemovalMenu profileRemovalMenu = new ProfileRemovalMenu(p);

        profileRemovalMenu.runMenu();

        p.save();*/

    }
}