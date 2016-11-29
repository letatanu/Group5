package project.database.profiles.profile;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex on 11/24/2016.
 */
public class ProviderServiceTest {

    private Date service = new Date(12,27,1994);
    private Date received = new Date(01,02,2016);
    private Time time = new Time(11,59,59);
    private ProviderService provider_service = new ProviderService(service,received,time,"Name","ID","Code","Comments");

    @Test
    public void getDateOfService() throws Exception {

        assertEquals(service,provider_service.getDateOfService());
    }

    @Test
    public void getDateReceived() throws Exception {

        assertEquals(received,provider_service.getDateReceived());
    }

    @Test
    public void getTimeReceived() throws Exception {

        assertEquals(time,provider_service.getTimeReceived());

    }

    @Test
    public void getMemberName() throws Exception {

        assertEquals("Name",provider_service.getMemberName());
    }

    @Test
    public void getMemberID() throws Exception {

        assertEquals("ID",provider_service.getMemberID());
    }

    @Test
    public void getServiceCode() throws Exception {

        assertEquals("Code",provider_service.getServiceCode());
    }

    @Test
    public void getComments() throws Exception {

        assertEquals("Comments",provider_service.getComments());
    }

}