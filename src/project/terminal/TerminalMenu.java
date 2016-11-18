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
    protected TerminalMenu(String name) {
        this.name = name;
    }

    /** Returns firstName **/
    public String getName() {
        return name;
    }

    /** Returns entry - the most recent entry upon menu exit */
    public T getEntry() {

        return entry;
    }

    /** Used by all menus to run the menu functionality then return a Type*/
    public abstract T runMenu();

    /** Prints the title centered with accent characters at the width of the body */
    static void printTitle(String title, char titleAccentChar, int bodyWidth) {

        System.out.print('\n');

        int accent_length = (bodyWidth /2) - (title.length()/2);
        for(int i = 0; i < accent_length; i++)
            System.out.print(titleAccentChar);

        System.out.print(title);

        for(int i = 0; i < accent_length; i++)
            System.out.print(titleAccentChar);
    }

    /**Prints the body wrapping at the defined body width. Wrapping will break at the most recent space
     *     if available
     */
    static void printBody(String body, int bodyWidth) {
        System.out.print('\n');

        //Version 1.1
        int i = 0;

        StringBuilder s = new StringBuilder(body);

        //Wrap every bodyWidth number of characters
        while((i = s.indexOf(" ", i + bodyWidth)) != -1) {
            s.replace(i, i + 1, "\n");
        }

        System.out.println(s.toString());

        /*
        int last_break = -1;
        int last_space = -1;

        for(int i = 0; i < len; i++) {
            if (body.charAt(i) == ' ')
                last_space = i;
            if (i - last_break > bodyWidth) {
                if (last_space == -1)
                    System.out.println(body.substring(last_break + 1, i));
                else {
                    System.out.println(body.substring(last_break + 1, last_space));
                    i = last_space;
                    last_space = -1;
                }
                last_break = i;
            }
        }*/
    }
}
