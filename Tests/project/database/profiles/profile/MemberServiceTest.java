package project.database.profiles.profile;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex on 11/24/2016.
 */
public class MemberServiceTest {

    private Date date = new Date(12,27,1994);
    private MemberService member_service = new MemberService(date,"provider","service name");

    @Test
    public void getDate() throws Exception {

        assertEquals(date, member_service.getDate());
    }

    @Test
    public void getProvider() throws Exception {

        assertEquals("provider", member_service.getProvider());
    }

    @Test
    public void getServiceName() throws Exception {

        assertEquals("service name", member_service.getServiceName());
    }

}