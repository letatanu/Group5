package project.database.profiles.profile.adapted;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ahunger on 10/25/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="profile")
public class AdaptedProfile {
    @XmlAttribute(name="profile_id")
    private String profile_id;

    @XmlAttribute(name="name")
    private String name;

}
