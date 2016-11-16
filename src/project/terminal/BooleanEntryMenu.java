package project.terminal;

import project.terminal.SingleLineEntryMenu;

/**
 * Created by Ashton on 11/15/2016.
 */
public class BooleanEntryMenu extends SingleLineEntryMenu<Boolean> {

    private static final String DEFAULT_TRUE_OPTION = "Yes";
    private static final String DEFAULT_FALSE_OPTION = "No";

    private String trueOption = DEFAULT_TRUE_OPTION;
    private String falseOption = DEFAULT_FALSE_OPTION;

    public BooleanEntryMenu(String title, String body) {
        super("", title, body, "Selection");
    }

    public BooleanEntryMenu(String title, String body, String trueOption, String falseOption) {
        super("", title, body, "Selection");
        this.trueOption = trueOption;
        this.falseOption = falseOption;
    }

    @Override
    public void printMenu() {
        printTitle(getTitle(), titleAccentChar, bodyWidth);
        System.out.println('\n' + getBody() + '\n');
        System.out.println("\t1) " + trueOption);
        System.out.println("\t2) " + falseOption);
    }

    @Override
    protected Boolean parseInputForEntry(String input) {
        Boolean entry = null;
        if (input != null) {
            try {
                Integer selection = Integer.parseInt(input);
                switch (selection) {
                    case 1:
                        entry = true;
                        break;
                    case 2:
                        entry = false;
                        break;
                }
            } catch (NumberFormatException e) {}
        }

        return entry;
    }

    @Override
    protected int generateEntryResponseCode() {
        if (entry == null)
            return -1;
        else
            return 0;
    }

    @Override
    protected void printEntryResponse(int responseCode) {
        if (responseCode == -1)
            System.out.println("Selection must be either (1) for \"" + trueOption + "\" or (2) for \"" + falseOption + '\"');
    }
}
