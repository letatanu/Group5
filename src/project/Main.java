package project;

import project.database.profiles.profile.Service;
import project.database.profiles.profile.editable.EditableProviderService;
import project.database.profiles.profile.editable.EditableService;
import project.database.provider_directory.ProviderDatabase;
import project.database.services.ServiceDatabase;

public final class Main {

    public static void main(String[] args) {

        ServiceDatabase p = new ServiceDatabase();

        p.initialize();

        //-----------------------------------------

        //test Adding new Service

        EditableService service = new EditableService("Hello","Saying Hello", 123);

        p.addService(service);

//-----------------------------------------------------------------


        /*
        //Test Updating an existing service

        Service service_ = new Service("1","Hello 2nd", "Saying Hello 2nd", 32423);

        EditableService service = new EditableService(service_);

        p.updateService(service);
        */

        //------------------------------------------------------------------------



        /*
        //test removing a service with specific id
        p.removeService("1");
        */

        ///-------------------------------------------


        //test providerServices
        /*
        ProviderService format

        //id = 0;
        ProviderID = null;
        serviceID = null;
        memberID = null;
        title = null;
        body = null;
        dateOfService = null;
        dateReceived = null;
        timeReceived = null;
        comments = null;
        fee = 0.0;
        */


        ProviderDatabase p_ = new ProviderDatabase();
        p_.initialize();


        //------------------------------------------------------------
        /*
            I just remind that when adding a new ProviderService, we need to check if ProviderID, Service ID, and memeberID exist. If not, we don't do the add.  
        */

        //test add new ProviderService
        EditableProviderService providerService = new EditableProviderService("123","12","2132","Test","Symptoms",214);
        p_.addService(providerService);




///------------------------------------------------------------------------------------------------------
/*
        //test Update an existing ProviderService
        EditableProviderService providerService1 = new EditableProviderService("123","12","2132","TestUpdated","SymptomsUpdated",214);
        providerService1.setId("1");
        p_.updateServiceOnDate(providerService1,"11/28/2016");

        //-------------------------------------------------------------------------
*/
/*
        //test remove an existing ProviderService
        EditableProviderService providerService2 = new EditableProviderService();
        providerService2.setId("2");
        p_.removeServiceOnDate(providerService2,"11/28/2016");
*/


    }
}