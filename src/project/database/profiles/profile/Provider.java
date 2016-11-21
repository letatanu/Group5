package project.database.profiles.profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahunger on 11/20/2016.
 */
public final class Provider extends Profile {

    private final Address address;
    private final ArrayList<ProviderService> servicesProvided;

    public Provider(String id, String name, Address address, List<ProviderService> servicesProvided) {
        super(id, name);
        this.address = address;
        this.servicesProvided = new ArrayList<>();
        this.servicesProvided.addAll(servicesProvided);
    }
}
