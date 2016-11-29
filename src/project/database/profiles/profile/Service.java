package project.database.profiles.profile;

import project.database.profiles.profile.ImmutableType;

import project.database.profiles.profile.editable.EditableService;
import javax.xml.bind.annotation.*;

/**
 * Created by WillLe on 11/26/16.
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name="service")
public final class Service implements ImmutableType {
   // @XmlAttribute(name = "id")
    protected String id;

   // @XmlElement(name = "title")
    protected String title;

    //@XmlElement(name = "description")
    protected String des;


  //  @XmlElement(name = "fee")
    protected Double fee;
    Service()
    {
        id = null;
        des = null;
        fee = null;
        title = null;
    }

    public Service(String id, String title, String des, double fee)
    {
        this.id = id;
        this.des = des;
        this.fee = fee;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public double getFee() {
        return fee;
    }

    public String getDes() {
        return des;
    }


    public String getTitle() {
        return title;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setTitle(String title) {
        this.title = title;
    }
/*
    public void print()
    {
        System.out.println("The service " + this.title + " :");
        System.out.println(des);
        System.out.println("------------------");
    }*/
    @Override
    public EditableService getEditableType() { return new EditableService(this); }
}

