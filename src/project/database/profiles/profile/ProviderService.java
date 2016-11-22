package project.database.profiles.profile;

import project.database.profiles.profile.editable.EditableProviderService;
import project.database.profiles.profile.editable.EditableType;

/**
 * Created by ahunger on 11/20/2016.
 */
public final class ProviderService implements ImmutableType {
    private final Date dateOfService;
    private final Date dateReceived;
    private final Time timeReceived;
    private final String memberName;
    private final String memberID;
    private final String serviceCode;
    private final String comments;

    public ProviderService(Date dateOfService, Date dateReceived, Time timeReceived, String memberName, String memberID, String serviceCode, String comments) {
        this.dateOfService = dateOfService;
        this.dateReceived = dateReceived;
        this.timeReceived = timeReceived;
        this.memberName = memberName;
        this.memberID = memberID;
        this.serviceCode = serviceCode;
        this.comments = comments;
    }

    public Date getDateOfService() { return dateOfService; }

    public Date getDateReceived() { return dateReceived; }

    public Time getTimeReceived() { return timeReceived; }

    public String getMemberName() { return memberName; }

    public String getMemberID() { return memberID; }

    public String getServiceCode() { return serviceCode; }

    public String getComments() { return comments; }

    @Override
    public EditableProviderService getEditableType() { return new EditableProviderService(this); }
}
