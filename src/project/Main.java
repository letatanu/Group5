package project;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.terminal.databasemenus.entrymenus.MemberEntryMenu;

public final class Main {

    public static void main(String[] args) {

        ProfilesDatabase p = new ProfilesDatabase();

        p.initialize();

        MemberEntryMenu menu = new MemberEntryMenu("",p);

        Member m = menu.runMenu();

        Member m_test = p.getMember(m.getID());

        System.out.println(m.getName() + " " + m_test.getName());

        p.save();
    }
}