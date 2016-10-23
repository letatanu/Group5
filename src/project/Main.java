package project;

import project.terminal.DateEntryMenu;

public class Main {

    public static void main(String[] args) {

        DateEntryMenu dateEntry = new DateEntryMenu();

        dateEntry.runMenu();

        System.out.println(dateEntry.getEntry().toString());
    }
}
