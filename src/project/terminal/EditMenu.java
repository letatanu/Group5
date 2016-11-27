package project.terminal;

import project.database.profiles.profile.ImmutableType;
import project.database.profiles.profile.editable.EditableType;

import java.util.List;

public abstract class EditMenu<I extends ImmutableType, E extends EditableType> extends TerminalMenu<I> {

    protected final I immutableType;

    private final String title;

    public EditMenu(String name, String title, I immutableType) {
        super(name);
        this.title = title;
        this.immutableType = immutableType;
    }

    @SuppressWarnings("unchecked cast")
    public final I runMenu() {

        I editedImmutableType = immutableType;
        try {
            E editableType = (E) immutableType.getEditableType();
            EditSelectionMenu editSelectionMenu = new EditSelectionMenu(title, editableType);
            editSelectionMenu.runMenu();

            if (confirmChanges(editableType)) {
                editedImmutableType = (I) editableType.getImmutableType();
                onConfirmation(editedImmutableType);
            }

        } catch (ClassCastException e) {
            System.out.println("Edit Menus Must use corresponding Immutable and Editable Types");
            e.printStackTrace();
            System.exit(-1);
        }

        return editedImmutableType;
    }

    protected void onConfirmation(I editedImmutableType) {}

    protected abstract List<TerminalMenu> getEditSelectionMenus();

    public abstract String getEditMenuBody(E editableType);

    protected abstract void setValue(E editableType, int valueIndex, Object value);

    protected abstract boolean confirmChanges(E editableType);

    private class EditSelectionMenu extends SelectionMenu {

        private E editableType;

        private EditSelectionMenu(String title, E editableType) {
            super("", title, "");
            this.editableType = editableType;

            List<TerminalMenu> editSelectionMenus = getEditSelectionMenus();
            for(TerminalMenu menu : editSelectionMenus)
                addMenu(menu);
        }

        @Override
        protected void printBody() { System.out.println('\n' + getBody() + '\n'); }

        @Override
        public void printMenu() {
            setBody(getEditMenuBody(editableType));
            super.printMenu();
        }

        @Override
        protected void processValidEntry() {
            if (entry != EXIT_OPTION) {
                Object value = selectionOptions.get(entry - 1).runMenu();
                if (value != null)
                    setValue(editableType, entry - 1, value);
            }
        }
    }
}