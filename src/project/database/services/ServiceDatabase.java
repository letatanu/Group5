package project.database.services;


import project.database.profiles.profile.Service;
import project.database.profiles.profile.editable.EditableService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by WillLe on 11/26/16.
 */

public class ServiceDatabase {
    private static final String META_DATA_PATH = "src/project/database/services/xml/metadata.xml";
    private static final String Service_DATA_PATH = "src/project/database/services/xml/";

    private boolean initialized = false;
    private ServiceMetaData metaData;

    public void initialize(){
        try {
            File metaDataFile = new File(META_DATA_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(ServiceMetaData.class);
            Unmarshaller um = jaxbContext.createUnmarshaller();
            metaData = ((ServiceMetaData)um.unmarshal(metaDataFile));
            initialized = true;
            // System.out.println("Number of services initialized: " + metaData.countServices());

        } catch(Exception e) {
            System.out.println("Error: META_DATA_PATH failed to load");
            e.printStackTrace();
        }
    }
    //Adding new service
    public Service addService(EditableService editableService) {

        Service service = null;
        if (editableService != null && initialized)
        {
            String ID = metaData.getServices().lastElement();
            int id = Integer.getInteger(ID) + 1;
            ID = Integer.toString(id);
            editableService.setId(ID);
            service = editableService.getImmutableType();

            metaData.addService(service);

            try {
                File memberFile = new File(Service_DATA_PATH + ID + ".xml");
                Marshaller m = JAXBContext.newInstance(EditableService.class).createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(editableService, memberFile);
                m.marshal(editableService, System.out);
                //update file metadata
                save();
            } catch (Exception e) {
                System.out.println("Error: Service failed to save!");
                e.printStackTrace();
            }
        }
        return service;
    }
    //updating an existing service
    public boolean updateService(EditableService editableService) {
        if (editableService != null && initialized && isService(editableService.getId()) !=-1) {
            try {
                File serviceFile = new File(Service_DATA_PATH + editableService.getId() + ".xml");
                Marshaller m = JAXBContext.newInstance(EditableService.class).createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(editableService, serviceFile);
                m.marshal(editableService, System.out);
            } catch (Exception e) {
                System.out.println("Error: Service failed to update!");
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public boolean removeService(String id) {
        if (id != null && isService(id) != 1) {
            metaData.removeService(id);
            save();
            try
            {
                File serviceFile = new File(Service_DATA_PATH + id + ".xml");
                if(serviceFile.delete())
                {

                    System.out.println(serviceFile.getName() + " is deleted!");
                    return true;
                }
                else
                {
                    System.out.println("Delete operation is failed.");
                    return false;
                }
            } catch (Exception e)
            {
                System.out.println("Error: Service failed to remove!");
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    //Update metadata
    public void save() {
        if (initialized) {
            try {
                //JAXBContext jc = JAXBContext.newInstance(ServiceMetaData.class);
                File metaDataFile = new File(META_DATA_PATH);
                Marshaller m = JAXBContext.newInstance(ServiceMetaData.class).createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(metaData, metaDataFile);
                m.marshal(metaData, System.out);
            } catch (Exception e) {
                System.out.println("Error: ServiceMetaData failed to save!");
                e.printStackTrace();
            }
        }
    }

    //this function check if Service exists. If it does, return the index in metaData. If not, return -1.
    public int isService(String serviceID) {
        if (initialized)
            return metaData.isService(serviceID);
        else
            return -1;
    }
}
