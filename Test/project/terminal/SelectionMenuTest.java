package project.terminal;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex on 11/24/2016.
 * This object tests StringEntryMenu class and IntEntryMenu class.
 */
public class SelectionMenuTest {

    private SelectionMenu Selection_menu = new SelectionMenu("Name","Title","Body"," ");

    @Test
    public void generateEntryResponseCode() throws Exception {

        assertEquals(-1,Selection_menu.generateEntryResponseCode());
    }
    @Test
    public void parseInputForEntry() throws Exception {

        assertEquals(null, Selection_menu.parseInputForEntry(null));
    }

    @Test
    public void getStrings() throws Exception {

        assertEquals("Name",Selection_menu.getName());
        assertEquals("Title",Selection_menu.getTitle());
        assertEquals("Body",Selection_menu.getBody());
        assertEquals("Select Option",Selection_menu.getEntryPrompt());

    }
}
