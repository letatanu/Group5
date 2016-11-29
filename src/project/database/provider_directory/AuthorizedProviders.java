package project.database.provider_directory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Austin on 11/28/16.
 */
@XmlRootElement(name="authorizedProviders")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorizedProviders {

    @XmlElement(name="provider")
    private ArrayList<String> providers;

    // Constructor
    public AuthorizedProviders(){
        providers = null;
    }

    // Getters
    public ArrayList<String> getProviders(){
        return providers;
    }

}
