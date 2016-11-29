package project.database.provider_directory;

import project.database.profiles.profile.editable.EditableProviderService;
import project.database.profiles.profile.ProviderServices;
import project.database.profiles.profile.editable.EditableProviderServices;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InterruptedIOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

    private ProviderServicesMetaData metaData = new ProviderServicesMetaData();
    private EditableProviderServices providerServicesData = new EditableProviderServices();



        /////Date test
    private String DateTest = "11_28_2016";
    private String DateTestMetaData = "11/28/2016";
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
    //initialize the ProviderSerivces on a specific date
    public boolean initializeProviderServicesOnDate(String date) {
        boolean initialized_ = false;
        File providerServicesDataFile = new File(PROVIDER_DIRECTORY_PATH + date + ".xml");
        System.out.println(PROVIDER_DIRECTORY_PATH + date + ".xml");
        //Check if the file exists.
        if (providerServicesDataFile.exists() && !providerServicesDataFile.isDirectory()) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(EditableProviderServices.class);
                Unmarshaller um = jaxbContext.createUnmarshaller();
                providerServicesData = ((EditableProviderServices) um.unmarshal(providerServicesDataFile));
                initialized_ = true;
                System.out.println(PROVIDER_DIRECTORY_PATH + date + ".xml");
                // System.out.println("Number of services initialized: " + metaData.countServices());

            } catch (Exception e) {
                System.out.println("Error: PROVIDER_DIRECTORY_PATH failed to load");
                //  e.printStackTrace();
            }

        }
        return initialized_;
    }
    //add new current ProviderService
    public ProviderService addService(EditableProviderService editableProviderService) {

        ProviderService providerService = null;
        if (editableProviderService != null && initialized)
        {
            //get current date
            DateFormat dateFormatMetaData = new SimpleDateFormat("MM/dd/YYYY");
            DateFormat dateFormatName = new SimpleDateFormat("MM_dd_YYYY");
            Date date = new Date();
           // String dateMetaData = dateFormatMetaData.format(date);
            String dateMetaData = DateTestMetaData;
            //String dateName = dateFormatName.format(date);
            String dateName = DateTest;
            //Add new ProviderServiceDates to Metadata

            providerService = editableProviderService.getImmutableType();
            //If ProviderSevices on current date exists, updating it.
            if(initializeProviderServicesOnDate(dateName))
            {
                ProviderServices providerServices = providerServicesData.getImmutableType();
                int size =  providerServices.getProviderServices().size();
                //The File ProviderServices on current date already has data.
                if(size > 0)
                {
                    //set id is the next number of the last
                    String lastID = providerServices.getProviderServices().get(size-1).getId();
                    int nextID = Integer.parseInt(lastID) +1;
                    providerService.setId(Integer.toString(nextID));
                }
                //The File ProviderServices on current date already does not have data.
                else
                    providerService.setId("1");

                metaData.addProviderService(providerService,dateMetaData);
                providerServicesData.addProviderService(providerService);

                try {
                    File memberFile = new File(PROVIDER_DIRECTORY_PATH + dateName + ".xml");
                    Marshaller m = JAXBContext.newInstance(EditableProviderServices.class).createMarshaller();
                    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    m.marshal(providerServicesData, memberFile);
                    m.marshal(providerServicesData, System.out);
                    //update file metadata
                    save();
                } catch (Exception e) {
                    System.out.println("Error: Service failed to save!");
                    e.printStackTrace();
                }
            }
            //The ProviderServices on current date doesnt exist, create a new one.
            else
            {
                providerService = editableProviderService.getImmutableType();
                providerService.setId("1");
                metaData.addProviderService(providerService,dateMetaData);
                providerServicesData.addProviderService(providerService);
                try {
                    File memberFile_ = new File(PROVIDER_DIRECTORY_PATH + dateName + ".xml");
                    Marshaller m = JAXBContext.newInstance(EditableProviderServices.class).createMarshaller();
                    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    m.marshal(providerServicesData, memberFile_);
                    m.marshal(providerServicesData, System.out);
                    //update file metadata
                    save();
                } catch (Exception e) {
                    System.out.println("Error: Service failed to save!");
                    e.printStackTrace();
                }
            }

        }
        return providerService;
    }
    //Update a specific provider service on a specific date
    public ProviderService updateServiceOnDate(EditableProviderService editableProviderService, String Date) {
        ProviderService providerService = null;

        //Change DateFormat form "MM/dd/yyyy" to MM_dd_yyyy and check if it's correct
        String DateName = "";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate;
        try {
            startDate = df.parse(Date);

            DateFormat dateFormatName = new SimpleDateFormat("MM_dd_YYYY");
            DateName = dateFormatName.format(startDate);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Wrong Date Format");
            return providerService;
        }

        /////////////////////////////////////
        if (editableProviderService != null && initialized)
        {
            //Load ProviderService on that date

            if(initializeProviderServicesOnDate(DateName)) {
                providerService = editableProviderService.getImmutableType();
                ProviderServiceDates providerServiceOnDate = metaData.getProviderServicesOnDate(Date);
                //check if the file ProviderService exists on that date
                if (providerServiceOnDate != null) {
                    int index = providerServiceOnDate.isProviderServiceID(providerService.getId());
                    //check if ProviderService ID exists on the file ProviderService on that date.
                    if (index == -1)
                        return null;
                    providerServicesData.updateProviderService(providerService);
                    try {
                        File memberFile_ = new File(PROVIDER_DIRECTORY_PATH + DateName + ".xml");
                        Marshaller m = JAXBContext.newInstance(EditableProviderServices.class).createMarshaller();
                        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        m.marshal(providerServicesData, memberFile_);
                        m.marshal(providerServicesData, System.out);
                    } catch (Exception e) {
                        System.out.println("Error: Service failed to save!");
                        e.printStackTrace();
                    }

                }
            }
        }
        return providerService;
    }

    public ProviderService removeServiceOnDate(EditableProviderService editableProviderService, String Date) {
        ProviderService providerService = null;

        //Change DateFormat form "MM/dd/yyyy" to MM_dd_yyyy and check if it's correct
        String DateName = "";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate;
        try {
            startDate = df.parse(Date);
            DateFormat dateFormatName = new SimpleDateFormat("MM_dd_YYYY");
            DateName = dateFormatName.format(startDate);
            //System.out.println(DateName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Wrong Date Format");
            return providerService;
        }

        /////////////////////////////////////
        if (editableProviderService != null && initialized)
        {
            //Load ProviderService on that date
            if(initializeProviderServicesOnDate(DateName)) {
                providerService = editableProviderService.getImmutableType();
                ProviderServiceDates providerServiceOnDate = metaData.getProviderServicesOnDate(Date);

                //check if the ProviderService ID exists in metaData
                if (providerServiceOnDate != null) {
                    int index = providerServiceOnDate.isProviderServiceID(providerService.getId());
                    //check if ProviderService ID exists on the file ProviderService on that date.
                    if (index == -1)
                        return null;
                    //remove ProviderService from metadata and providerServices on that date
                    providerServicesData.removeProviderService(providerService);

                    if(providerServicesData.getProviderServices().size() == 0)
                    {
                        metaData.removeProviderServiceDate(providerServiceOnDate);
                        save();
                        try
                        {
                            File memberFile_ = new File(PROVIDER_DIRECTORY_PATH + DateName + ".xml");
                            if(memberFile_.delete())
                            {
                                System.out.println(memberFile_.getName() + " is deleted!");
                            }
                            else
                            {
                                System.out.println("Delete operation is failed.");
                            }
                        } catch (Exception e)
                        {
                            System.out.println("Error: Service failed to remove!");
                            e.printStackTrace();

                        }
                    }
                    else {
                        metaData.removeService(providerService.getId(), Date);
                        try {
                            File memberFile_ = new File(PROVIDER_DIRECTORY_PATH + DateName + ".xml");
                            Marshaller m = JAXBContext.newInstance(EditableProviderServices.class).createMarshaller();
                            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                            m.marshal(providerServicesData, memberFile_);
                            m.marshal(providerServicesData, System.out);
                            //update metadata
                            save();
                        } catch (Exception e) {
                            System.out.println("Error: Service failed to save!");
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
        return providerService;
    }

    //Update metadata
    public void save() {
        if (initialized) {
            try {
                //JAXBContext jc = JAXBContext.newInstance(ServiceMetaData.class);
                File metaDataFile = new File(META_DATA_PATH);
                Marshaller m = JAXBContext.newInstance(ProviderServicesMetaData.class).createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(metaData, metaDataFile);
                m.marshal(metaData, System.out);
            } catch (Exception e) {
                System.out.println("Error: ServiceMetaData failed to save!");
                e.printStackTrace();
            }
        }
    }



}
