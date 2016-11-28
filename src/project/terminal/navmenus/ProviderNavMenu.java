package project.terminal.navmenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.TerminalMenu;
import project.terminal.databasemenus.identrymenus.IDEntryProvide;

/**
 * Created by Anders on 11/17/2016.
 * Menu accessed by a Provider immediately after logging in.
 * Allows providers to make a selection of the actions
 * available to them. 
 */
public class ProviderNavMenu extends OperatorNavMenu {

    private final ProfilesDatabase profilesDatabase;

    //You will need the ID when printing a specific provider's report
    private final String providerID;

    public ProviderNavMenu(ProfilesDatabase profilesDatabase, String providerID) {
        super("ProviderNavMenu", "Provider Navigation Menu", "\tHello, select a menu choice\n", profilesDatabase);

        this.profilesDatabase = profilesDatabase;
        this.providerID = providerID;

        //Blank selections waiting for databasemenus to be created.
        addMenu(new IDEntryProvide(profilesDatabase, "Provide to Member Menu"));

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
