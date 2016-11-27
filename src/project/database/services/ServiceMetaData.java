package project.database.services;

import com.sun.xml.internal.txw2.annotation.*;
import project.database.profiles.profile.*;

import javax.xml.bind.annotation.*;

import java.util.Vector;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by WillLe on 11/26/16.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="service_list")
public class ServiceMetaData {
    @XmlElement(name="service")
    private Vector<String> services;

    public boolean addService(String serviceID)
    {
        if(serviceID != null && !isService(serviceID))
        {
            services.addElement(serviceID);
            return true;
        }
        return false;
    }

    public boolean removeService(String serviceID)
    {
        if(serviceID != null && isService(serviceID))
        {
            return true;
        }
        return false;
    }

    public boolean isService(String serviceID)
    {
        int size = services.size();
        for(int i=0;i<size;i++)
        {
            if(services.get(i).equals(serviceID))
                return true;
        }
        return false;
    }
}

