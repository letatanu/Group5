package project.terminal;

import project.terminal.BooleanEntryMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by ashton on 15/11/16.
 */
public class ChangeConfirmationMenu extends BooleanEntryMenu {

    private HashMap<String, ValueChange> changeList;

    public ChangeConfirmationMenu() {
        super("Confirm Changes", "");
        changeList = new HashMap<>();
    }

    @Override
    public void printMenu() {
        setBody(createConfirmationBody());
        super.printMenu();
    }

    public boolean addChange(String valueName, String oldValue, String newValue) {
        if (!oldValue.equals(newValue)) {
            changeList.put(valueName, new ValueChange(oldValue, newValue));
            return true;
        }
        else
            return false;
    }

    public boolean hasChanges() {
        return !changeList.isEmpty();
    }

    private String createConfirmationBody() {
        String body = "";

        Set<String> keySet = changeList.keySet();
        for(String key : keySet) {
            ValueChange change = changeList.get(key);
            body += "\n\t" + key + ": " + change.oldValue + " -> " + change.newValue;
        }

        return body;
    }

    private static class ValueChange {
        public String oldValue;
        public String newValue;

        public ValueChange(String oldValue, String newValue) {
            this.oldValue = oldValue;
            this.newValue = newValue;
        }
    }
}
