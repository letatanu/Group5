package project.terminal.databasemenus.editmenus;

import project.database.profiles.profile.editable.EditableAddress;

/**
 * Created by Ashton on 11/15/2016.
 */
public class AddressEditMenu extends EditMenu<EditableAddress> {

    public AddressEditMenu(EditableAddress editableObject) {
        super(editableObject, "Edit Address", "Address");
    }

    @Override
    protected void setupEditMenuBody() {

    }

    @Override
    protected boolean runObjectValueEditConfirmationMenu() {
        return false;
    }

    @Override
    protected void setObjectValue(Object editedObjectValue) {

    }
}
