package project.database.profiles;

import project.database.profiles.profile.Member;
import project.database.profiles.profile.Profile;
import project.database.profiles.profile.editable.EditableAddress;
import project.database.profiles.profile.editable.EditableMember;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.io.File;

/**
 * Created by ahunger on 10/25/2016.
 */
public class ProfilesDatabase {

    private static final String META_DATA_PATH = "src/project/database/profiles/xml/metadata.xml";
    private static final String PROFILE_DATA_PATH = "src/project/database/profiles/xml/";

    private static final int ID_SIZE = 9;
    private static final int MAX_ID = 999999999;

    private int next_seed;

    private boolean initialized = false;
    private ProfilesMetaData metaData;

    public void initialize() {
        try {
            File metaDataFile = new File(META_DATA_PATH);
            Unmarshaller um = JAXBContext.newInstance(ProfilesMetaData.class).createUnmarshaller();
            metaData = (ProfilesMetaData)um.unmarshal(metaDataFile);
            next_seed = metaData.getNextSeed();
            initialized = true;
        } catch(Exception e) {
            System.out.println("Error: ProfileMetaData failed to load");
            e.printStackTrace();
        }
    }

    public void save() {
        if (initialized) {
            try {
                metaData.setNextSeed(next_seed);
                File metaDataFile = new File(META_DATA_PATH);
                Marshaller m = JAXBContext.newInstance(ProfilesMetaData.class).createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(metaData, metaDataFile);
                m.marshal(metaData, System.out);
            } catch (Exception e) {
                System.out.println("Error: ProfileMetaData failed to save!");
                e.printStackTrace();
            }
        }
    }

    private int encodeSeed(int seed) {
        return (int)((seed * (long)387420489) % (MAX_ID + 1));
    }

    private int decodeID(String id) {
        return (int)((Integer.parseInt(id) * (long)513180409) % (MAX_ID + 1));
    }

    public String getNextID() {
        String id = null;
        while(id == null || metaData.isProfile(id)) {
            id = metaData.popRemovedID();
            if (id == null) {
                if (next_seed++ < MAX_ID) {
                    id = Integer.toString(encodeSeed(next_seed));
                    while (id.length() < ID_SIZE)
                        id = '0' + id;
                }
            }
        }

        return id;
    }

    public Member addMember(EditableMember editableMember) {
        Member member = null;

        if (editableMember != null && initialized && !isMember(editableMember.getProfileID())) {

            String id;
            if (editableMember.getProfileID().equals(Profile.DEFAULT_ID))
                id = getNextID();
            else
                id = editableMember.getProfileID();

            editableMember.setProfileID(id);
            member = editableMember.exportMember();
            metaData.addProfile(member);
            try {
                File memberFile = new File(PROFILE_DATA_PATH + "members/" + id + ".xml");
                Marshaller m = JAXBContext.newInstance(EditableMember.class).createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(editableMember, memberFile);
                m.marshal(editableMember, System.out);
            } catch (Exception e) {
                System.out.println("Error: Member failed to save!");
                e.printStackTrace();
            }

        }

        return member;
    }

    public void removeProfile(String id) {
        if (id != null && isProfile(id))
            metaData.removeProfile(id);
    }

    public Member getMember(String id) {
        Member member = null;

        if (id != null && isMember(id)) {
            try {
                File memberFile = new File(PROFILE_DATA_PATH + "members/" + id + ".xml");
                Unmarshaller um = JAXBContext.newInstance(Member.class).createUnmarshaller();
                member = (Member) um.unmarshal(memberFile);
            } catch(Exception e) {
                System.out.println("Error: Member failed to load");
                e.printStackTrace();
            }
        }

        return member;
    }

    public boolean isMember(String id) {
        if (initialized)
            return metaData.isMember(id);
        else
            return false;
    }

    public boolean isProvider(String id) {
        if (initialized)
            return metaData.isProvider(id);
        else
            return false;
    }

    public boolean isManager(String id) {
        if (initialized)
            return metaData.isManager(id);
        else
            return false;
    }

    public boolean isProfile(String id) {
        if (initialized)
            return isMember(id) || isManager(id) || isProvider(id);
        else
            return false;
    }

    public void test() {
        EditableMember editableMember = new EditableMember();

        editableMember.setProfileID("583928473");

        editableMember.setName("Jim Bobby");

        EditableAddress editableAddress = new EditableAddress();

        editableAddress.setCity("Hillsboro");
        editableAddress.setState("OR");
        editableAddress.setStreetAddress("225 NE Hyde Circle");
        editableAddress.setZip("97124");

        editableMember.setAddress(editableAddress);

        Member member = addMember(editableMember);

        System.out.println("Is Member: " + isMember(member.getID()));

        removeProfile(member.getID());

        System.out.println("Is Member: " + isMember(member.getID()));
    }
}
