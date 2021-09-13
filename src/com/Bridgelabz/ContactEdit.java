package com.Bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ContactEdit {
    ArrayList<PersonInfo> contactList = new ArrayList<PersonInfo>();
    HashMap<String, ArrayList<PersonInfo>> contactBook = new HashMap<String, ArrayList<PersonInfo>>();
    Scanner scanner = new Scanner(System.in);
    PersonInfo contact = new PersonInfo();

    public ArrayList<PersonInfo> addPerson() {

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
        int zip = scanner.nextInt();
        System.out.println("Phone Number :");
        long phoneNo = scanner.nextLong();
        System.out.println("Email :");
        String email = scanner.next();

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZip(zip);
        contact.setPhoneNo(phoneNo);
        contact.setEmail(email);
        contactList.add(contact);
        return contactList;
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
                        int newZip = scanner.nextInt();
                        contact.setZip(newZip);
                        break;

                    case 7:
                        System.out.println("Enter new Phone Number");
                        long newPhoneNo = scanner.nextInt();
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

    public ArrayList<PersonInfo> addMulPerson() {

        while (true) {
            System.out.println("\nWhat would u like to do with contacts? \n" +
                    "1. ADD     \n" +
                    "2. DISPLAY \n" +
                    "3. EDIT    \n" +
                    "4. REMOVE  \n" +
                    "0. EXIT    \n");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    displayPerson();
                    break;

                case 3:
                    editPerson();
                    break;

                case 4:
                    removePerson();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public void addMulAddressBook() {
        while (true) {
            System.out.println("\nWhat would you like to do? \n" +
                    "1. Crate new address book \n" +
                    "2. Continue with existing address book \n" +
                    "3. All books \n" +
                    "0. EXIT");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter name for Address book");
                    String bookName = scanner.next();
                    contactBook.put(bookName, addPerson());
                    break;

                case 2:
                    System.out.println(contactBook.keySet());
                    System.out.println("Which address book do you want to access?");
                    String existingBook = scanner.next();

                    if (contactBook.containsKey(existingBook)) {
                        contactBook.get(existingBook);
                        addMulPerson();
                    } else
                        System.out.println("Book not found");
                    break;

                case 3:
                    int serialNo = 1;
                    for (String book : contactBook.keySet()) {
                        System.out.println(serialNo + ". " + book);
                        serialNo++;
                    }

                    System.out.println("\n" + contactBook);
                    break;

                default:
                    System.exit(0);
            }
        }
    }
}
