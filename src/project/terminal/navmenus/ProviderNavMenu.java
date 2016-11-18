package project.terminal.navmenus;

import project.terminal.SelectionMenu;
import project.terminal.TerminalMenu;

/**
 * Created by Anders on 11/17/2016.
 * Menu accessed by a Provider immediately after logging in.
 */
public class ProviderNavMenu extends SelectionMenu {

    public ProviderNavMenu() {
        super("ProviderNavMenu", "Provider Navigation Menu", "\tHello, select a menu choice\n");

        //Blank selections waiting for databasemenus to be created.
        addTerminalMenu(new TerminalMenu("Provide to Member") {
            @Override
            public Object runMenu() {
                return null;
            }
        });

        addTerminalMenu(new TerminalMenu("Add/Remove/Update Member") {
            @Override
            public Object runMenu() {
                return null;
            }
        });

        addTerminalMenu(new TerminalMenu("Print Reports") {
            @Override
            public Object runMenu() {
                return null;
            }
        });

    }
}
