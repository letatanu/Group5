package project.database.profiles.profile;

import java.util.List;
import java.util.Vector;

/**
 * Created by Ashton on 10/28/2016.
 */
public final class Member extends Profile {

    private final Address address;
    private final Vector<MemberService> servicesReceived;

    public Member(String profileId, String name, Address address, List<MemberService> servicesReceived) {
        super(profileId, name);
        this.address = address;
        this.servicesReceived = new Vector<>(servicesReceived.size());
        this.servicesReceived.addAll(servicesReceived);
    }

    public Address getAddress() { return address; }

    public int getServicesSize() { return servicesReceived.size(); }

    public MemberService getServiceReceived(int index) { return servicesReceived.get(index); }
}
