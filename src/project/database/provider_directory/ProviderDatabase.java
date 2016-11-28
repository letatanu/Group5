package project.database.provider_directory;

import project.database.profiles.profile.ProviderService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * ProviderDatabase object to be used for
 * managing provider services.
 *
 * Created by Austin on 11/19/16.
 */
public class ProviderDatabase {

    private Services services;
    private boolean initialized = false;
    // Only need a single file to work with, since provider services shouldn't change.
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

            services = new Services();
            File servicesFile = new File(SERVICES_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(Services.class);
            Unmarshaller um = jaxbContext.createUnmarshaller();
            Services servicesUnmarshal = ((Services)um.unmarshal(servicesFile));

            System.out.println("initialize(), displaying unmarshalled services:");
            servicesUnmarshal.displayServices(); // Constructed objects aren't initializing...getServiceCode
            initialized = true;

        } catch(Exception e) {
            System.out.println("Error: SERVICES_PATH failed to load");
            e.printStackTrace();
        }
    }


    /**
     * Save state of database.
     * Note: this must be done after every state
     * change.
     */
    public void save(){
        if(initialized){
            try{
                File metaDataFile = new File(SERVICES_PATH);
                Marshaller m = JAXBContext.newInstance(Service.class).createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(services, metaDataFile);
                m.marshal(services, System.out);
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
    /*
    public ProviderService getServiceFromID(String id){

        ProviderService service = null;

        if(!id.isEmpty() && id != null && initialized){

       /* Search elements (ProviderServices) while
        * checking each service ID. When found, return
        * matched element.
        */
            /*
            int numServices = service.countServices();
            for(int i=0; i < numServices; ++i){
                // Go through and check if the ProviderType matches.
                // If it does, add it to matchedServices.

                }
            return service;
        }
        return service;
    }*/

    /**
     * Method will return a list of services accessible
     * from a given provider type, since some providers
     * have access to services that others don't.
     *
     * @param  id
     * @return ArrayList
     */
    /*
    public ArrayList<ProviderService> getServicesByProviderType(String id){
        ArrayList<ProviderService> matchedServices = null;
        if(initialized && id != null){
            int numServices = service.countServices();
            for(int i=0; i < numServices; ++i){
                // Go through and check if the ProviderType matches.
                // If it does, add it to matchedServices.
            }
        }
        return matchedServices;

    }
    */

    /**
     * Check profile database for @param and ensure there's
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
     * //@param serviceID
     * //@return boolean (yes/no)
     */
    /*
    public boolean isService(String serviceID){
        if(initialized && serviceID != null){
            //getService returns object. If returns null, service
            //doesn't exist.
            Service found = service.getService(serviceID);
            if(found != null){
                return true;
            }
        }
        return false;
    }
    */


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
