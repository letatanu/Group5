package project;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.database.profiles.profile.Provider;
import project.database.profiles.profile.ProviderService;
import project.terminal.databasemenus.ProfileEditMenu;
import project.terminal.databasemenus.ProfileRemovalMenu;
import project.terminal.databasemenus.ProfileEntryMenu;
import project.terminal.databasemenus.ServiceEntryMenu;

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

        ProfileEntryMenu menu = new ProfileEntryMenu("", p, ProfileEntryMenu.MEMBER_FLAG);

        Member m = (Member)menu.runMenu();

        menu = new ProfileEntryMenu("", p, ProfileEntryMenu.PROVIDER_FLAG);

        Provider pr = (Provider)menu.runMenu();

        ServiceEntryMenu serviceEntryMenu = new ServiceEntryMenu("", p, "774840978", "387420489");

        ProviderService ps  = serviceEntryMenu.runMenu();

        p.save();

    }
}