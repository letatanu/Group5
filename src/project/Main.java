package project;

import project.terminal.BooleanEntryMenu;
import project.terminal.navmenus.IDEntryMenu;
import project.terminal.navmenus.ManagerNavMenu;
import project.terminal.navmenus.ProviderNavMenu;

public final class Main {

    public static void main(String[] args) {

        /*BooleanEntryMenu booleanEntryMenu = new BooleanEntryMenu("Proceed Confirmation", "Do you confirm the following changes? \n\t a) First \n\t b) Second");

        boolean b = booleanEntryMenu.runMenu();

        System.out.println(b);*/

        ManagerNavMenu c = new ManagerNavMenu();

        c.runMenu();

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