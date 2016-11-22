package project.terminal;

import java.util.Scanner;

/**
 * SingleLineEntryMenu - An extension of TerminalMenu which constructs simple objects of
 *      Type T with a single line entry into the terminal
 *
 *     T - The type of entry the menu will parse the input for, which must extend
 *         comparable to allow for explicit exiting
 *
 * Created by Ashton on 10/17/2016.
 */
public abstract class SingleLineEntryMenu<T extends Comparable<T>> extends TerminalMenu<T> {

    //Default Settings
    private static final int DEFAULT_BODY_WIDTH = 80;
    private static final int DEFAULT_TITLE_ACCENT_CHAR = '-';

    //Settings
    protected int bodyWidth = DEFAULT_BODY_WIDTH;                //Width of the body paragraph before wrapping
    protected char titleAccentChar = DEFAULT_TITLE_ACCENT_CHAR; //Accents used to center the menu title

    //Exit Entry - Used to define a specific entry to break out of the menu
    protected boolean explicitExit = false;
    protected String exitInput = null;
    protected T exitEntry = null;

    //Input Scanner
    private Scanner scanner = new Scanner(System.in);

    private String title; //Used as body header
    private String body;
    private String entryPrompt;

    //Constructor
    public SingleLineEntryMenu(String name, String title, String body, String entry_prompt) {
        super(name);
        this.title = title;
        this.body = body;
        this.entryPrompt = entry_prompt;
        entry = null;
    }

    /**
     * Sets an exit value of type T, which is used to return to the previous menu *
     *
     * @param exitEntry - Explicit exit Object of type T
     */
    protected void setExitValue(T exitEntry) {
        this.exitEntry = exitEntry;
    }

    /**
     * Sets an exit value, which is used to return to the previous menu *
     *
     * @param exitInput - Explicit exit Object of type String
     */
    protected void setExitInput(String exitInput) { this.exitInput = exitInput; }

    /** Returns whether the current entry value is equal to the exit value */
    public boolean isExitEntry() {
        if (exitEntry != null && entry != null) {
            return (exitEntry.equals(entry));
        } else
            return false;
    }

    /** If an exit value is set, explict exit requires that value to return */
    protected void setExplicitExit(boolean explicitExit) {
        this.explicitExit = explicitExit;
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
        String input;
        do {
            printMenu();
            int response_code;
            do {
                input = displayEntryPrompt();

                if (input.equals(exitInput)) {
                    response_code = -1;
                    break;
                }
                else {
                    entry = parseInputForEntry(input);

                    response_code = generateEntryResponseCode();

                    System.out.print('\n');
                    printEntryResponse(response_code);
                }
            } while(response_code != 0);

            if (response_code == 0)
                processValidEntry();

        } while (exitEntry != null && !(exitEntry.equals(entry) || input.equals(exitInput)) && explicitExit);
        return entry;
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

    /** Sets the body */
    protected void setBody(String body) { this.body = body; }

    /** Sets the body width */
    protected void setBodyWidth(int bodyWidth) { this.bodyWidth = bodyWidth; }

    protected void printTitle() {
        TerminalMenu.printTitle(title, titleAccentChar, bodyWidth);
    }

    protected void printBody() {
        TerminalMenu.printBody(body, bodyWidth);
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
