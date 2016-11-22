package project.database.profiles.profile.editable;

import project.database.profiles.profile.Date;
import project.database.profiles.profile.ImmutableType;
import project.database.profiles.profile.ProviderService;
import project.database.profiles.profile.Time;

import javax.xml.bind.annotation.*;

/**
 * Created by Ashton on 11/21/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EditableProviderService implements EditableType {
    @XmlAttribute(name = "member_name")
    private String memberName;
    @XmlAttribute(name = "member_ID")
    private String memberID;
    @XmlAttribute(name = "service_code")
    private String serviceCode;

    @XmlElement(name = "date_of_service")
    private EditableDate dateOfService;
    @XmlElement(name = "date_received")
    private EditableDate dateReceived;
    @XmlElement(name = "time_received")
    private EditableTime timeReceived;
    @XmlElement(name = "comments")
    private String comments;

    public EditableProviderService() {
        dateOfService = null;
        dateReceived = null;
        timeReceived = null;
        memberName = null;
        memberID = null;
        serviceCode = null;
        comments = null;
    }

    public EditableProviderService(ProviderService providerService) {
        dateOfService = new EditableDate(providerService.getDateOfService());
        dateReceived = new EditableDate(providerService.getDateReceived());
        timeReceived = new EditableTime(providerService.getTimeReceived());
        memberName = providerService.getMemberName();
        memberID = providerService.getMemberID();
        serviceCode = providerService.getServiceCode();
        comments = providerService.getComments();
    }

    public void setDateOfService(EditableDate dateOfService) { this.dateOfService = dateOfService; }

    public void setDateReceived(EditableDate dateReceived) { this.dateReceived = dateReceived; }

    public void setTimeReceived(EditableTime timeReceived) { this.timeReceived = timeReceived; }

    public void setMemberName(String memberName) { this.memberName = memberName; }

    public void setMemberID(String memberID) { this.memberID = memberID; }

    public void setServiceCode(String serviceCode) { this.serviceCode = serviceCode; }

    public void setComments(String comments) { this.comments = comments; }

    @XmlTransient
    public String getMemberName() { return memberName; }

    public String getMemberID() { return memberID; }

    public String getServiceCode() { return serviceCode; }

    public EditableDate getDateOfService() { return dateOfService; }

    public EditableDate getDateReceived() { return dateReceived; }

    public EditableTime getTimeReceived() { return timeReceived; }

    public String getComments() { return comments; }

    @Override
    public ProviderService getImmutableType() {
        return new ProviderService(new Date(dateOfService.getMonth(), dateOfService.getDay(), dateOfService.getYear()),
                new Date(dateReceived.getMonth(), dateReceived.getDay(), dateReceived.getYear()),
                new Time(timeReceived.getHours(), timeReceived.getMinutes(), timeReceived.getSeconds()),
                memberName, memberID, serviceCode, comments);
    }
}
