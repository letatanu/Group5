package project.terminal.navmenus;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.terminal.StringEntryMenu;
import project.terminal.TerminalMenu;
import project.terminal.databasemenus.entrymenus.MemberEntryMenu;
import project.terminal.databasemenus.entrymenus.MemberIDEntryMenu;

/**
 * Created by Anders on 11/17/2016.
 * Menu accessed by a Provider immediately after logging in.
 * Allows providers to make a selection of the actions
 * available to them. 
 */
public class ProviderNavMenu extends OperatorNavMenu {

    public ProviderNavMenu(ProfilesDatabase profile) {
        super("ProviderNavMenu", "Provider Navigation Menu", "\tHello, select a menu choice\n", profile);

        //Blank selections waiting for databasemenus to be created.
        addMenu(new MemberIDEntryMenu("Provide to Member", profile));

        addMenu(new TerminalMenu("View Service Directory") {
            @Override
            public Object runMenu() {
                return null;
            }
        });

        addMenu(new TerminalMenu("Print Provider Report") {
            @Override
            public Object runMenu() {
                return null;
            }
        });

    }
}
