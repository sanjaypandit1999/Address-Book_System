package com.Bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class ContactEdit {
    AddressbookJson addressbookJson = new AddressbookJson();
    Map<String, List<PersonInfo>> contactBook = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public List<PersonInfo> addPerson(List<PersonInfo> contactList) {
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
                contactList = contactList
                        .stream()
                        .sorted(Comparator.comparing(PersonInfo::getFirstName))
                        .collect(Collectors.toList());
            } else
                System.out.println("Name already exist");
        } catch (InputMismatchException e) {
            System.out.println("Please enter correct details");
        }
        return contactList;
    }

    public void displayPerson(List<PersonInfo> contactList) {
        System.out.println("All contact =  " + contactList.size());
        System.out.println(contactList);

    }

    public int searchPerson(String searchName, List<PersonInfo> contactList) {
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

    public void editPerson(List<PersonInfo> contactList) {
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

    public void removePerson(List<PersonInfo> contactList) {
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
        try {
            System.out.println("1.Find contact Search by City   \n " +
                               "2.Find contact Search by State  \n");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter The City Name For Find PersonInfo ");
                    String enterCity = scanner.next();
                    contactBook.keySet().forEach(keyBook -> {
                        List<PersonInfo> personInfoList = contactBook.get(keyBook).stream()
                                                         .filter(n -> n.getCity().equals(enterCity))
                                                         .collect(Collectors.toList());
                        System.out.println("Address book name  " + keyBook + " Person info size is " + personInfoList.size());
                        System.out.println(personInfoList);
                    });

                    break;
                case 2:
                    System.out.println("Enter The State Name For Find BookInfo ");
                    String enterState = scanner.next();
                    contactBook.keySet().forEach(keyBook -> {
                        List<PersonInfo> personInfoList = contactBook.get(keyBook).stream()
                                .filter(n -> n.getCity().equals(enterState))
                                .collect(Collectors.toList());
                        System.out.println("Address book name  " + keyBook + " Person info size is " + personInfoList.size());
                        System.out.println(personInfoList);
                    });
                    break;
            }
        }catch (Exception e){
            System.out.println("Please enter correct");
        }
    }

    public void getMobileNo(String name){
        try {
            for (String keyOfBook : contactBook.keySet()) {
                for (int index = 0; index < contactBook.get(keyOfBook).size(); index++) {
                    if (contactBook.get(keyOfBook).get(index).getFirstName().equals(name)) {

                        String lastName = contactBook.get(keyOfBook).get(index).getLastName();
                        long phoneNo = contactBook.get(keyOfBook).get(index).getPhoneNo();

                        System.out.println("Book Name" +keyOfBook + " : " + name + " " + lastName + "Mobile No --> " + phoneNo);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter correct");
        }
    }

    public void sortPerson() {
        try {
            boolean run = true;
            while (run) {
                System.out.println("How Would you like to sort\n" +
                        "1. By City\n" +
                        "2. By State\n" +
                        "3. By Zip\n" +
                        "0. EXIT");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Sorted by city");
                        contactBook.keySet().forEach(keyOfBook -> {
                            List<PersonInfo> personInfoList = contactBook.get(keyOfBook)
                                    .stream()
                                    .sorted(Comparator.comparing(PersonInfo::getCity))
                                    .collect(Collectors.toList());
                            System.out.println(personInfoList);

                        });
                        break;
                    case 2:
                        System.out.println("Sorted by state");
                        contactBook.keySet().forEach(keyOfBook -> {
                            List<PersonInfo> personInfoList = contactBook.get(keyOfBook)
                                    .stream()
                                    .sorted(Comparator
                                            .comparing(PersonInfo::getState))
                                    .collect(Collectors.toList());
                            System.out.println(personInfoList);
                        });
                        break;
                    case 3:
                        System.out.println("Sorted By Zip");
                        contactBook.keySet().forEach(keyOfBook -> {
                            List<PersonInfo> personInfoList = contactBook.get(keyOfBook)
                                    .stream()
                                    .sorted(Comparator
                                            .comparing(PersonInfo::getZip))
                                    .collect(Collectors.toList());
                            System.out.println(personInfoList);
                        });
                        break;
                    case 0:
                        run = false;
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("Please correct " +e);
        }
    }

    public void addMulPerson(List<PersonInfo> contactList, Map<String, List<PersonInfo>>contactBook, String name) {
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
                        List<PersonInfo> mulContact = addPerson(contactList);
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
    }

    public void addMulAddressBook() {
        AddressBookService addressBookService = new AddressBookService();
        try {
            while (true) {
                System.out.println("\nWhat would you like to do? \n" +
                        "1. Crate new address book \n" +
                        "2. Continue with existing address book \n" +
                        "3. Display All books \n" +
                        "4. PersonInfo search By CIty/State  \n" +
                        "5. Get Mobile No  \n" +
                        "6. Sort PersonInfo\n" +
                        "0. EXIT");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter name for Address book");
                        String newBook = scanner.next();
                        List<PersonInfo> contactList = new ArrayList<>();
                        if (contactBook.containsKey(newBook))
                            System.out.println("Book already exists");
                        else
                        addMulPerson(contactList, contactBook, newBook);
                        addressbookJson.writeAddressBook(contactBook);
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
                        addressbookJson.readAddressBookJson(contactBook);
                        break;
                    case 4:
                        searchInLocation();
                        break;
                    case 5:
                        System.out.println("Enter First Name");
                        String nameForContact = scanner.next();
                        getMobileNo(nameForContact);
                    case 6:
                        sortPerson();
                        break;

                    default:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter correct " + e);
        }
    }
}
