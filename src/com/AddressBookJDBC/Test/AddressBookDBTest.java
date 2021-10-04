package com.AddressBookJDBC.Test;

import com.AddressBookJDBC.AddressBookService.AddressBookDBService;
import com.AddressBookJDBC.AddressBookService.Person;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddressBookDBTest {
    @Test
    public void givenInsertIntoAddressBookMethod_whenUpdate_shouldMatch_updatedRowCount() {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        int updatedRecord = addressBookDBService.insertIntoAddressBook();
        Assert.assertEquals(1, updatedRecord);
    }

    @Test
    public void givenAddressBookDataBase_whenRetrieved_shouldMatch_personCount() {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        List<Person> personList = addressBookDBService.getPersonsDetails();
        Assert.assertEquals(5, personList.size());
    }
}
