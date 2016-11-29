package project.database.profiles.profile.editable;

/**
 * Created by WillLe on 11/28/16.
 */
import project.database.provider_directory.ProviderService;
import project.database.profiles.profile.ProviderServices;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ProviderServices")
public class EditableProviderServices implements EditableType{

    @XmlElement(name="ProviderService")
    protected ArrayList<ProviderService> providerServices;



    //getter
    @XmlTransient
    public ArrayList<ProviderService> getProviderServices() {
        return providerServices;
    }

    //setter

    public void setProviderServices(ArrayList<ProviderService> providerServices) {
        this.providerServices = providerServices;
    }
     public EditableProviderServices()
     {
         providerServices = new ArrayList<>();
     }
    //functions
    //------------------------
    public EditableProviderServices(ProviderServices providerServices)
    {
        this.providerServices = providerServices.getProviderServices();
    }
    public boolean addProviderService(ProviderService providerService)
    {
        int index = isProviderService(providerService.getId());
        if(index == -1) {
            providerServices.add(providerService);
            return true;
        }
        return false;
    }

    public boolean updateProviderService(ProviderService providerService)
    {
        int index = isProviderService(providerService.getId());
        if(index != -1)
        {
            providerServices.set(index, providerService);
            return true;
        }
        return false;
    }

    public boolean removeProviderService(ProviderService providerService)
    {
        int index = isProviderService(providerService.getId());
        System.out.println(index);
        if(index == -1)
            return false;
        providerServices.remove(index);
        return true;
    }

    //return the index of the providerService in providerServices when successful. Return -1 when failed.
    public int isProviderService(String id)
    {
        for(int i=0;i<providerServices.size();i++)
        {
            if(providerServices.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }
    @Override
    public ProviderServices getImmutableType() {
        return new ProviderServices(providerServices);
    }
}
