package com.Bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactEdit {
    ArrayList<PersonInfo> contactList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    PersonInfo contact = new PersonInfo();

    public void addPerson() {

        System.out.println("Enter following details \n" +
                "First Name :");
        String firstName = scanner.next();
        System.out.println("Last Name :");
        String lastName = scanner.next();
        System.out.println("Address :");
        String address = scanner.next();
        System.out.println("City :");
        String city = scanner.next();
        System.out.println("State :");
        String state = scanner.next();
        System.out.println("Zip Code :");
        String zip = scanner.next();
        System.out.println("Phone Number :");
        String phoneNo = scanner.next();
        System.out.println("Email :");
        String email = scanner.next();

        PersonInfo contact = new PersonInfo();

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZip(zip);
        contact.setPhoneNo(phoneNo);
        contact.setEmail(email);

        contactList.add(contact);
    }
    public void displayPerson() {
        System.out.println("All contact =  " + contactList.size());
        System.out.println(contactList);

    }
    public void editPerson() {
        System.out.println("Enter a name you want to edit...");
        String editName = scanner.next();

        boolean found = false;
        for (PersonInfo contact : contactList) {

            if (contact.getFirstName().equals(editName)) {
                found = true;
                System.out.println(contact);

                System.out.println("What do you want to edit \n" +
                        "1. First Name / 2. Last Name / 3. Address / 4. City / " +
                        "5. State / 6. Zip code / 7. Phone Number / 8. Email");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new First Name");
                        String newFirstName = scanner.next();
                        contact.setFirstName(newFirstName);
                        break;

                    case 2:
                        System.out.println("Enter new Last Name");
                        String newLastName = scanner.next();
                        contact.setLastName(newLastName);
                        break;

                    case 3:
                        System.out.println("Enter new Address");
                        String newAddress = scanner.next();
                        contact.setAddress(newAddress);
                        break;

                    case 4:
                        System.out.println("Enter new City");
                        String newCity = scanner.next();
                        contact.setCity(newCity);
                        break;

                    case 5:
                        System.out.println("Enter new State");
                        String newState = scanner.next();
                        contact.setState(newState);
                        break;

                    case 6:
                        System.out.println("Enter new Zip code");
                        String newZip = scanner.next();
                        contact.setZip(newZip);
                        break;

                    case 7:
                        System.out.println("Enter new Phone Number");
                        String newPhoneNo = scanner.next();
                        contact.setPhoneNo(newPhoneNo);
                        break;

                    case 8:
                        System.out.println("Enter new Email");
                        String newEmail = scanner.next();
                        contact.setEmail(newEmail);
                        break;
                }
            }
        }
        if (found)
            System.out.println("SUCCESSFUL");
        else
            System.out.println("Name not found");
    }
    public void removePerson() {
        System.out.println("Enter a name you want to delete...");
        String removeName = scanner.next();

        boolean found = false;
        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getFirstName().equals(removeName)) {
                found = true;
                contactList.remove(i);
            }
        }
        if (found)
            System.out.println("SUCCESSFUL");
        else
            System.out.println("Name not found");

    }

}
