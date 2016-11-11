package project.database.profiles.profile.editable;

import project.database.profiles.profile.MemberService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Ashton on 10/28/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EditableMemberService {
    @XmlAttribute(name="providerName")
    private String providerName;

    @XmlAttribute(name="name")
    private String serviceName;

    @XmlElement(name="date")
    private EditableDate date;

    public EditableMemberService() {}

    public EditableMemberService(MemberService memberService) {
        providerName = memberService.getProvider();
        serviceName = memberService.getServiceName();
        date = new EditableDate(memberService.getDate());
    }

    public MemberService exportMemberService() { return new MemberService(date.exportDate(), providerName, serviceName); }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setDate(EditableDate date) {
        this.date = date;
    }
}
