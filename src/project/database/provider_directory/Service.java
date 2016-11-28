package project.database.provider_directory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Austin on 11/28/16.
 */

//@XmlElementWrapper(name="service")
//@XmlElement(name="service")
@XmlRootElement(name="service")
@XmlAccessorType(XmlAccessType.FIELD)
public class Service {

    @XmlElement(name="serviceName")
    String serviceName;

    @XmlElement(name="serviceCode")
    String serviceCode;

    @XmlElement(name="fee")
    Double fee;


    // Constructors
    public Service() {
        serviceCode = null;
        serviceName = null;
        fee = 00.00;
    }
    public Service(String serviceCode, String comments, double fee) {
        this.serviceCode = serviceCode;
        this.serviceName = comments;
        this.fee = fee;
    }

    // Getters
    public String getServiceCode() {
        return serviceCode;
    }
    public String getServiceName() {
        return serviceName;
    }
    public double getFee() {
        return fee;
    }

    // Setters
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }

    // Helpers
    public void displaySelf(){
        System.out.println("Service name: " + serviceName);
        System.out.println("Service Code: "+ serviceCode);
        System.out.println("Fee: " + fee);
    }

}
