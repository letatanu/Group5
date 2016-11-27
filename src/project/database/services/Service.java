package project.database.services;

import javax.xml.bind.annotation.*;

/**
 * Created by WillLe on 11/26/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="service")
public class Service {
    @XmlElement(name = "service_id")
    protected String id;

    @XmlElement(name = "title")
    protected String title;
    @XmlElement(name = "description")
    protected String des;

    @XmlElement(name = "providerID")
    protected String providerID;

    @XmlElement(name = "fee")
    protected String fee;
    Service()
    {
        id = null;
        des = null;
        providerID = null;
        fee = null;
        title = null;
    }

    Service(String id, String title, String des, String providerID, double fee)
    {
        this.id = id;
        this.des = des;
        this.providerID = providerID;
        this.fee = null;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public double getFee() {
        return Double.parseDouble(fee);
    }

    public String getDes() {
        return des;
    }

    public String getProviderID() {
        return providerID;
    }

    public String getTitle() {
        return title;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setFee(double fee) {
        this.fee = Double.toString(fee);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProviderID(String providerID) {
        providerID = providerID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void print()
    {
        System.out.println("The service " + this.title + " :");
        System.out.println(des);
        System.out.println();
    }
}

