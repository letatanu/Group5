package project.terminal;

import java.util.Scanner;

/**
 * TerminalMenu - an abstract class used to facilitate and standardize project.terminal
 *     menu design and traversal.
 *
 *     T - The type of entry the menu will parse the input for, which must extend
 *         comparable to allow for explicit exiting
 *
 * Created by Ashton on 10/17/2016.
 */
public abstract class TerminalMenu<T extends Comparable<T>> {

    //Default Settings
    private static final int DEFAULT_BODY_WIDTH = 80;
    private static final int DEFAULT_TITLE_ACCENT_CHAR = '-';

    //Settings
    protected int bodyWidth = DEFAULT_BODY_WIDTH;                //Width of the body paragraph before wrapping
    protected char titleAccentChar = DEFAULT_TITLE_ACCENT_CHAR; //Accents used to center the menu title

    //Input Scanner
    private Scanner scanner = new Scanner(System.in);

    //Attributes
    private String name;  //Used in lists
    private String title; //Used as body header
    private String body;
    private String entryPrompt;

    //Entry
    protected T entry;

    //Exit Entry - Used to define a specific entry to break out of the menu
    protected T exitEntry = null;

    //Constructor
    public TerminalMenu(String name, String title, String body, String entry_prompt) {
        this.name = name;
        this.title = title;
        this.body = body;
        this.entryPrompt = entry_prompt;
        entry = null;
    }

    /**
    * runMenu will display the menu to the user, wait for input, loop until a valid entry
    *    is entered, process the valid entry. If an exit entry is defined and not entered
    *    exactly, the menu will be redisplayed, otherwise it will return.
    *
    * @return entry - The final valid entry
     */
    public T runMenu() {
        entry = null;
        do {
            printMenu();
            int response_code;
            do {
                String input = displayEntryPrompt();

                entry = parseInputForEntry(input);

                response_code = generateEntryResponseCode();

                System.out.print('\n');
                printEntryResponse(response_code);

            } while(response_code != 0);
            processValidEntry();
        } while (exitEntry != null && !exitEntry.equals(entry));
        return entry;
    }

    /**
     * Sets an explicit exit value, which requires the exit entry to be entered to leave the menu *
     *
     * @param exitEntry - Explicit exit Object of type T
     */
    protected void setExplicitExit(T exitEntry) { this.exitEntry = exitEntry; }

    /** Returns name **/
    public String getName() {
        return name;
    }

    /** Returns title */
    public String getTitle() {
        return title;
    }

    /** Returns body */
    protected String getBody() {
        return body;
    }

    /** Returns entry prompt */
    protected String getEntryPrompt() {
        return entryPrompt;
    }

    /** Returns entry - the most recent entry upon menu exit */
    public T getEntry() {

        return entry;
    }

    /** Prints the title centered with accent characters at the width of the body */
    protected void printTitle() {

        System.out.print('\n');

        int accent_length = (bodyWidth /2) - (getTitle().length()/2);
        for(int i = 0; i < accent_length; i++)
            System.out.print(titleAccentChar);

        System.out.print(getTitle());

        for(int i = 0; i < accent_length; i++)
            System.out.print(titleAccentChar);
    }

    /**Prints the body wrapping at the defined body width. Wrapping will break at the most recent space
     *     if available
     */
    protected void printBody() {
        System.out.print('\n');

        int last_break = -1;
        int last_space = -1;
        for(int i = 0; i < body.length(); i++) {
            if (body.charAt(i) == ' ')
                last_space = i;
            if (i - last_break > bodyWidth) {
                if (last_space == -1)
                    System.out.println(body.substring(last_break + 1, i));
                else {
                    System.out.println(body.substring(last_break + 1, last_space));
                    i = last_space;
                }
                last_break = i;
            }
        }
    }

    /** Default menu print which prints the title, then the body */
    protected void printMenu() {
        printTitle();
        printBody();
    }

    /**
     * Prints the defined entry prompt, waits to read in the input
     *
     * @return user_input - the user input as a String
     */
    protected String displayEntryPrompt() {
        System.out.print('\n'+ entryPrompt +": ");
        return scanner.nextLine();
    }

    /** Optional function to additionally process a valid entry after printing the response code */
    protected void processValidEntry() {}

    /**
     * Parse the raw user input to create an Object of type T then returns
     *
     * @param input - raw input from the user
     * @return entry - returns entry if the input can be converted to type T otherwise returns null
     */
    protected abstract T parseInputForEntry(String input);

    /**
     * Generates a response code based on the entry value. 0 is a valid entry, all other values
     *     can be determined by the implementing class. The response code will be used by
     *     printEntryResponse
     *
     * @return response_code
     */
    protected abstract int generateEntryResponseCode();

    /**
     * Uses the code generated by generateEntryResponseCode to print a response to the user, based on
     *     the entry. It is suggested that 0 either print nothing or a confirmation. All other responses
     *     are defined by the implementing class.
     *
     * @param responseCode - The response code generated by generateEntryResponseCode
     */
    protected abstract void printEntryResponse(int responseCode);
}
