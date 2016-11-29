package project.database.provider_directory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * ProviderDatabase object to be used for
 * managing provider data.
 *
 * Created by Austin on 11/19/16.
 */
public class ProviderDatabase {

    private Services data;
    private boolean initialized = false;
    // Only need a single file to work with, since provider data shouldn't change.
    private static final String SERVICES_PATH = "src/project/database/provider_directory/services.xml";
    //private static final String PROVIDER_DIRECTORY_PATH = "src/project/database/provider_directory/";

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
            data = new Services();
            File servicesFile = new File(SERVICES_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(Services.class);
            Unmarshaller um = jaxbContext.createUnmarshaller();
            Services servicesUnmarshal = ((Services)um.unmarshal(servicesFile));
            data = servicesUnmarshal;
            initialized = true;
        }catch(Exception e) {
            System.out.println("Error: SERVICES_PATH failed to load");
            e.printStackTrace();
        }
    }

    /**
     * Save state of database.
     * Note: this must be done after every state
     * change.
     *
     * Hasn't been tested or anything.
     */
    public void save(){
        if(initialized){
            try{
                File metaDataFile = new File(SERVICES_PATH);
                Marshaller m = JAXBContext.newInstance(Service.class).createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(data, metaDataFile);
                m.marshal(data, System.out);
            }
            catch (Exception e){
                System.out.println("Error: ProviderServiceMetaData failed to save!");
                e.printStackTrace();
            }
        }
    }

    /**
     * Will return a service corresponding to a service
     * id.
     *
     * //@param id
     * @return service
     */
    public Service getServiceFromServiceCode(String serviceCode){
        if(!serviceCode.isEmpty() && initialized) {
            return data.getService(serviceCode);
        }
        return null;
    }

    /**
     * Method will return a list of data accessible
     * from a given provider type, since some providers
     * have access to data that others don't.
     *
     * @param  type
     * @return ArrayList
     */
    // !!! This isn't working yet. !!!
    public Services getServicesByProviderType(String type){
        Services matchedServices = null;
        if(initialized && type != null){
            for(int i = 0; i < data.countServices(); ++i){
                // Go through and check if the ProviderType matches.
                // If it does, add it to matchedServices.
            }
        }
        return matchedServices;
    }

    /**
     * Check database for @param and ensure there's
     * an attribute that matches @attribute.
     *
     * @param serviceCode
     * @return boolean (yes/no)
     */
    public boolean isService(String serviceCode){
        if(initialized && serviceCode != null){
            if(data.isService(serviceCode)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns requested service from DB if it matches.
     *
     * @param serviceCode
     * @return matching service.
     */
    public Service getService(String serviceCode){
        return data.getService(serviceCode);
    }

    /**
     * (Not implemented)
     * Remove service from the DB based on serviceCode.
     * Remember: save()
     *
     * //@param serviceCode
     * //@return
     */
    /*
    public boolean removeService(String serviceCode){
        return false;
    }
    */

    /**
     * Utility to display data stored in database.
     */
    public void displayAllServices(){
        System.out.println("Displaying all data:");
        data.displayServices();
    }

    /**
     * Small test-runs for database. Remove before deployment.
     *
     */
    public static void main(String[] args) {
        /*
        Service matchedService;
        boolean validService = false;
        String validServiceCode = "000000";
        String invalidServiceCode = "x";
        */

        // Initialize db
        ProviderDatabase db = new ProviderDatabase();
        db.initialize();

        db.displayAllServices();
        // Search for valid service code
        /*
        validService = db.isService(validServiceCode);
        System.out.println("Service " + validServiceCode + " is " + validService);
        matchedService = db.getService(validServiceCode);
        if(matchedService != null){
            matchedService.display();
        }

        // Search for invalid service code
        validService = db.isService(invalidServiceCode);
        System.out.println("Service " + invalidServiceCode + " is " + validService);
        matchedService = db.getService(invalidServiceCode);
        if(matchedService != null){
            matchedService.display();
        }
        */
    }
}