package project.terminal.navmenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.SelectionMenu;
import project.terminal.TerminalMenu;

/**
 * Created by Anders on 11/17/2016.
 * Menu accessed by a Manager immediately after logging in.
 */
public class ManagerNavMenu extends OperatorNavMenu {

    public ManagerNavMenu(ProfilesDatabase profile) {
        super("Manager Menu", "Manager Navagaiton Menu", "\tWelcome to the ChocAn System. Please input your selection.", profile);

        addMenu(new ProfileModifyNavMenu("Provider Modify Menu", "Provider Modify Menu", "Allows modifications to providers", 2, profile));

        addMenu(new TerminalMenu("Print Manager Report") {
            @Override
            public Object runMenu() {
                return null;
            }
        });
    }


}
