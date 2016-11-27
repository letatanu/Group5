package project;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.database.provider_directory.Provider;
import project.database.provider_directory.ProviderDatabase;
import project.terminal.databasemenus.ProfileEditMenu;
import project.terminal.databasemenus.ProfileRemovalMenu;
import project.terminal.databasemenus.ProfileEntryMenu;

public final class Main {

    public static void main(String[] args) {

        /*
        AddressEntryMenu addressEntryMenu = new AddressEntryMenu();

        Address address = addressEntryMenu.runMenu();

        AddressEditMenu addressEditMenu = new AddressEditMenu(address);

        Address address1 = addressEditMenu.runMenu();

        System.out.println(address.getCity() + " " + address1.getCity());

        */

        ProviderDatabase p = new ProviderDatabase();

        p.initialize();

       // ProfileEntryMenu menu = new ProfileEntryMenu("",p, ProfileEntryMenu.MEMBER_FLAG);

      //  Member m = (Member)menu.runMenu();

     //   ProfileEditMenu profileEditMenu = new ProfileEditMenu(p, m);

      //  profileEditMenu.runMenu();

      //  menu = new ProfileEntryMenu("", p, ProfileEntryMenu.PROVIDER_FLAG);

       // menu.runMenu();

      //  p.save();

    }
}