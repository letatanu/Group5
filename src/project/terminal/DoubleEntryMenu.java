package project.terminal;

/**
 * DoubleEntryMenu - An abstract class which narrows the scope of the TerminalMenu to just the Double Type
 *
 * Created by Ashton on 10/17/2016.
 */
public abstract class DoubleEntryMenu extends SingleLineEntryMenu<Double> {

    public DoubleEntryMenu(String name, String title, String body, String entryPrompt) {
        super(name, title, body, entryPrompt);
    }

    /**
     * Parses the input for a Double
     *
     * @param input - raw input from the user
     *
     * @return entry - Double parsed from input, or null if a parsable double does not exist in the input
     */
    @Override
    protected Double parseInputForEntry(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
