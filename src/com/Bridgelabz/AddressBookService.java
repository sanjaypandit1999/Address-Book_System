package com.Bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class AddressBookService {
    String filePath = "C:\\Users\\Sanju\\Desktop\\Address-Book_System\\src\\com\\Bridgelabz\\Person-Details.txt";
    public void writeAddressBook(Map<String, List<PersonInfo>> contactBook) {
        StringBuffer empBuffer = new StringBuffer();
        contactBook.forEach( (addbook, contactInfo) -> {
            String empDataString = addbook.concat(contactInfo.toString().concat("\n"));
            empBuffer.append(empDataString);
        });

        try {
            Files.write(Paths.get(filePath) , empBuffer.toString().getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void readAddressBook() {
        try {
            Files.lines(new File(filePath).toPath())
                    .forEach(System.out::println);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
