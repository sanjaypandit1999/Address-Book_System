package com.AddressBookJDBC.AddressBookService;

import java.util.List;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        addressBookDBService.getPersonsDetails();
        List<Person> personList = addressBookDBService.getPersonsDetails();
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
