package project.database.profiles.profile.editable;

import project.database.profiles.profile.Address;
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
public class EditableMember extends EditableProfile {

    @XmlElement(name="address")
    private EditableAddress address;

    @XmlElementWrapper(name="services_received")
    @XmlElement(name="service_received")
    private List<EditableMemberService> servicesReceived;

    public EditableMember() {
        servicesReceived = new ArrayList<>();
    }

    public EditableMember(Member member) {
        address = new EditableAddress(member.getAddress());
        servicesReceived = new ArrayList<>(member.getServicesSize());
        for(int i = 0; i < member.getServicesSize(); i++)
            servicesReceived.add(new EditableMemberService(member.getServiceReceived(i)));
    }

    public void setAddress(EditableAddress address) {
        this.address = address;
    }

    public void setAddress(Address address) { this.address = new EditableAddress(address); }

    public List<EditableMemberService> getServicesReceived() { return servicesReceived; }

    public Member exportMember() {
        ArrayList<MemberService> memberServices = new ArrayList<>(servicesReceived.size());
        for(EditableMemberService service : servicesReceived)
            memberServices.add(service.exportMemberService());

        return new Member(profileId, name, address.exportAddress(), memberServices);
    }
}
