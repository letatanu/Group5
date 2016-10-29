package project.database.profiles.profile.adapted;

import project.database.profiles.profile.MemberService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Ashton on 10/28/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AdaptedMemberService {
    @XmlAttribute(name="providerName")
    private String providerName;

    @XmlAttribute(name="name")
    private String serviceName;

    @XmlElement(name="date")
    private AdaptedDate date;

    public AdaptedMemberService() {}

    public AdaptedMemberService(MemberService memberService) {
        providerName = memberService.getProvider();
        serviceName = memberService.getServiceName();
        date = new AdaptedDate(memberService.getDate());
    }

    public MemberService exportMemberService() { return new MemberService(date.exportDate(), providerName, serviceName); }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setDate(AdaptedDate date) {
        this.date = date;
    }
}
