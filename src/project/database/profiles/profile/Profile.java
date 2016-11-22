package project.database.profiles.profile;

/**
 * Created by Ashton on 27/10/16.
 */
public abstract class Profile implements ImmutableType {
    public static final String DEFAULT_ID = "-1";

    private final String id;
    private final String name;
    private final Address address;

    public Profile(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public final String getID() { return id; }

    public final String getName() { return name; }

    public final Address getAddress() { return address; }
}
