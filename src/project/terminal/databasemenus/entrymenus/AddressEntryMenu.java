package project.terminal.databasemenus.entrymenus;


import project.database.profiles.profile.Address;
import project.database.profiles.profile.editable.EditableAddress;
import project.terminal.MultiLineEntryMenu;
import project.terminal.StringEntryMenu;

/**
 * Created by ashton on 10/11/16.
 */
public class AddressEntryMenu extends MultiLineEntryMenu<Address> {
    private EditableAddress editableAddress;

    public AddressEntryMenu() {
        super("Address Entry");
    }

    public AddressEntryMenu(String name) {
        super(name);
    }

    @Override
    protected void setupMenus() {
        addMenu(new StringEntryMenu("", "", "Street Address", 1, 25) {
            @Override
            public void printMenu() {}
        });

        addMenu(new StringEntryMenu("", "", "City", StringEntryMenu.ALPHABET_ONLY_REGEX, 1, 14) {
            @Override
            public void printMenu() {}
        });

        addMenu(new StringEntryMenu("", "The two letter State code.", "State", StringEntryMenu.ALPHABET_ONLY_REGEX, 2, 2) {
            @Override
            public void printMenu() {}
        });

        addMenu(new StringEntryMenu("", "", "Zip Code", StringEntryMenu.INTEGER_ONLY_REGEX, 5, 5) {
            @Override
            public void printMenu() {}
        });
    }

    @Override
    protected void initEntry() {
        editableAddress = new EditableAddress();
    }

    @Override
    protected void finalizeEntry() {
        entry = editableAddress.exportAddress();
    }

    @Override
    protected void resolveMenu(int menu_index) {
        switch (menu_index) {
            case 0:
                editableAddress.setStreetAddress(((StringEntryMenu)getMenu(menu_index)).getEntry());
                break;
            case 1:
                editableAddress.setCity(((StringEntryMenu)getMenu(menu_index)).getEntry());
                break;
            case 2:
                editableAddress.setState(((StringEntryMenu)getMenu(menu_index)).getEntry());
                break;
            case 3:
                editableAddress.setZip(((StringEntryMenu)getMenu(menu_index)).getEntry());
                break;
            default:
                System.out.println("Invalid Menu Index");
        }
    }
}
