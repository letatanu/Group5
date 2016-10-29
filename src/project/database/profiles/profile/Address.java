package project.database.profiles.profile;

/**
 * Created by Ashton on 10/28/2016.
 */
public final class Address {
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String zip;

    public Address(String streetAddress, String city, String state, String zip) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
