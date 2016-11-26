package project.terminal.datemenus;

import project.database.profiles.profile.Date;
import project.database.profiles.profile.editable.EditableDate;
import project.terminal.IntEntryMenu;
import project.terminal.MultiLineEntryMenu;

/**
 * Created by Ashton on 10/23/2016.
 */
public class DateEntryMenu extends MultiLineEntryMenu<Date> {

    private EditableDate editableDate;

    //Constructors
    public DateEntryMenu(String name) {
        super(name);
    }

    public DateEntryMenu() {
        super("Date Entry");
    }

    /** Setup for the menus used for Date entry */
    @Override
    protected void setupMenus() {
        addMenu(new MonthEntryMenu());

        addMenu(new DayEntryMenu());

        addMenu(new YearEntryMenu());
    }

    /** Initializes the Date */
    @Override
    protected void initEntry() {
        editableDate = new EditableDate();
    }

    /** Finalizes the Date */
    @Override
    protected void finalizeEntry() { entry = editableDate.getImmutableType(); }

    /** Resolves the Month, Day and year singleLineEntry menus */
    @Override
    protected void resolveMenu(int menu_index) {
        switch (menu_index) {
            case 0:
                editableDate.setMonth(((IntEntryMenu) getMenu(menu_index)).getEntry());
                break;
            case 1:
                editableDate.setDay(((IntEntryMenu) getMenu(menu_index)).getEntry());
                break;
            case 2:
                editableDate.setYear(((IntEntryMenu) getMenu(menu_index)).getEntry());
                break;
            default:
                System.out.println("Invalid Menu Index!");
        }
    }
}
