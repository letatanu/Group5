package project.terminal.navmenus;

import project.terminal.SelectionMenu;
import project.terminal.TerminalMenu;

/**
 * Created by Anders on 11/17/2016.
 * Menu accessed by a Manager immediately after logging in.
 */
public class ManagerNavMenu extends OperatorNavMenu {
    public ManagerNavMenu() {
        super("Manager Menu", "Manager Navagaiton Menu", "\tWelcome to the ChocAn System. Please input your selection.");

        addTerminalMenu(new TerminalMenu("Add/Update/Remove Provider") {
            @Override
            public Object runMenu() {
                return null;
            }
        });

        addTerminalMenu(new TerminalMenu("Print Manager Report") {
            @Override
            public Object runMenu() {
                return null;
            }
        });
    }


}
