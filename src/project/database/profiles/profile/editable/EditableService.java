package project.database.profiles.profile.editable;
import project.database.profiles.profile.Service;

import javax.xml.bind.annotation.*;

/**
 * I started this but I'm not familiar with XML. I'll probably
 * come back to this later.
 * Created by Austin on 11/19/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="service")
public class EditableService implements EditableType{

    @XmlAttribute(name = "id")
    protected String id;

    @XmlElement(name = "title")
    protected String title;

    @XmlElement(name = "description")
    protected String des;


    @XmlElement(name = "fee")
    protected Double fee;
    EditableService()
    {
        id = null;
        des = null;
        fee = null;
        title = null;
    }
    public EditableService(Service service)
    {
        this.id = service.getId();
        this.des = service.getDes();
        this.fee = service.getFee();
        this.title = service.getTitle();
    }

    public EditableService(String title, String des, double fee)
    {
        this.des = des;
        this.fee = fee;
        this.title = title;
    }

   //setter

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


    public void print()
    {
        System.out.println("The service " + this.title + " :");
        System.out.println(des);
        System.out.println("------------------");
    }

    //getter
    @XmlTransient
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
    @Override
    public Service getImmutableType() {
        return new Service(id, title, des, fee);
    }



}
