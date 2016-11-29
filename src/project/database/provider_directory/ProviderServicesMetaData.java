package project.database.provider_directory;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * This class handles the operations on the
 * meta-data (xml file) for provider services. It serves
 * as the interface between "ProviderDatabase"
 * object and "11_28_2016.xml".
 *
 * Note: only really need title, body, and fee
 * for the xml file.
 *
 * Created by Austin on 11/22/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ProviderServiceList")
public class ProviderServicesMetaData {

    @XmlElement(name="ProviderServicesDate")
    protected ArrayList<ProviderServiceDates> ProviderServicesDates;

    //getter
    @XmlTransient
    public ArrayList<ProviderServiceDates> getProviderServicesDates() {
        return ProviderServicesDates;
    }

    //setter

    public ProviderServicesMetaData()
    {
        ProviderServicesDates = new ArrayList<>();
    }
    public void setProviderServicesDates(ArrayList<ProviderServiceDates> providerServicesDates) {
        ProviderServicesDates = providerServicesDates;
    }

    //If add successfully, return -1, else return the index of providerServiceDate in ProviderServicesDates
    private int addProviderServiceDate(ProviderServiceDates providerServiceDate)
    {
        int index = indexFromDate(providerServiceDate.getId());
        if(index == -1)
        {
            ProviderServicesDates.add(providerServiceDate);
        }
        return index;
    }

    public boolean removeProviderServiceDate(ProviderServiceDates providerServiceDate)
    {
        int index = indexFromDate(providerServiceDate.getId());
        if(index != -1)
        {
            ProviderServicesDates.remove(index);
            return true;
        }
        return false;
    }
    //Functions in ProviderServicesMetaData

    public boolean addProviderService(ProviderService providerService, String Date)
    {

        ProviderServiceDates tmp = new ProviderServiceDates();
        tmp.setId(Date);
        int index = addProviderServiceDate(tmp);
        if(index == -1)
        {
            /*
            DateFormat dateFormat = new SimpleDateFormat("MM_dd_YYYY");
            Date date = new Date();
            System.out.println(dateFormat.format(date)); //test
            //create new ProviderServiceDate
            */
            return tmp.addProviderServiceID(providerService.getId());
        }
        System.out.println(index);
        return ProviderServicesDates.get(index).addProviderServiceID(providerService.getId());

    }


    //remove serviceID from metadata
    public boolean removeService(String id, String Date)
    {
        int index = indexFromDate(Date);
        if(index == -1 || id == null || Date == null)
            return false;

        return ProviderServicesDates.get(index).removeProviderServiceID(id);

    }

    public ProviderServiceDates getProviderServicesOnDate(String date)
    {
        ProviderServiceDates result = null ;
        for(int i=0; i<ProviderServicesDates.size(); i++)
        {
            String d = ProviderServicesDates.get(i).getId();
            if(d.equals(date))
            {
                return ProviderServicesDates.get(i);
            }
        }
        return result;
    }

    //This function returns true (!= -1) and false (=-1). If it returns true, the return value is the index also.
    public int indexFromDate(String date)
    {
        for(int i=0;i<ProviderServicesDates.size();i++)
        {
            if(ProviderServicesDates.get(i).getId().equals(date))
                return i;
        }
        return -1;
    }



}


