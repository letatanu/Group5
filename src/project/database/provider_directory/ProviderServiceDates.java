package project.database.provider_directory;


import javax.xml.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by WillLe on 11/28/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ProviderServicesDate")
public class ProviderServiceDates {
    @XmlAttribute(name="id")
    private String id;

    @XmlElement(name="ProviderServiceID")
    private ArrayList<String> providerIDs;

    public ProviderServiceDates(String id)
    {
        providerIDs = new ArrayList<>();
        this.id = id;
    }
    //id is the current date
    public  ProviderServiceDates()
    {
        providerIDs = new ArrayList<>();
        DateFormat dateFormatMetaData = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String id = dateFormatMetaData.format(date);
        this.id = id;
    }
    //getter
    @XmlTransient

    public String getId() {
        return id;
    }

    public ArrayList<String> getProviderIDs() {
        return providerIDs;
    }



    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setProviderIDs(ArrayList<String> providerIDs) {
        this.providerIDs = providerIDs;
    }

    public boolean addProviderServiceID(String id)
    {
        int index = isProviderServiceID(id);
        if(index == -1)
        {
            providerIDs.add(id);
            return true;
        }
        return false;
    }

    public boolean removeProviderServiceID(String id)
    {
        int index = isProviderServiceID(id);
        if(index != -1)
        {
            providerIDs.remove(index);
            return true;
        }
        return false;
    }

    //Check if ProviderServiceID exists. If does, return the index. If not, return -1;
    public int isProviderServiceID(String ID)
    {
        for(int i=0;i < providerIDs.size(); i++)
        {
            if(providerIDs.get(i).equals(ID))
                return i;
        }
        return -1;
    }
}
