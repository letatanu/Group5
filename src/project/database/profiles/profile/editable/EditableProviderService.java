package project.database.profiles.profile.editable;

//import project.database.profiles.profile.Date;
import project.database.provider_directory.ProviderService;

import javax.xml.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ashton on 11/21/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ProviderService")
public class EditableProviderService implements EditableType {
    @XmlAttribute(name="id")
    private String id;

    @XmlElement(name="ProviderID")
    private String ProviderID;

    @XmlElement(name="serviceID")
    private String serviceID;

    @XmlElement(name="memberID")
    private String memberID;

    @XmlElement(name="title")
    private String title;

    @XmlElement(name="body")
    private String body;

    @XmlElement(name="dateOfService")
    private String dateOfService;

    @XmlElement(name="dateReceived")
    private String dateReceived;

    @XmlElement(name="timeReceived")
    private String timeReceived;

    @XmlElement(name="comments")
    private String comments;

    @XmlElement(name="fee")
    private Double fee;

    public EditableProviderService() {
        id = null;
        ProviderID = null;
        serviceID = null;
        memberID = null;
        title = null;
        body = null;
        dateOfService = null;
        dateReceived = null;
        timeReceived = null;
        comments = null;
        fee = 0.0;
    }

    public EditableProviderService(ProviderService providerService) {
        id = providerService.getId();
        ProviderID = providerService.getProviderID();
        serviceID = providerService.getServiceID();
        memberID = providerService.getMemberID();
        title = providerService.getTitle();
        body = providerService.getBody();
        dateOfService = providerService.getDateOfService().toString();
        dateReceived = providerService.getDateReceived().toString();
        timeReceived = providerService.getTimeReceived().toString();
        comments = providerService.getComments();
        fee = providerService.getFee();
    }

    public EditableProviderService(String ProviderID, String serviceID, String memberID, String title, String body, String dateOfService, String dateReceived, String timeReceived, String comments, double fee)
    {
        this.ProviderID = ProviderID;
        this.serviceID = serviceID;
        this.memberID= memberID;
        this.title = title;
        this.body = body;
        this.dateOfService = dateOfService;
        this.dateReceived = dateReceived;
        this.timeReceived = timeReceived;
        this.comments = comments;
        this.fee = fee;
    }

    public EditableProviderService(String serviceID, String memberID, String title, String body, String comments, double fee)
    {
        this.ProviderID = ProviderID;
        this.serviceID = serviceID;
        this.memberID= memberID;
        this.title = title;
        this.body = body;
        //get current date
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
       // DateFormat time = new SimpleDateFormat(":mm:ss");
        Date date = new Date();
        String Date = dateFormat.format(date);
        String Time = Long.toString(date.getTime());
        this.dateOfService = Date;
        this.dateReceived = Date;
        long t2 = System.currentTimeMillis();
        this.timeReceived = ((t2 / 1000 / 60 / 60)-8)%24 + ":" + (t2 / 1000 / 60) % 60 + ":" + (t2 / 1000) % 60;
        this.comments = comments;
        this.fee = fee;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setDateOfService(String dateOfService) {
        this.dateOfService = dateOfService;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public void setTimeReceived(String timeReceived) {
        this.timeReceived = timeReceived;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //getter
    @XmlTransient

    public String getId() {
        return id;
    }

    public String getProviderID() {
        return ProviderID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getDateOfService() {
        return dateOfService;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public String getTimeReceived() {
        return timeReceived;
    }
    public String getComments() { return comments; }

    public Double getFee() {
        return fee;
    }

    @Override
    public ProviderService getImmutableType() {
        return new ProviderService(id, ProviderID, serviceID, memberID, title, body, dateOfService, dateReceived, timeReceived, comments, fee);
    }
}
