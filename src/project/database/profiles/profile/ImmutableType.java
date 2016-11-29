package project.database.profiles.profile;

import project.database.profiles.profile.editable.EditableType;

/**
 * ImmutableType interface allows a general conversion between types
 */
public interface ImmutableType {
    /**
     * Creates an EditableType of the data
     *
     * @return EditableType
     */
    EditableType getEditableType();
}
