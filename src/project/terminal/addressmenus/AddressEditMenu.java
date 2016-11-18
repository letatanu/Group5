package project.terminal.addressmenus;

import project.database.profiles.profile.Address;
import project.database.profiles.profile.editable.EditableAddress;
import project.terminal.EditMenu;
import project.terminal.databasemenus.entrymenus.ChangeConfirmationMenu;

public class AddressEditMenu extends EditMenu<Address, EditableAddress> {

    public AddressEditMenu(String name, String title, Address immutableAddress) {
        super(name, title, immutableAddress);
    }

    @Override
    protected String getEditMenuBody(EditableAddress editableAddress) {
        String body = "";

        Address a = editableAddress.getImmutableType();

        body += "\n\tStreet Address: " + a.getStreetAddress();
        body += "\n\tState: " + a.getState();
        body += "\n\tCity: " + a.getCity();
        body += "\n\tZip Code: " + a.getZip();

        return body;
    }

    @Override
    protected void setValue(EditableAddress editableAddress, int valueIndex, Object value) {
        if (value instanceof String) {
            switch (valueIndex) {
                case 0:
                    editableAddress.setStreetAddress((String)value);
                    break;
                case 1:
                    editableAddress.setState((String)value);
                    break;
                case 2:
                    editableAddress.setCity((String)value);
                    break;
                case 3:
                    editableAddress.setZip((String)value);
                    break;
                default:
                    System.out.println("Invalid Value Index!");
            }
        }
    }

    @Override
    protected boolean confirmChanges(EditableAddress editableType) {

        Address editedAddress = editableType.getImmutableType();

        ChangeConfirmationMenu changeConfirmationMenu = new ChangeConfirmationMenu();
        changeConfirmationMenu.addChange("Street Address", immutableType.getStreetAddress(), editedAddress.getStreetAddress());
        changeConfirmationMenu.addChange("State", immutableType.getState(), editedAddress.getState());
        changeConfirmationMenu.addChange("City", immutableType.getCity(), editedAddress.getCity());
        changeConfirmationMenu.addChange("Zip Code", immutableType.getZip(), editedAddress.getZip());

        if (changeConfirmationMenu.hasChanges())
            return changeConfirmationMenu.runMenu();
        else
            return true;
    }
}