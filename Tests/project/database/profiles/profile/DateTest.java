package project.database.profiles.profile;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex on 11/24/2016.
 */
public class DateTest {

    private Date date = new Date(12,27,1994);

    @Test
    public void getMonth() throws Exception {

        assertEquals(12, date.getMonth());
    }

    @Test
    public void getDay() throws Exception {

        assertEquals(27, date.getDay());
    }

    @Test
    public void getYear() throws Exception {

        assertEquals(1994, date.getYear());
    }

    @Test
    public void ToString() throws Exception {

        assertEquals("12/27/1994", date.toString());
    }

}