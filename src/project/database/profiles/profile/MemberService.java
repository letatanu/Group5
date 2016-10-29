package project.database.profiles.profile;

/**
 * Created by Ashton on 10/28/2016.
 */
public final class MemberService {
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
}
