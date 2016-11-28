package project.database.profiles.profile.editable;

import project.database.profiles.profile.Provider;
import project.database.profiles.profile.ProviderService;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashton on 11/21/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="provider_profile")
public class EditableProvider extends EditableProfile {
    @XmlElementWrapper(name = "services_provided")
    @XmlElement(name = "service")
    private ArrayList<EditableProviderService> servicesProvided;

    public EditableProvider() {
        servicesProvided = new ArrayList<>();
    }

    public EditableProvider(Provider provider) {
        super(provider);
        servicesProvided = new ArrayList<>();
        for(ProviderService service : provider.getServicesProvided())
            servicesProvided.add(new EditableProviderService(service));
    }

    public List<EditableProviderService> getServicesProvided() { return servicesProvided; }

    @Override
    public Provider getImmutableType() {
        ArrayList<ProviderService> memberServices = new ArrayList<>(servicesProvided.size());
        for(EditableProviderService service : servicesProvided)
            memberServices.add(service.getImmutableType());

        return new Provider(id, name, address.getImmutableType(), memberServices);
    }
}
