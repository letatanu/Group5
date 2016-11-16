package project.database.profiles.profile.editable;

import project.database.profiles.profile.Profile;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by ahunger on 10/25/2016.
 */

public abstract class EditableProfile {
    @XmlAttribute(name="profile_id")
    protected String profileId;

    @XmlAttribute(name="first_name")
    protected String firstName;

    @XmlAttribute(name="last_name")
    protected String lastName;

    public EditableProfile() {
        profileId = Profile.DEFAULT_ID;
        firstName = "";
        lastName = "";
    }

    public EditableProfile(Profile profile) {
        profileId = profile.getID();
        firstName = profile.getName();
        lastName = profile.getLastName();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public void setProfileID(String id) {
        profileId = id;
    }

    public String getProfileID() { return profileId; }
 }
