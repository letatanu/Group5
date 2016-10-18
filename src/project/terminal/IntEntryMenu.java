package project.terminal;

/**
 * DoubleEntryMenu - An abstract class which narrows the scope of the TerminalMenu to just the Integer Type
 *
 * Created by Ashton on 10/16/2016.
 */
public abstract class IntEntryMenu extends TerminalMenu<Integer> {

    //Constructor
    public IntEntryMenu(String name, String title, String body, String entryPrompt) {
        super(name, title, body, entryPrompt);
    }

    /**
     * Parses the input for an Integer
     *
     * @param input - raw input from the user
     *
     * @return entry - Integer parsed from input, or null if a parsable integer does not exist in the input
     */
    @Override
    protected Integer parseInputForEntry(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
