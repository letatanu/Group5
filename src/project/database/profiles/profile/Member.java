package project.database.profiles.profile;

import project.database.profiles.profile.editable.EditableMember;

import java.util.List;
import java.util.Vector;

/**
 * Created by Ashton on 10/28/2016.
 */
public final class Member extends Profile {

    private final Vector<MemberService> servicesReceived;

    public Member(String profileId, String name, Address address, List<MemberService> servicesReceived) {
        super(profileId, name, address);
        this.servicesReceived = new Vector<>(servicesReceived.size());
        this.servicesReceived.addAll(servicesReceived);
    }

    public int getServicesSize() { return servicesReceived.size(); }

    public MemberService getServiceReceived(int index) { return servicesReceived.get(index); }

    public EditableMember getEditableType() {
        return new EditableMember(this);
    }
}