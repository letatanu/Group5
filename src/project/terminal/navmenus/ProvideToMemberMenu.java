package project.terminal.navmenus;

import project.database.profiles.ProfilesDatabase;
import project.terminal.SelectionMenu;
import project.terminal.TerminalMenu;

/**
 * Created by Anders on 11/18/2016.
 * Provider menu to select which options
 * for a specific member
 */
public class ProvideToMemberMenu extends SelectionMenu {

    private ProfilesDatabase profile;
    private String memberID;

    public ProvideToMemberMenu(ProfilesDatabase profile, String memberID) {
        super("Provider to Member Menu", "Provider to Member Menu", "Select choice to provide to member.");

        this.profile = profile;
        this.memberID = memberID;

        addMenu(new TerminalMenu("View Service Directory") {
            @Override
            public Object runMenu() {
                return null;
            }
        });

        addMenu(new TerminalMenu("Provide Service to Member") {
            @Override
            public Object runMenu() {
                return null;
            }
        });
    }


}
