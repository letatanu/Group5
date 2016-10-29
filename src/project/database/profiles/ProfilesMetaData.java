package project.database.profiles;

import javax.xml.bind.annotation.*;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by ahunger on 10/25/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="meta_data")
public class ProfilesMetaData {

    private static final int ID_SIZE = 9;
    private static final int MAX_ID = 999999999;

    @XmlAttribute(name="next_id")
    private int next_id;

    @XmlElementWrapper(name="members")
    @XmlElement(name="ID")
    private Vector<AdaptedID> member_ids;

    @XmlElementWrapper(name="providers")
    @XmlElement(name="ID")
    private Vector<AdaptedID> provider_ids;

    @XmlElementWrapper(name="managers")
    @XmlElement(name="ID")
    private Vector<AdaptedID> manager_ids;

    @XmlElementWrapper(name="removed_ids")
    @XmlElement(name="ID")
    private Stack<AdaptedID> removed_ids;

    private String getNextID() {
        String id = null;
        if (removed_ids.isEmpty()) {
            if (next_id < MAX_ID) {
                id = Integer.toString(next_id);
                while(id.length() < ID_SIZE)
                    id = '0' + id;
            }
        } else
            id = removed_ids.pop().id;

        return id;
    }

    public boolean isMemeber(String id) {
        return member_ids.contains(new AdaptedID(id));
    }

    public boolean isProvider(String id) {
        return provider_ids.contains(new AdaptedID(id));
    }

    public boolean isManager(String id) {
        return manager_ids.contains(new AdaptedID(id));
    }

    public boolean isProfile(String id) {
        return isMemeber(id) || isManager(id) || isProvider(id);
    }

    public void removeProfile(String id) {
        boolean removed = false;
        if (isMemeber(id)) {
            member_ids.remove(new AdaptedID(id));
            removed = true;
        }
        else {
            if (isProvider(id)) {
                provider_ids.remove(new AdaptedID(id));
                removed = true;
            }
            else {
                if (isManager(id)) {
                    manager_ids.remove(new AdaptedID(id));
                    removed = true;
                }
            }
        }

        if (removed)
            removed_ids.push(new AdaptedID(id));
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name="ID")
    private static class AdaptedID implements Comparable<AdaptedID> {

        @XmlAttribute(name="id")
        public String id;

        public AdaptedID() {
            id = null;
        }

        public AdaptedID(String id) {
            this.id = id;
        }

        public int compareTo(AdaptedID other_id) {
            return id.compareTo(other_id.id);
        }
    }
}
