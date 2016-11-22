package project.database.provider_directory;

import project.database.profiles.profile.ProviderService;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * This class handles the operations on the
 * meta-data (xml file) for provider services. It serves
 * as the interface between "ProviderDatabase"
 * object and "services.xml".
 *
 * Created by Austin on 11/22/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="service_list")
public class ProviderServicesMetaData {

    @XmlElementWrapper(name="service")
    @XmlElement(name="service")
    private List<ProviderService> services;


}
