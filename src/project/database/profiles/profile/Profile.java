package project.database.profiles.profile;

/**
 * Created by Ashton on 27/10/16.
 */
public abstract class Profile {
    private final String id;
    private final String name;

    public Profile(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public final String getID() { return id; }

    public final String getName() { return name; }
}
