package project.database.profiles.profile.editable;

import project.database.profiles.profile.Address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Ashton on 10/28/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EditableAddress implements EditableType {
    @XmlAttribute(name="streetAddress")
    private String streetAddress;

    @XmlAttribute(name="city")
    private String city;

    @XmlAttribute(name="state")
    private String state;

    @XmlAttribute(name="zip")
    private String zip;

    public EditableAddress() {}

    public EditableAddress(Address address) {
        streetAddress = address.getStreetAddress();
        city = address.getCity();
        state = address.getState();
        zip = address.getZip();
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) { this.zip = zip; }

    public Address getImmutableType() { return new Address(streetAddress, city, state, zip); }
}
