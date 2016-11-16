package project.terminal.databasemenus.editmenus;

import project.terminal.SelectionMenu;
import project.terminal.SingleLineEntryMenu;

/**
 * Created by Ashton on 11/15/2016.
 */
public abstract class EditMenu<T> extends SelectionMenu {

    protected T editableObject;

    public EditMenu(T editableObject, String name, String title) {
        super(name, title, "");

        this.editableObject = editableObject;
    }

    @Override
    public void printMenu() {
        setupEditMenuBody();
        super.printMenu();
    }

    @Override
    protected void processValidEntry() {
        if (entry != EXIT_OPTION) {
            Object editedObjectValue = selectionOptions.get(entry - 1).runMenu();
            if (editedObjectValue != null) {
                if (runObjectValueEditConfirmationMenu())
                    setObjectValue(editedObjectValue);
            }
        }
    }

    protected abstract void setupEditMenuBody();

    protected abstract boolean runObjectValueEditConfirmationMenu();

    protected abstract void setObjectValue(Object editedObjectValue);
}
