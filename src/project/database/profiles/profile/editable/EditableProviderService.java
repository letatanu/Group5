package project.database.profiles.profile.editable;

//import project.database.profiles.profile.Date;
import project.database.profiles.profile.ProviderService;
import project.database.profiles.profile.Time;

import javax.xml.bind.annotation.*;
import java.util.Date;
/**
 * Created by Ashton on 11/21/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EditableProviderService implements EditableType {
   /* @XmlAttribute(name = "member_name")
    private String memberName;*/
    @XmlAttribute(name="ProviderServiceID")
   private String providerServiceID;

    @XmlAttribute(name="memberID")
    private String memberID;

    @XmlAttribute(name="title")
    private String title;

    @XmlAttribute(name="body")
    private String body;

    @XmlElement(name="ServiceID")
    private String serviceID;

    @XmlAttribute(name="dateOfService")
    private String dateOfService;

    @XmlAttribute(name="dateReceived")
    private String dateReceived;

    @XmlAttribute(name="timeReceived")
    private String timeReceived;

    @XmlAttribute(name="comments")
    private String comments;

    @XmlAttribute(name="fee")
    private Double fee;

    public EditableProviderService() {
        providerServiceID = null;
        title = null;
        body = null;
        dateOfService = null;
        dateReceived = null;
        timeReceived = null;
       // memberName = null;
        memberID = null;
        serviceID = null;
        comments = null;
        fee = 0.0;
    }

    public EditableProviderService(ProviderService providerService) {
        providerServiceID =
        dateOfService = providerService.getDateOfService().toString();
        dateReceived = providerService.getDateReceived().toString();
        timeReceived = providerService.getTimeReceived().toString();
        //memberName = providerService.getMemberName();
        memberID = providerService.getMemberID();
        serviceID = providerService.getServiceID();
        comments = providerService.getComments();
    }

    public void setDateOfService(String dateOfService) { this.dateOfService = dateOfService; }

    public void setDateReceived(String dateReceived) { this.dateReceived = dateReceived; }

    public void setTimeReceived(String timeReceived) { this.timeReceived = timeReceived; }

   // public void setMemberName(String memberName) { this.memberName = memberName; }

    public void setMemberID(String memberID) { this.memberID = memberID; }

    public void setServiceCode(String serviceCode) { this.serviceID = serviceID; }

    public void setComments(String comments) { this.comments = comments; }

    @XmlTransient

    public String getProviderServiceID() {return providerServiceID;}

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getMemberID() { return memberID; }

    public String getServiceID() { return serviceID; }

    public String getDateOfService() { return dateOfService; }

    public String getDateReceived() { return dateReceived; }

    public String getTimeReceived() { return timeReceived; }

    public String getComments() { return comments; }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    @Override
    public ProviderService getImmutableType() {
        return new ProviderService(title,body, dateOfService, dateReceived,memberID,serviceID,comments,fee,timeReceived );
    }
}
