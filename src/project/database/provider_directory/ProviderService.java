package project.database.provider_directory;

//import project.database.profiles.profile.Date;
import project.database.profiles.profile.ImmutableType;
import project.database.profiles.profile.editable.EditableProviderService;

import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by ahunger on 11/20/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ProviderService")
public final class ProviderService implements ImmutableType {

    @XmlAttribute(name="id")
    protected String id;

    @XmlElement(name="ProviderID")
    protected String ProviderID;

    @XmlElement(name="serviceID")
    protected String serviceID;

    @XmlElement(name="memberID")
    protected String memberID;

    @XmlElement(name="title")
    protected String title;

    @XmlElement(name="body")
    protected String body;

    @XmlElement(name="dateOfService")
    protected String dateOfService;

    @XmlElement(name="dateReceived")
    protected String dateReceived;

    @XmlElement(name="timeReceived")
    protected String timeReceived;

    @XmlElement(name="comments")
    protected String comments;

    @XmlElement(name="fee")
    protected Double fee;

    public ProviderService()
    {
        id = null;
        ProviderID = null;
        serviceID = null;
        memberID = null;
        title = null;
        body = null;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");

        Date date = new Date();
        String Date = dateFormat.format(date);
        System.out.println(date.getTime());
        // String Time = Long.toString();
        this.dateOfService = Date;
        this.dateReceived = Date;
        long t2 = System.currentTimeMillis();
        this.timeReceived = ((t2 / 1000 / 60 / 60)-8)%24 + ":" + (t2 / 1000 / 60) % 60 + ":" + (t2 / 1000) % 60;
        comments = null;
        fee = 0.0;
    }
    public ProviderService(String serviceID, String memberID, String title, String body, String comments, double fee)
    {
        this.ProviderID = ProviderID;
        this.serviceID = serviceID;
        this.memberID= memberID;
        this.title = title;
        this.body = body;
        //set current date
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");

        Date date = new Date();
        String Date = dateFormat.format(date);
        System.out.println(date.getTime());
       // String Time = Long.toString();
        this.dateOfService = Date;
        this.dateReceived = Date;
        long t2 = System.currentTimeMillis();
        this.timeReceived = ((t2 / 1000 / 60 / 60)-8)%24 + ":" + (t2 / 1000 / 60) % 60 + ":" + (t2 / 1000) % 60;
        this.comments = comments;
        this.fee = fee;
    }
    public ProviderService(String id, String ProviderID, String serviceID, String memberID, String title, String body, String dateOfService, String dateReceived, String timeReceived, String comments, double fee) {
        this.id = id;
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


    //setter

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

    @Override
    public EditableProviderService getEditableType() { return new EditableProviderService(this); }
}
