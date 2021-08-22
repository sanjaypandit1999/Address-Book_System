package com.Bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactEdit contactinfo = new ContactEdit();
        System.out.println("\nWhat would u like to do with contacts? \n" +
                "1. ADD     \n" +
                "2. DISPLAY \n" +
                "3. EDIT    \n" +
                "4. REMOVE  \n" +
                "0. EXIT    \n");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                contactinfo.addPerson();
                break;
            case 2:
                contactinfo.displayPerson();
                break;

            case 3:
                contactinfo.editPerson();
                contactinfo.editPerson();
                break;

            case 4:
                contactinfo.removePerson();
                break;
            default:
                System.exit(0);
                break;
        }
    }
}
