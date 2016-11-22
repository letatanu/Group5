package project.terminal.navmenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.SelectionMenu;
import project.terminal.TerminalMenu;

/**
 * Created by Anders on 11/17/2016.
 * Base menu for Operators to navigate the ChocAn system.
 */
abstract class OperatorNavMenu extends SelectionMenu {
    OperatorNavMenu(String name, String title, String body, ProfilesDatabase profile) {
        super(name, title, body);

        addMenu(new ProfileModifyNavMenu("Member Modify Menu", "Member Modify Menu", "Allows modifications to members", 1, profile));
    }


}