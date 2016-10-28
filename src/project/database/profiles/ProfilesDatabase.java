package project.database.profiles;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by ahunger on 10/25/2016.
 */
public class ProfilesDatabase {

    private boolean initialized = false;
    private ProfilesMetaData metaData;

    public void initialize() {
        try {
            File metaDataFile = new File(getClass().getResource("xml/metadata.xml").toURI());
            Unmarshaller um = JAXBContext.newInstance(ProfilesMetaData.class).createUnmarshaller();
            metaData = (ProfilesMetaData)um.unmarshal(metaDataFile);

        } catch(Exception e) {
            System.out.println("Error: ProfileMetaData failed to load");
            e.printStackTrace();
        }
    }
}
