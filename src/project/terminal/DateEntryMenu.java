package project.terminal;

/**
 * Created by Ashton on 10/23/2016.
 */
public class DateEntryMenu extends MultiLineEntryMenu<Date> {

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
        addMenu(new IntEntryMenu("", "", "", "Enter the month", 1, 12) {
            @Override
            protected void printMenu() {}
        });

        addMenu(new IntEntryMenu("", "", "", "Enter the day or type 5 to return to previous menu", 1, 31) {
            @Override
            protected void printMenu() {
                setExitValue(5);}
        });

        addMenu(new IntEntryMenu("", "", "", "Enter the year", 1990, 2016) {
            @Override
            protected void printMenu() {}
        });
    }

    /** Initializes the Date */
    @Override
    protected void initEntry() {
        entry = new Date();
    }

    /** Resolves the Month, Day and year singleLineEntry menus */
    @Override
    protected void resolveMenu(int menu_index) {
        switch (menu_index) {
            case 0:
                entry.setMonth(((IntEntryMenu) getMenu(menu_index)).getEntry());
                break;
            case 1:
                entry.setDay(((IntEntryMenu) getMenu(menu_index)).getEntry());
                break;
            case 2:
                entry.setYear(((IntEntryMenu) getMenu(menu_index)).getEntry());
                break;
            default:
                System.out.println("Invalid Menu Index!");
        }
    }
}
