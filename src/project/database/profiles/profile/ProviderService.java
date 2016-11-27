package project.database.profiles.profile;

//import project.database.profiles.profile.Date;
import project.database.profiles.profile.ImmutableType;
import project.database.profiles.profile.Time;
import project.database.profiles.profile.editable.EditableProviderService;
import project.database.profiles.profile.editable.EditableType;

import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by ahunger on 11/20/2016.
 */
public final class ProviderService implements ImmutableType{

   // @XmlAttribute(name="ProviderServiceID")
    private String providerServiceID;

  //  @XmlAttribute(name="memberID")
    private String memberID;

  //  @XmlAttribute(name="title")
    private String title;

   // @XmlAttribute(name="body")
    private String body;

   // @XmlElement(name="ServiceID")
    private String serviceID;

   // @XmlAttribute(name="dateOfService")
    private String dateOfService;

  //  @XmlAttribute(name="dateReceived")
    private String dateReceived;

  //  @XmlAttribute(name="timeReceived")
    private String timeReceived;

   // @XmlAttribute(name="comments")
    private String comments;

   // @XmlAttribute(name="fee")
    private Double fee;

    public ProviderService(String title, String body, String dateOfService, String dateReceived, String memberID, String serviceID, String comments, double fee, String timeReceived) {
        this.title = title;
        this.body = body;
        this.fee = fee;
        this.dateOfService = dateOfService;
        this.dateReceived = dateReceived;
        this.memberID = memberID;
        this.serviceID = serviceID;
        this.comments = comments;
        this.timeReceived = timeReceived;
    }

    public String getProviderServiceID() {
        return providerServiceID;
    }

    public Date getDateOfService() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date dateService = null;
        try {
             dateService = df.parse(this.dateOfService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateService; }

    public Date getDateReceived() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date dateReceived = null;
        try {
            dateReceived = df.parse(this.dateOfService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateReceived; }

    public Date getTimeReceived() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date timeReceived = null;
        try {
            timeReceived = sdf.parse(this.timeReceived);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeReceived;
    }

    public Double getFee() {
        return fee;
    }

    public String getMemberID() { return memberID; }

    public String getComments() { return comments; }

    public String getServiceID(){ return serviceID;}

    @Override
    public EditableProviderService getEditableType() { return new EditableProviderService(this); }
}
