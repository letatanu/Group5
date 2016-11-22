package project.terminal;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex on 11/21/2016.
 * Simple representation of what Unit Test supposed to do.
 * This object tests StringEntryMenu class.
 */
public class StringEntryMenuTest {

    private StringEntryMenu StringMenu = new StringEntryMenu("Menu name", "Menu body", "Menu prompt", " ",1,100);

    @Test
    public void parseInputForEntry() throws Exception {

        assertEquals("input", StringMenu.parseInputForEntry("input"));
    }

    @Test
    public void generateEntryResponseCode() throws Exception {

        assertEquals(-1,StringMenu.generateEntryResponseCode());
    }

    @Test
    public void getStrings() throws Exception {

        assertEquals("Menu name",StringMenu.getName());
        assertEquals("",StringMenu.getTitle());
        assertEquals("Menu body",StringMenu.getBody());
        assertEquals("Menu prompt",StringMenu.getEntryPrompt());
    }

}