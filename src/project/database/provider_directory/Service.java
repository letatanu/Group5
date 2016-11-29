package project.database.provider_directory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Austin on 11/28/16.
 */

@XmlRootElement(name="service")
@XmlAccessorType(XmlAccessType.FIELD)
public class Service {

    @XmlElement(name="serviceName")
    private String serviceName;

    @XmlElement(name="serviceDescription")
    private String serviceDescription;

    @XmlElement(name="serviceCode")
    private String serviceCode;

    @XmlElement(name="fee")
    private Double fee;

    // !!! This isn't working yet. !!!
    @XmlElement(name="authorizedProviders")
    private AuthorizedProviders authorizedProviders;

    // Constructors
    public Service() {
        serviceCode = null;
        serviceDescription = null;
        serviceName = null;
        fee = 00.00;
        //authorizedProviders = null; // !!! This isn't working yet. !!!

    }

    public Service(String serviceCode, String serviceDescription, String comments, double fee) {
        this.serviceCode = serviceCode;
        this.serviceDescription = serviceDescription;
        this.serviceName = comments;
        this.fee = fee;
        //this.authorizedProviders = new ArrayList<String>(providedBy);
    }
    /*
    public Service(String serviceCode, String serviceDescription, String comments, double fee, ArrayList<String> providedBy) {
        this.serviceCode = serviceCode;
        this.serviceDescription = serviceDescription;
        this.serviceName = comments;
        this.fee = fee;
        //this.authorizedProviders = new ArrayList<String>(providedBy);
    }
    */
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
    public AuthorizedProviders getAuthorizedProviders(){
        return authorizedProviders;
    }
    /*
    public ArrayList<String> getAuthorizedProviders(){
        return authorizedProviders;
    }
    */

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
    public void setAuthorizedProviders(AuthorizedProviders providers){
        this.authorizedProviders = new AuthorizedProviders();
    }

    // Helper, shouldn't actually be used in the program.
    public void display(){
        System.out.println("Service name: " + serviceName);
        System.out.println("Service description: " + serviceDescription);
        System.out.println("Authorized Providers:");
        if(authorizedProviders != null){
            ArrayList<String> providers = authorizedProviders.getProviders();
            for(int i = 0; i < providers.size(); ++i){
                System.out.println("    Authorized Provider Type: " + providers.get(i));
            }
        }
        System.out.println("Service Code: "+ serviceCode);
        System.out.println("Fee: " + fee);
    }

    /**
     * Can be used as a helper function
     * to display a service data in
     * formatted way. Table?
     * (not implemented)
     *
     */
    public void formattedDisplay(){
        // int FIXED_WIDTH = 80; // not used

    }
}