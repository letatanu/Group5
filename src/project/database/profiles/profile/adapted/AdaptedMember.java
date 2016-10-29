package project.database.profiles.profile.adapted;

import project.database.profiles.profile.Member;
import project.database.profiles.profile.MemberService;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashton on 27/10/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="member_profile")
public class AdaptedMember extends AdaptedProfile {

    @XmlElement(name="address")
    private AdaptedAddress address;

    @XmlElementWrapper(name="services_received")
    @XmlElement(name="service_received")
    private List<AdaptedMemberService> servicesReceived;

    public AdaptedMember() {}

    public AdaptedMember(Member member) {
        address = new AdaptedAddress(member.getAddress());
        servicesReceived = new ArrayList<>(member.getServicesSize());
        for(int i = 0; i < member.getServicesSize(); i++)
            servicesReceived.add(new AdaptedMemberService(member.getServiceReceived(i)));
    }

    public Member exportMember() {
        ArrayList<MemberService> memberServices = new ArrayList<>(servicesReceived.size());
        for(AdaptedMemberService service : servicesReceived)
            memberServices.add(service.exportMemberService());

        return new Member(profileId, name, address.exportAddress(), memberServices);
    }
}
