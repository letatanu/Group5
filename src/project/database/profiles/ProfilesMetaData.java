package project.database.profiles;

import project.database.profiles.profile.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by ahunger on 10/25/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="meta_data")
public class ProfilesMetaData {

    @XmlAttribute(name="next_seed")
    private int next_seed;

    @XmlElementWrapper(name="members")
    @XmlElement(name="ID")
    private Vector<EditableID> memberIDs;

    @XmlElementWrapper(name="providers")
    @XmlElement(name="ID")
    private Vector<EditableID> providerIDs;

    @XmlElementWrapper(name="managers")
    @XmlElement(name="ID")
    private Vector<EditableID> managerIDs;

    @XmlElementWrapper(name="removed_ids")
    @XmlElement(name="ID")
    private Stack<EditableID> removedIDs;

    public int getNextSeed() { return next_seed; }

    public void setNextSeed(int next_seed) { this.next_seed = next_seed; }

    public boolean addProfile(Profile profile) {
        if (profile != null && !isProfile(profile.getID())) {

            if (profile instanceof Member)
                memberIDs.add(new EditableID(profile.getID()));
            else {
                if (profile instanceof Provider)
                    providerIDs.add(new EditableID(profile.getID()));
                else
                    managerIDs.add(new EditableID(profile.getID()));
            }

            return true;
        } else
            return false;
    }


    public String popRemovedID() {
        if (!removedIDs.isEmpty()) {
            EditableID id = removedIDs.pop();

            if (id != null)
                return id.id;
        }
        return null;
    }

    public boolean removeProfile(String id) {
        boolean removed = false;
        int index = getProfileIndex(id, memberIDs);
        if (index != -1) {
            memberIDs.remove(index);
            removed = true;
        }
        else {
            index = getProfileIndex(id, providerIDs);
            if (index != -1) {
                providerIDs.remove(index);
                removed = true;
            }
            else {
                index = getProfileIndex(id, managerIDs);
                if (index != -1) {
                    managerIDs.remove(index);
                    removed = true;
                }
            }
        }

        if (removed)
            removedIDs.push(new EditableID(id));

        return removed;
    }

    private int getProfileIndex(String id, List<EditableID> IDs) {
        int index = -1;

        if (id != null && IDs != null) {
            for(int i = 0; i < IDs.size(); i++) {
                if (IDs.get(i).id.equals(id)) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    public boolean isMember(String id) {
        return getProfileIndex(id, memberIDs) != -1;
    }

    public boolean isProvider(String id) {
        return getProfileIndex(id, providerIDs) != -1;
    }

    public boolean isManager(String id) {
        return getProfileIndex(id, managerIDs) != -1;
    }

    public boolean isProfile(String id) {
        return isMember(id) || isManager(id) || isProvider(id);
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name="ID")
    private static class EditableID {
        @XmlAttribute(name="id")
        public String id;

        public EditableID() {
            id = null;
        }

        public EditableID(String id) {
            this.id = id;
        }
    }
}
