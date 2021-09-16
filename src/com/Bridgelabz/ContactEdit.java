package com.Bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

public class ContactEdit {
    HashMap<String, ArrayList<PersonInfo>> contactBook = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public ArrayList<PersonInfo> addPerson(ArrayList<PersonInfo> contactList) {
        try {
            System.out.println("Enter following details \n" +
                    "First Name :");
            String firstName = scanner.next();
            int existName = searchPerson(firstName, contactList);
            if (existName == -1) {
                PersonInfo contact = new PersonInfo();
                contact.setFirstName(firstName);
                System.out.println("Last Name :");
                String lastName = scanner.next();
                contact.setLastName(lastName);
                System.out.println("Address :");
                String address = scanner.next();
                contact.setAddress(address);
                System.out.println("City :");
                String city = scanner.next();
                contact.setCity(city);
                System.out.println("State :");
                String state = scanner.next();
                contact.setState(state);
                System.out.println("Zip Code :");
                int zip = scanner.nextInt();
                contact.setZip(zip);
                System.out.println("Phone Number :");
                long phoneNo = scanner.nextLong();
                contact.setPhoneNo(phoneNo);
                System.out.println("Email :");
                String email = scanner.next();
                contact.setEmail(email);
                contactList.add(contact);
            } else
                System.out.println("Name already exist");
        } catch (InputMismatchException e) {
            System.out.println("Please enter correct details");
        }
        return contactList;
    }

    public void displayPerson(ArrayList<PersonInfo> contactList) {
        System.out.println("All contact =  " + contactList.size());
        System.out.println(contactList);

    }

    public int searchPerson(String searchName, ArrayList<PersonInfo> contactList) {
        try {
            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getFirstName().equals(searchName)) {
                    return i;
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter the correct details");
        }
        return -1;
    }

    public void editPerson(ArrayList<PersonInfo> contactList) {
        try {
            System.out.println("Enter a firstname you want to edit...");
            String name = scanner.next();
            int editName = searchPerson(name, contactList);
            if (editName == -1) {
                System.out.println("Name not found");
            } else {
                PersonInfo contact = contactList.get(editName);
                System.out.println("Name found " + editName);
                System.out.println("What do you want to edit \n" +
                        "1. First Name / 2. Last Name / 3. Address / 4. City / " +
                        "5. State / 6. Zip code / 7. Phone Number / 8. Email");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter new First Name");
                        String newFirstName = scanner.next();
                        contact.setFirstName(newFirstName);
                        System.out.println("Person firstname edited successfull");
                        break;

                    case 2:
                        System.out.println("Enter new Last Name");
                        String newLastName = scanner.next();
                        contact.setLastName(newLastName);
                        System.out.println("Person lastname edited successfull");
                        break;

                    case 3:
                        System.out.println("Enter new Address");
                        String newAddress = scanner.next();
                        contact.setAddress(newAddress);
                        System.out.println("Person Address edited successfull");
                        break;

                    case 4:
                        System.out.println("Enter new City");
                        String newCity = scanner.next();
                        contact.setCity(newCity);
                        System.out.println("Person city edited successfull");
                        break;

                    case 5:
                        System.out.println("Enter new State");
                        String newState = scanner.next();
                        contact.setState(newState);
                        System.out.println("Person state edited successfull");
                        break;

                    case 6:
                        System.out.println("Enter new Zip code");
                        int newZip = scanner.nextInt();
                        contact.setZip(newZip);
                        System.out.println("Person zip code edited successfull");
                        break;

                    case 7:
                        System.out.println("Enter new Phone Number");
                        long newPhoneNo = scanner.nextInt();
                        contact.setPhoneNo(newPhoneNo);
                        System.out.println("Person phone no edited successfull");
                        break;

                    case 8:
                        System.out.println("Enter new Email");
                        String newEmail = scanner.next();
                        contact.setEmail(newEmail);
                        System.out.println("Person email edited successfull");
                        break;
                    default:
                        System.out.println("You entered invalid number");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter the correct details");
        }
    }


    public void removePerson(ArrayList<PersonInfo> contactList) {
        try {
            System.out.println("Enter a name you want to delete...");
            String deleteName = scanner.next();
            int removeName = searchPerson(deleteName, contactList);
            if (removeName == -1) {
                System.out.println("name not found");
            } else {
                contactList.remove(removeName);
                System.out.println("Successfully Remove ");
            }
        } catch (Exception e) {
            System.out.println("Please enter the correct details");
        }
    }

    public void searchInLocation() {
        Hashtable<String, List<String>> searchResult = new Hashtable<>();
        List<String> contactList;
                System.out.println("1.City   \n " +
                                   "2.State  \n" );
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Enter The City For Search Persons ");
                        String nameSearchByCity = scanner.next();
                        for (String keyOfBook : contactBook.keySet()) {
                            contactList = new ArrayList<>();
                            for (int index = 0; index < contactBook.get(keyOfBook).size(); index++) {
                                if (contactBook.get(keyOfBook).get(index).getCity().equals(nameSearchByCity))
                                    contactList.add(contactBook.get(keyOfBook).get(index).getFirstName());
                            }
                            if (!contactList.isEmpty())
                                searchResult.put(keyOfBook, contactList);
                        }
                        break;
                    case 2:
                        System.out.println("Enter The State For Search Persons");
                        String nameForState = scanner.next();
                        for (String keyOfBook : contactBook.keySet()) {
                            contactList = new ArrayList<>();
                            for (int index = 0; index < contactBook.get(keyOfBook).size(); index++) {
                                if (contactBook.get(keyOfBook).get(index).getState().equals(nameForState))
                                    contactList.add(contactBook.get(keyOfBook).get(index).getFirstName());
                            }
                            if (!contactList.isEmpty())
                                searchResult.put(keyOfBook, contactList);
                        }
                        break;
                }
    }

    public ArrayList<PersonInfo> addMulPerson(ArrayList<PersonInfo> contactList, HashMap<String, ArrayList<PersonInfo>>contactBook, String name) {
        try {
            boolean found = true;
            while (found) {
                System.out.println("\nWhat would u like to do with contacts? \n" +
                        "1. ADD     \n" +
                        "2. DISPLAY \n" +
                        "3. EDIT    \n" +
                        "4. REMOVE  \n" +
                        "0. EXIT    \n");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        ArrayList<PersonInfo> mulContact = addPerson(contactList);
                        contactBook.put(name, mulContact);
                        break;
                    case 2:
                        displayPerson(contactList);
                        break;

                    case 3:
                        editPerson(contactList);
                        break;

                    case 4:
                        removePerson(contactList);
                        break;
                    default: found= false;
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("Please enter the correct details");
        }
        return contactList;
    }

    public void addMulAddressBook() {
        try {
            while (true) {
                System.out.println("\nWhat would you like to do? \n" +
                        "1. Crate new address book \n" +
                        "2. Continue with existing address book \n" +
                        "3. All books \n" +
                        "4. search location \n" +
                        "0. EXIT");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter name for Address book");
                        String newBook = scanner.next();
                        ArrayList<PersonInfo> contactList = new ArrayList<>();
                        if (contactBook.containsKey(newBook))
                            System.out.println("Book already exists");
                        else
                        addMulPerson(contactList, contactBook, newBook);
                        break;

                    case 2:
                        System.out.println(contactBook.keySet());
                        System.out.println("Which address book do you want to access?");
                        String existingBook = scanner.next();

                        if (contactBook.containsKey(existingBook)) {
                            contactList = contactBook.get(existingBook);
                            addMulPerson(contactList, contactBook, existingBook);
                        } else
                            System.out.println("Book not found");
                        break;

                    case 3:
                        int serialNo = 1;
                        for (String book : contactBook.keySet()) {
                            System.out.println(serialNo + ". " + book );
                            serialNo++;
                        }

                        System.out.println("\n" + contactBook);
                        break;
                    case 4:
                        searchInLocation();
                        break;

                    default:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
