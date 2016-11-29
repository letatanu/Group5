package project.database.services;

import com.sun.xml.internal.txw2.annotation.*;
import project.database.profiles.profile.*;
import project.database.profiles.profile.editable.EditableService;

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
    @XmlElement(name="service_id")
    protected Vector<String> services;

    //getter
    public Vector<String> getServices() {
        return services;
    }

    //setter
    public void setServices(Vector<String> services) {
        this.services = services;
    }

    //add serviceID to metadata
    public boolean addService(Service service)
    {
        if(service != null)
        {
            services.addElement(service.getId());
            for(int i=0;i<services.size();i++)
                System.out.println(services.get(i));
            return true;
        }
        return false;
    }
    //remove serviceID from metadata
    public boolean removeService(String id)
    {
        int index = isService(id);
        if(id != null && index != -1)
        {
            services.remove(index);
            return true;
        }
        return false;
    }

    //This function returns true (!= -1) and false (=-1). If it returns true, the return value is the index also.
    public int isService(String serviceID)
    {
        int size = services.size();
        for(int i=0;i<size;i++)
        {
            if(services.get(i).equals(serviceID))
                return i;
        }
        return -1;
    }

    public int getIndex(Service service)
    {
        for(int i =0; i< services.size();i++)
        {
            if(services.get(i).equals(service.getId()))
            {
                return i;
            }
        }
        return -1;
    }
}

