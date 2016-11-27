package project.database.profiles.profile.editable;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * I started this but I'm not familiar with XML. I'll probably
 * come back to this later.
 * Created by Austin on 11/19/16.
 */
public class EditableService {



    @XmlAttribute(name="service_title")
    protected String serviceTitle;

    @XmlAttribute(name="service_id")
    protected String profileId;

    @XmlAttribute(name="service_description")
    protected String serviceDescription;

    @XmlAttribute(name="service_cost")
    protected double service_cost;




}
