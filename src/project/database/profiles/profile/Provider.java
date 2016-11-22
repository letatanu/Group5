package project.database.profiles.profile;

import project.database.profiles.profile.editable.EditableProvider;
import project.database.profiles.profile.editable.EditableType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahunger on 11/20/2016.
 */
public final class Provider extends Profile {

    private final ArrayList<ProviderService> servicesProvided;

    public Provider(String id, String name, Address address, List<ProviderService> servicesProvided) {
        super(id, name, address);
        this.servicesProvided = new ArrayList<>();
        this.servicesProvided.addAll(servicesProvided);
    }

    public ArrayList<ProviderService> getServicesProvided() {
        ArrayList<ProviderService> servicesProvidedCopy = new ArrayList<>();
        servicesProvidedCopy.addAll(servicesProvided);
        return servicesProvidedCopy;
    }

    @Override
    public EditableProvider getEditableType() { return new EditableProvider(this); }
}
