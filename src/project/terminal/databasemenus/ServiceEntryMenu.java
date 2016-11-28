package project.terminal.databasemenus;

import project.database.profiles.ProfilesDatabase;
import project.database.profiles.profile.*;
import project.database.profiles.profile.editable.EditableProviderService;
import project.terminal.BooleanEntryMenu;
import project.terminal.StringEntryMenu;
import project.terminal.TerminalMenu;
import project.terminal.datemenus.DateEntryMenu;
import project.terminal.timemenus.TimeEntryMenu;

import java.time.LocalDateTime;
import java.util.Calendar;

public class ServiceEntryMenu extends TerminalMenu<ProviderService>{

    private EditableProviderService editableProviderService;

    private final ProfilesDatabase profilesDatabase;
    private final Provider provider;
    private final Member member;

    public ServiceEntryMenu(String name, ProfilesDatabase profilesDatabase, String providerID, String memberID) {
        super(name);
        this.profilesDatabase = profilesDatabase;
        provider = profilesDatabase.getProvider(providerID);
        member = profilesDatabase.getMember(memberID);
    }

    @Override
    public ProviderService runMenu() {

        //TODO Print service & fee

        //Menus
        ProfileNameEntryMenu profileNameEntryMenu = new ProfileNameEntryMenu("", "", "Enter Member Name");
        StringEntryMenu idEntryMenu = new StringEntryMenu("", "", "Enter Member ID", StringEntryMenu.INTEGER_ONLY_REGEX, 9, 9) { public void printMenu() {} };
        DateEntryMenu dateEntryMenu = new DateEntryMenu();
        TimeEntryMenu timeEntryMenu = new TimeEntryMenu();
        BooleanEntryMenu commentOptionMenu = new BooleanEntryMenu("Service Comment", "Would you like to add a comment about the service?");
        StringEntryMenu commentEntryMenu = new StringEntryMenu("", "Enter any comments about the service (100 characters)", "Comment", 1, 100) { public void printMenu() {} };

        //Data
        Date currentDate = null;
        Time currentTime = null;
        Date dateOfService = null;
        String comment = null;

        boolean memberNameVerified = false;
        boolean memberIDVerified = false;
        boolean currentDateVerified = false;
        boolean currentTimeVerified = false;

        //Menu Logic
        while(!memberNameVerified) {
            System.out.print("\nPlease verify the member's name\n");
            String name = profileNameEntryMenu.runMenu();
            if (name != null)
                memberNameVerified = name.equals(member.getName());

            if (!memberNameVerified)
                System.out.println("Member name does not match the current patient: " + member.getName());
        }

        while(!memberIDVerified) {
            System.out.print("\nPlease verify the member's ID\n");
            String id = idEntryMenu.runMenu();
            if (id != null)
                memberIDVerified = id.equals(member.getID());

            if (!memberIDVerified)
                System.out.println("Member ID does not match the current patient");
        }

        while(!currentDateVerified) {
            System.out.print("\nPlease verify the current date\n");
            currentDate = dateEntryMenu.runMenu();
            LocalDateTime now = LocalDateTime.now();
            int year = now.getYear();
            int month = now.getMonth().getValue();
            int day = now.getDayOfMonth();
            if (currentDate != null)
                currentDateVerified = (year == currentDate.getYear()) && (month == currentDate.getMonth()) && (day == currentDate.getDay());

            if (!currentDateVerified)
                System.out.println("Date entered is not the current date");
        }

        while(!currentTimeVerified) {
            System.out.print("\nPlease verify the current time (Must be accurate to the minute)\n");
            currentTime = timeEntryMenu.runMenu();
            LocalDateTime now = LocalDateTime.now();
            int hours = now.getHour();
            int minutes = now.getMinute();
            if (currentTime != null)
                currentTimeVerified = (hours == currentTime.getHours()) && (minutes == currentTime.getMinutes());

            if(!currentTimeVerified)
                System.out.println("Time entered is not the current time");
        }

        System.out.print("\nPlease enter the date the service was provided\n");
        dateOfService = dateEntryMenu.runMenu();

        if (commentOptionMenu.runMenu())
            comment = commentEntryMenu.runMenu();
        else
            comment = "";

        EditableProviderService editableProviderService = new EditableProviderService();
        editableProviderService.setMemberName(member.getName());
        editableProviderService.setMemberID(member.getID());
        editableProviderService.setDateOfService(dateOfService.getEditableType());
        editableProviderService.setDateReceived(currentDate.getEditableType());
        editableProviderService.setTimeReceived(currentTime.getEditableType());
        editableProviderService.setComments(comment);

        //TODO Verify service code and fee

        profilesDatabase.addService(provider.getID(), member.getID(), editableProviderService);

        return editableProviderService.getImmutableType();
    }
}