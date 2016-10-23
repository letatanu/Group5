package project.terminal;

import java.util.ArrayList;

/**
 * MultiLineEntryMenu - An extension of TerminalMenu which will construct complex
 *      Objects of type T with a list of menus sequentially run.
 *
 * Created by Ashton on 10/22/2016.
 */
public abstract class MultiLineEntryMenu<T> extends TerminalMenu<T> {

    //Menu List - List of menus sequentially run then resolved
    private ArrayList<TerminalMenu> menu_list;

    //Constructor
    public MultiLineEntryMenu(String name) {
        super(name);

        menu_list = new ArrayList<>();
    }

    /**
     * Runs the list of menus sequentially then resolves
     *
     * if the menu is a single line entry menu it will check for an
     *      exit value then return to the previous menu if exited
     *
     * @return entry - an Object of type T constructed with the list of menus
     */
    public T runMenu() {

        initEntry();

        int i;
        for(i = 0; i < menu_list.size();) {
            TerminalMenu menu = menu_list.get(i);

            menu.runMenu();

            if (menu instanceof SingleLineEntryMenu) {
                if (((SingleLineEntryMenu) menu).isExplicitExitEntry()) {
                    if (i > 0) {
                        i--;
                        continue;
                    } else
                        return null;
                }
            }

            resolveMenu(i++);
        }

        return entry;
    }

    /** Adds a menu to the list of menus used in constructing the Object of Type T */
    private void addMenu(TerminalMenu menu) {
        menu_list.add(menu);
    }

    /** Used to initialize the entry, in case it must be constructed */
    protected abstract void initEntry();

    /** Resolves the menu at given index - Such as retrieving the menu entry value and setting it
     *    in the primary Entry of type T
     *
     * @param menu_index - Index of the menu to be resolved
     */
    protected abstract void resolveMenu(int menu_index);
}
