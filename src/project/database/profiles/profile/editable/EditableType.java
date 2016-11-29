package project.database.profiles.profile.editable;

import project.database.profiles.profile.ImmutableType;

/**
 * EditableType interface allows a general conversion between types
 */
public interface EditableType {
    /**
     * Creates an ImmutableType of the data
     *
     * @return ImmutableType
     */
    ImmutableType getImmutableType();
}
