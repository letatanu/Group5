package project.database.provider_directory;

import project.database.profiles.profile.ProviderService;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;



/**
 * This class handles the operations on the
 * meta-data (xml file) for provider services. It serves
 * as the interface between "ProviderDatabase"
 * object and "services.xml".
 *
 * Note: only really need title, body, and fee
 * for the xml file.
 *
 * Created by Austin on 11/22/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="services")
public class ProviderServicesMetaData {


    @XmlElement(name="ProviderService")
    private ArrayList<ProviderService> services;

    @XmlAttribute(name="title")
    private String title;

    @XmlAttribute(name="body")
    private String body;

    @XmlAttribute(name="dateOfService")
    String dateOfService;

    @XmlAttribute(name="dateReceived")
    String dateReceived;

    @XmlAttribute(name="memberName")
    String memberName;

    @XmlAttribute(name="memberID")
    String memberID;

    @XmlAttribute(name="serviceCode")
    String serviceCode;

    @XmlAttribute(name="fee")
    Double fee;

    /*
    @XmlElementWrapper(name="providerAccess")
    @XmlAttribute(name= "provider")
    */
    //Array<int> providerAccess;

    /**
     * Functionality includes editing a service
     * that already exists in the database.
     *
     * @return modifiedService
     */
    public ProviderService editService(){
        /*
        Prompt user for input (service code).
        Search database, return/catch service that
        needs to be modified, or return fail
        if it doesn't exist.Modify the service. Once
        user is satisfied, add the modified service back
        into the list.
         */

        return null;
    }

    /**
     * Returns a corresponding service that matches
     * the service code passed in.
     *
     * @param serviceID // service id to be searched for
     * @return
     */
    public ProviderService getService(String serviceID){
        if(!services.isEmpty() && serviceID != null){
            for(int i=0; i <services.size(); ++i){
                if((services.get(i)).getServiceCode()==serviceID){
                    System.out.println("Found match in database.");
                    return services.get(i);
                }
            }
        }
        return null; // Didn't find match or bad @param.
    }

    /**
     * Returns the number of services
     * that are present in ArrayList
     * "services".
     *
     * @return services.size()
     */
    public int countServices(){
        return services.size();
    }
}


