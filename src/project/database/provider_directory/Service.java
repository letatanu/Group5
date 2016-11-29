package project.database.provider_directory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Austin on 11/28/16.
 */

@XmlRootElement(name="service")
@XmlAccessorType(XmlAccessType.FIELD)
public class Service {

    @XmlElement(name="serviceName")
    String serviceName;

    @XmlElement(name="serviceDescription")
    String serviceDescription;

    @XmlElement(name="serviceCode")
    String serviceCode;

    @XmlElement(name="fee")
    Double fee;

    // !!! This isn't working yet. !!!
    @XmlElement(name="providedBy")
    Set<Integer> authorizedProviders;

    // Constructors
    public Service() {
        serviceCode = null;
        serviceDescription = null;
        serviceName = null;
        fee = 00.00;
        authorizedProviders = null; // !!! This isn't working yet. !!!

    }
    public Service(String serviceCode, String serviceDescription, String comments, double fee, Set<Integer> providedBy) {
        this.serviceCode = serviceCode;
        this.serviceDescription = serviceDescription;
        this.serviceName = comments;
        this.fee = fee;
        this.authorizedProviders = new HashSet<Integer>(providedBy);
    }

    // Getters
    public String getServiceCode() {
        return serviceCode;
    }
    public String getServiceName() {
        return serviceName;
    }
    public String getServiceDescription(){
        return serviceDescription;
    }
    public double getFee() {
        return fee;
    }
    public Set<Integer> getAuthorizedProviders(){
        return authorizedProviders;
    }

    // Setters
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
    public void setServiceDescription(String serviceDescription){
        this.serviceDescription = serviceDescription;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }
    public void setAuthorizedProviders(Set<Integer> providers){
        this.authorizedProviders = new HashSet<Integer>(providers);
    }

    // Helpers
    public void display(){
        System.out.println("Service name: " + serviceName);
        System.out.println("Service description: " + serviceDescription);
        System.out.println("Authorized Providers:" + authorizedProviders);
        System.out.println("Service Code: "+ serviceCode);
        System.out.println("Fee: " + fee);
    }
}