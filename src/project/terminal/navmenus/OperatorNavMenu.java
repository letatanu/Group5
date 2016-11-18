package project.terminal.navmenus;

import project.terminal.SelectionMenu;
import project.terminal.TerminalMenu;

/**
 * Created by Anders on 11/17/2016.
 * Base menu for Operators to navigate the ChocAn system.
 */
abstract class OperatorNavMenu extends SelectionMenu {
    OperatorNavMenu(String name, String title, String body) {
        super(name, title, body);

        addTerminalMenu(new TerminalMenu("Add/Remove/Update Member") {
            @Override
            public Object runMenu() {
                return null;
            }
        });
    }


}