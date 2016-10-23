package project.terminal;

/**
 * Terminal Menu is the abstract base class of the menu system.
 *      T - The type of entry the menu will return after being run
 *
 * Created by Ashton on 10/23/2016.
 */
public abstract class TerminalMenu<T> {

    //Attributes
    private String name;  //Used in lists

    //Entry
    protected T entry;

    //Constructor
    public TerminalMenu(String name) {
        this.name = name;
    }

    /** Returns name **/
    public String getName() {
        return name;
    }

    /** Returns entry - the most recent entry upon menu exit */
    public T getEntry() {

        return entry;
    }

    /** Used by all menus to run the menu functionality then return a Type*/
    public abstract T runMenu();
}
