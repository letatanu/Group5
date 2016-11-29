package project.database.profiles.profile;

import project.database.profiles.profile.editable.EditableProviderServices;
import project.database.provider_directory.ProviderService;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by WillLe on 11/28/16.
 */
public class ProviderServices implements ImmutableType{

    protected ArrayList<ProviderService> providerServices;

    //getter

    public ArrayList<ProviderService> getProviderServices() {
        return providerServices;
    }

    //setter

    public void setProviderServices(ArrayList<ProviderService> providerServices) {
        this.providerServices = providerServices;
    }

    public ProviderServices()
    {
        providerServices = new ArrayList<>();
    }

    public ProviderServices(ArrayList<ProviderService> providerServices)
    {
        this.providerServices = providerServices;
    }

    public boolean addProviderService(ProviderService providerService)
    {
        int index = isProviderService(providerService.getId());
        if(index == -1)
            return false;
        providerServices.add(providerService);
        return true;
    }

    public boolean removeProviderService(ProviderService providerService)
    {
        int index = isProviderService(providerService.getId());
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
            if(providerServices.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    @Override
    public EditableProviderServices getEditableType() { return new EditableProviderServices(this); }
}
