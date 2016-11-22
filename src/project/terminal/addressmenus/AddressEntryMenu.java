package project.terminal.addressmenus;


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
        addMenu(new StreetAddressEntryMenu());

        addMenu(new CityEntryMenu());

        addMenu(new StateCodeEntryMenu());

        addMenu(new ZipCodeEntryMenu());
    }

    @Override
    protected void initEntry() {
        editableAddress = new EditableAddress();
    }

    @Override
    protected void finalizeEntry() {
        entry = editableAddress.getImmutableType();
    }

    @Override
    protected void resolveMenu(int menuIndex) {
        switch (menuIndex) {
            case 0:
                editableAddress.setStreetAddress(((StringEntryMenu)getMenu(menuIndex)).getEntry());
                break;
            case 1:
                editableAddress.setCity(((StringEntryMenu)getMenu(menuIndex)).getEntry());
                break;
            case 2:
                editableAddress.setState(((StringEntryMenu)getMenu(menuIndex)).getEntry());
                break;
            case 3:
                editableAddress.setZip(((StringEntryMenu)getMenu(menuIndex)).getEntry());
                break;
            default:
                System.out.println("Invalid Menu Index");
        }
    }
}
