package project.database.profiles.profile.editable;

import project.database.profiles.profile.Address;
import project.database.profiles.profile.Profile;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by ahunger on 10/25/2016.
 */

public abstract class EditableProfile implements EditableType {
    @XmlAttribute(name="profile_id")
    protected String id;

    @XmlAttribute(name="name")
    protected String name;

    @XmlElement(name="address")
    protected EditableAddress address;

    public EditableProfile() {
        id = Profile.DEFAULT_ID;
        name = "";
        address = null;
    }

    public EditableProfile(Profile profile) {
        id = profile.getID();
        name = profile.getName();
        address = new EditableAddress(profile.getAddress());
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) { this.address = new EditableAddress(address); }

    private void setAddress(EditableAddress address) { this.address = address; }

    @XmlTransient
    public String getID() { return id; }
 }
