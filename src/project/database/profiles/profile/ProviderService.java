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
    private final String title;
    private final String body;
    private final Date dateOfService; //
    private final Date dateReceived; //
    //private final Time timeReceived;
    private final String memberName;
    private final String memberID;
    private final String serviceCode;
    private final double fee;


    // Constructors
    public ProviderService(String title, String body, Date dateOfService, Date dateReceived, String memberName, String memberID, String serviceCode, double fee) {
        this.title = title;
        this.body = body;
        this.dateOfService = dateOfService;
        this.dateReceived = dateReceived;
        this.memberName = memberName;
        this.memberID = memberID;
        this.serviceCode = serviceCode;
        this.fee = fee;
    }

    /**
     * Simple method to display contents. Mainly
     * a helper tool while we get the DB up and
     * running.
     */
    public void displayAllAttributes(){
        if(!title.isEmpty() && title != null){
            System.out.println("Title: "+ title);
        }
        System.out.println("Fee:" + fee);

    }









}
