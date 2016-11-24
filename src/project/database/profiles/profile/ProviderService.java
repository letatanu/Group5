package project.database.profiles.profile;

/**
 * This class contains information on services
 * rendered by a provider. Needs to be improved
 * since it is only a general template so we can
 * continue on with the project.
 *
 * Things to improve:
 *     * a list of provider types that are able to
 *       use the service.
 *     * rename variables so they're less confusing.
 *     *
 *
 * Created by ahunger on 11/20/2016.
 *
 */
public final class ProviderService {

    // Attributes
    // ****Confusing variable names****
    private String title;
    private String body;
    private String dateOfService; //
    private String dateReceived; //
    private String memberName;
    private String memberID;
    private String serviceCode;
    private double fee;


    // Constructors
    public ProviderService() {
        title = null;
        body = null;
        dateOfService = null;
        dateReceived = null;
        memberName = null;
        memberID = null;
        serviceCode = null;
        fee = 0;
    }

    public ProviderService(String title, String body, String dateOfService, String dateReceived, String memberName, String memberID, String serviceCode, double fee) {
        this.title = title;
        this.body = body;
        this.dateOfService = dateOfService;
        this.dateReceived = dateReceived;
        this.memberName = memberName;
        this.memberID = memberID;
        this.serviceCode = serviceCode;
        this.fee = fee;
    }

    // Getters
    public String getTitle(){
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getDateOfService() {
        return dateOfService;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public double getFee() {
        return fee;
    }

    public void displayAllAttributes(){
        System.out.println("Title: " + title);
        System.out.println("Body: " + body);
        System.out.println("Date of service: " + dateOfService);
        System.out.println("Date received: " + dateReceived);
        System.out.println("Member name: " + memberName);
        System.out.println("Member ID: " + memberID);
        System.out.println("Service Code: " + serviceCode);
        System.out.println("Fee: " + fee);
    }
}
