package project.terminal.navmenus;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.Member;
import project.terminal.StringEntryMenu;
import project.terminal.TerminalMenu;
import project.terminal.databasemenus.entrymenus.MemberIDEntryMenu;

/**
 * Created by Anders on 11/17/2016.
 * Menu accessed by a Provider immediately after logging in.
 * Allows providers to make a selection of the actions
 * available to them. 
 */
public class ProviderNavMenu extends OperatorNavMenu {

    public ProviderNavMenu(ProfilesDatabase profile) {
        super("ProviderNavMenu", "Provider Navigation Menu", "\tHello, select a menu choice\n");

        //Blank selections waiting for databasemenus to be created.
        addTerminalMenu(new MemberIDEntryMenu(profile));

        addTerminalMenu(new TerminalMenu("View Service Directory") {
            @Override
            public Object runMenu() {
                return null;
            }
        });

        addTerminalMenu(new TerminalMenu("Print Provider Report") {
            @Override
            public Object runMenu() {
                return null;
            }
        });

    }
}
