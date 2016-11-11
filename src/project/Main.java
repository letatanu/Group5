package project;

import project.database.profiles.ProfilesDatabase;

public class Main {

    public static void main(String[] args) {

        ProfilesDatabase p = new ProfilesDatabase();

        p.initialize();

        p.test();

        p.save();
    }
}
