package project.database.provider_directory;

import project.database.profiles.profile.ProviderService;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;



/**
 * This class handles the operations on the
 * meta-data (xml file) for provider services. It serves
 * as the interface between "ProviderDatabase"
 * object and "id.xml".
 *
 * Note: only really need title, body, and fee
 * for the xml file.
 *
 * Created by Austin on 11/22/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ProviderServiceList")
public class ProviderServicesMetaData {

    @XmlElementWrapper(name="Date")
    @XmlAttribute(name="name")
    private String Date;
    @XmlElementWrapper(name="Date")
    @XmlElement(name="ProviderServiceID")
    private ArrayList<String> serviceIDs;



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
      // service id to be searched for

     */
    public boolean isProviderService(String providerServiceID){
        if(!serviceIDs.isEmpty() && providerServiceID != null){
            for(int i=0; i <serviceIDs.size(); ++i){
                if(serviceIDs.get(i).equals(providerServiceID)){
                    //System.out.println("Found match in database.");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the number of services
     * that are present in ArrayList
     * "services".
     *
     * @return services.size()
     */
}


