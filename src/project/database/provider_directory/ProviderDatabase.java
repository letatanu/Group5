package project.database.provider_directory;

import project.database.profiles.profile.ProviderService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

/**
 * ProviderDatabase object to be used for
 * managing provider services.
 *
 * Created by Austin on 11/19/16.
 */
public class ProviderDatabase {

    private boolean initialized = false;
    // Only need a single file to work with, since provider services shouldn't change.
    private static String META_DATA_PATH = "src/project/database/provider_directory/xml/metadata.xml";
    private static String PROVIDER_DIRECTORY_PATH = "src/project/database/provider_directory/xml/";

    private ProviderServicesMetaData metaData;
    //private ArrayList<ProviderService> servicesList;

    /**
     * Initialize database and flag INITIALIZED
     * constant so there's an indidicator on DB
     * status.
     *
     * @return true on success.
     * @return false on failure.
     */
    public void initialize(){
        try {
            File metaDataFile = new File(META_DATA_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(ProviderServicesMetaData.class);
            Unmarshaller um = jaxbContext.createUnmarshaller();
            metaData = ((ProviderServicesMetaData)um.unmarshal(metaDataFile));
            initialized = true;
           // System.out.println("Number of services initialized: " + metaData.countServices());

        } catch(Exception e) {
            System.out.println("Error: META_DATA_PATH failed to load");
            e.printStackTrace();
        }
    }

    /**
     * Save state of database.
     * Note: this must be done after every state
     * change.
     */
    public void save(){

    }

    /**
     * Will return a service corresponding to a service
     * id.
     *
     * @param id
     * @return service
     */
    public ProviderService getServiceFromID(String id){

        ProviderService service = null;

        if(!id.isEmpty() && id != null && initialized){

       /* Search elements (ProviderServices) while
        * checking each service ID. When found, return
        * matched element.
        */
            return service;
        }

        return service;
    }

    /**
     * Method will return a list of services accessible
     * from a given provider type, since some providers
     * have access to services that others don't.
     *
     * @param  id
     * @return ArrayList
     */
    public ArrayList<ProviderService> getServicesByProviderType(String id){

        return null;
    }


    /**
     * Check database for @param and ensure there's
     * an entry for the provider.
     *
     * @param providerID
     * @return boolean (yes/no)
     */
    public boolean isProvider(String providerID){return false;}

    /**
     * Check database for @param and ensure there's
     * an attribute that matches @attribute.
     *
     * @param serviceID
     * @return boolean (yes/no)
     */
    public boolean isService(String serviceID){ return false;}


    /**
     * Returns the (final) service that was added to database.
     *
     * @param editableService
     * @return
     */
    public ProviderService addService(ProviderService editableService){

        return null;
    }


    /**
     * Returns requested service from DB if it matches.
     *
     * @param serviceID
     * @return matching service.
     */
    public ProviderService getService(String serviceID){

        ProviderService matchedService = null;
        return matchedService;
    }


    public boolean removeService(String serviceID){

        return false;
    }


    /**
     * Small test-runs for database. Remove before deployment.
     *
     */
    public static void main(String[] args) {

        ProviderDatabase db = new ProviderDatabase();
        db.initialize();

    }
}
