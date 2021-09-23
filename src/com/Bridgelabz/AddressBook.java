package com.Bridgelabz;

import org.apache.commons.csv.CSVParser;

import java.io.IOException;

public class AddressBook {
    public static void main(String[] args) throws IOException {
        ContactEdit contactinfo = new ContactEdit();
        contactinfo.addMulAddressBook();
        AddressBookCsvService addressBookCsvService = new AddressBookCsvService();
    }
}
