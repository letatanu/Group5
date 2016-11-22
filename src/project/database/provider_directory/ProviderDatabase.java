package project.database.provider_directory;

import project.database.profiles.profile.ProviderService;

/**
 * ProviderDatabase
 * Created by Austin on 11/19/16.
 */
public class ProviderDatabase {

    //private static final String META_DATA_PATH = "src/project/database/profiles/xml/metadata.xml";
    //private static final String PROVIDER_DATA_PATH = "src/project/database/profiles/xml/";

    private boolean initialized = false;


     public ProviderService getService(){return null;}


    /**
     * Initialize database and flag INITIALIZED
     * constant so there's an indidicator on DB
     * status.
     */
    public void initialize(){

    }


    /**
     * Save state of database.
     * Note: this must be done after every state
     * change.
     */
    public void save(){


    }

    /**
     * Check database for @param and ensure there's
     * an entry for the provider.
     *
     * @param providerID
     * @return boolean (yes/no)
     */
    public boolean isProvider(String providerID){return false;}
    public boolean isService(String serviceID){ return false;}

    public ProviderService addService(ProviderService editableService){return null;}

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
    public void test(){

    }




}
