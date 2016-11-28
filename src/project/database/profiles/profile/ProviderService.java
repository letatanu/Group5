package project.database.profiles.profile;

import project.database.profiles.profile.editable.EditableProviderService;

/**
 * Created by ahunger on 11/20/2016.
 */
public final class ProviderService implements ImmutableType {

    // Supposed to be final, trying to error-fix
    private final Date dateOfService;
    private final Date dateReceived;
    private final Time timeReceived;
    private final String memberName;
    private final String memberID;
    private final String serviceCode;
    private final String comments;
    private final double fee;

    public ProviderService() {
        dateOfService = null;
        dateReceived = null;
        timeReceived = null;
        memberName = null;
        memberID = null;
        serviceCode = null;
        comments = null;
        fee = 420.00;
    }

    public ProviderService(Date dateOfService, Date dateReceived, Time timeReceived, String memberName, String memberID, String serviceCode, String comments, double fee) {
        this.dateOfService = dateOfService;
        this.dateReceived = dateReceived;
        this.timeReceived = timeReceived;
        this.memberName = memberName;
        this.memberID = memberID;
        this.serviceCode = serviceCode;
        this.comments = comments;
        this.fee = fee;
    }

    public Date getDateOfService() { return dateOfService; }

    public Date getDateReceived() { return dateReceived; }

    public Time getTimeReceived() { return timeReceived; }

    public String getMemberName() { return memberName; }

    public String getMemberID() { return memberID; }

    public String getServiceCode() { return serviceCode; }

    public String getComments() { return comments; }

    public double getFee(){
        return fee;
    }

    public void displaySelf(){
        /*
        dateOfService = null;
        dateReceived = null;
        timeReceived = null;
        memberName = null;
        memberID = null;
        serviceCode = null;
        comments = null;
        fee = 0;
         */
        System.out.println("Date Of service: " + dateOfService);
        System.out.println("Date received: " + dateReceived);
        System.out.println("Time received: " + timeReceived);
        System.out.println("Member name: " + memberName);
        System.out.println("Member ID: " + memberID);
        System.out.println("Service Code: " + serviceCode);
        System.out.println("Comments " + comments);
        System.out.println("Fee: " + fee);


    }

    @Override
    public EditableProviderService getEditableType() { return new EditableProviderService(this); }
}
