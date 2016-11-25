package project.database.profiles.profile;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex on 11/24/2016.
 */
public class AddressTest {


    private Address address = new Address("Street","City","State","Zip");

    @Test
    public void getStreetAddress() throws Exception {

        assertEquals("Street",address.getStreetAddress());
    }

    @Test
    public void getCity() throws Exception {

        assertEquals("City",address.getCity());
    }

    @Test
    public void getState() throws Exception {

        assertEquals("State",address.getState());
    }

    @Test
    public void getZip() throws Exception {

        assertEquals("Zip",address.getZip());
    }

}