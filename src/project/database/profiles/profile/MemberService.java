package project.database.profiles.profile;

import project.database.profiles.profile.editable.EditableMemberService;

/**
 * Created by Ashton on 10/28/2016.
 */
public final class MemberService implements ImmutableType {
    private final Date date;
    private final String provider;
    private final String serviceName;

    public MemberService(Date date, String provider, String serviceName) {
        this.date = date;
        this.provider = provider;
        this.serviceName = serviceName;
    }

    public Date getDate() {
        return date;
    }

    public String getProvider() {
        return provider;
    }

    public String getServiceName() {
        return serviceName;
    }

    public EditableMemberService getEditableType() { return new EditableMemberService(this); }
}
