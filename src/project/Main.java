package project;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.terminal.BooleanEntryMenu;
import project.terminal.databasemenus.entrymenus.IDEntryMenu;
import project.terminal.databasemenus.entrymenus.MemberEntryMenu;

public final class Main {

    public static void main(String[] args) {

        BooleanEntryMenu booleanEntryMenu = new BooleanEntryMenu("Proceed Confirmation", "Do you confirm the following changes? \n\t a) First \n\t b) Second");

        //boolean b = booleanEntryMenu.runMenu();

        //System.out.println(b);

        IDEntryMenu s = new IDEntryMenu("Operator Login", "Enter Operator ID: ");

        String c = s.runMenu();

        System.out.println(c);

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