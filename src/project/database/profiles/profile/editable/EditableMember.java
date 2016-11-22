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

    @XmlElementWrapper(name="services_received")
    @XmlElement(name="service_received")
    private List<EditableMemberService> servicesReceived;

    public EditableMember() {
        servicesReceived = new ArrayList<>();
    }

    public EditableMember(Member member) {
        super(member);
        servicesReceived = new ArrayList<>(member.getServicesSize());
        for(int i = 0; i < member.getServicesSize(); i++)
            servicesReceived.add(new EditableMemberService(member.getServiceReceived(i)));
    }

    public List<EditableMemberService> getServicesReceived() { return servicesReceived; }

    @Override
    public Member getImmutableType() {
        ArrayList<MemberService> memberServices = new ArrayList<>(servicesReceived.size());
        for(EditableMemberService service : servicesReceived)
            memberServices.add(service.getImmutableType());

        return new Member(id, name, address.getImmutableType(), memberServices);
    }
}