package project.database.profiles.profile.editable;

import project.database.profiles.profile.Profile;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by ahunger on 10/25/2016.
 */

public abstract class EditableProfile {
    @XmlAttribute(name="profile_id")
    protected String id;

    @XmlAttribute(name="name")
    protected String name;

    public EditableProfile() {
        id = Profile.DEFAULT_ID;
        name = "";
    }

    public EditableProfile(Profile profile) {
        id = profile.getID();
        name = profile.getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public void setID(String id) {
        this.id = id;
    }

    public String getID() { return id; }
 }
