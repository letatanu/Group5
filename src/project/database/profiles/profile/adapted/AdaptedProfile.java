package project.database.profiles.profile.adapted;

import project.database.profiles.profile.Profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ahunger on 10/25/2016.
 */

public abstract class AdaptedProfile {
    @XmlAttribute(name="profile_id")
    protected String profileId;

    @XmlAttribute(name="name")
    protected String name;

    public AdaptedProfile() {}

    public AdaptedProfile(Profile profile) {
        profileId = profile.getID();
        name = profile.getName();
    }
}
