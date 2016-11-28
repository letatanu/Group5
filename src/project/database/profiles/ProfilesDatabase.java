package project.database.profiles;

import project.database.profiles.profile.Member;
import project.database.profiles.profile.Profile;
import project.database.profiles.profile.Provider;
import project.database.profiles.profile.editable.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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

        if (editableMember != null && initialized && !isMember(editableMember.getID())) {
            String id;
            if (editableMember.getID().equals(Profile.DEFAULT_ID))
                id = getNextID();
            else
                id = editableMember.getID();

            editableMember.setID(id);
            member = editableMember.getImmutableType();
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

    public Provider addProvider(EditableProvider editableProvider) {
        Provider provider = null;

        if (editableProvider != null && initialized && !isProvider(editableProvider.getID())) {
            String id;
            if (editableProvider.getID().equals(Profile.DEFAULT_ID))
                id = getNextID();
            else
                id = editableProvider.getID();

            editableProvider.setID(id);
            provider = editableProvider.getImmutableType();
            metaData.addProfile(provider);
            try {
                File providerFile = new File(PROFILE_DATA_PATH + "providers/" + id + ".xml");
                Marshaller m = JAXBContext.newInstance(EditableProvider.class).createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(editableProvider, providerFile);
                m.marshal(editableProvider, System.out);
            } catch (Exception e) {
                System.out.println("Error: Provider failed to save!");
                e.printStackTrace();
            }

        }

        return provider;
    }

    public boolean updateProfile(Profile editedProfile) {
        if (editedProfile != null && initialized && isProfile(editedProfile.getID())) {
            try {
                File profileFile;
                Marshaller m;
                if (isMember(editedProfile.getID())) {
                    profileFile = new File(PROFILE_DATA_PATH + "members/" + editedProfile.getID() + ".xml");
                    m = JAXBContext.newInstance(EditableMember.class).createMarshaller();
                } else {
                    profileFile = new File(PROFILE_DATA_PATH + "provider/" + editedProfile.getID() + ".xml");
                    m = JAXBContext.newInstance(EditableProvider.class).createMarshaller();
                }
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(editedProfile.getEditableType(), profileFile);
                m.marshal(editedProfile.getEditableType(), System.out);
            } catch (Exception e) {
                System.out.println("Error: Member failed to update!");
                e.printStackTrace();
            }
            return true;
        } else
            return false;
    }

    public void removeProfile(String id) {
        if (id != null && isProfile(id))
            metaData.removeProfile(id);

    }

    public Member getMember(String memberID) {
        Member member = null;

        if (memberID != null && isMember(memberID)) {
            try {
                File memberFile = new File(PROFILE_DATA_PATH + "members/" + memberID + ".xml");
                Unmarshaller um = JAXBContext.newInstance(EditableMember.class).createUnmarshaller();
                EditableMember editableMember = (EditableMember) um.unmarshal(memberFile);
                member = editableMember.getImmutableType();
            } catch(Exception e) {
                System.out.println("Error: Member failed to load");
                e.printStackTrace();
            }
        }

        return member;
    }

    public Provider getProvider(String providerID) {
        Provider provider = null;

        if (providerID != null && isProvider(providerID)) {
            try {
                File providerFile = new File(PROFILE_DATA_PATH + "provider/" + providerID + ".xml");
                Unmarshaller um = JAXBContext.newInstance(EditableProvider.class).createUnmarshaller();
                EditableProvider editableProvider = (EditableProvider) um.unmarshal(providerFile);
                provider = editableProvider.getImmutableType();
            } catch(Exception e) {
                System.out.println("Error: Member failed to load");
                e.printStackTrace();
            }
        }

        return provider;
    }

    public boolean isMember(String memberID) {
        if (initialized)
            return metaData.isMember(memberID);
        else
            return false;
    }

    public boolean isProvider(String providerID) {
        if (initialized)
            return metaData.isProvider(providerID);
        else
            return false;
    }

    public boolean isManager(String managerID) {
        if (initialized)
            return metaData.isManager(managerID);
        else
            return false;
    }

    public boolean isProfile(String id) {
        if (initialized)
            return isMember(id) || isManager(id) || isProvider(id);
        else
            return false;
    }

    public boolean addService(String providerID, String memberID, EditableProviderService editableProviderService) {
        try {
            EditableProvider provider = getProvider(providerID).getEditableType();

            provider.getServicesProvided().add(editableProviderService);

            updateProfile(provider.getImmutableType());

            EditableMember member = getMember(memberID).getEditableType();

            EditableMemberService editableMemberService = new EditableMemberService();
            editableMemberService.setDate(editableProviderService.getDateOfService());
            editableMemberService.setProviderName(provider.getName());
            editableMemberService.setServiceName("NO SERVICE NAMES");

            member.getServicesReceived().add(editableMemberService);

            updateProfile(member.getImmutableType());

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}
