package com.Bridgelabz;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AddressBookCsvService {
    File file = new File("C:\\Users\\Sanju\\Desktop\\Address-Book_System\\src\\com\\Bridgelabz\\Person-Details.csv");
    public void csvWritter(Map<String, List<PersonInfo>> contactBook){
        StringBuffer empBuffer = new StringBuffer();
        contactBook.forEach( (addbook, personInfos) -> {
            String empDataString = addbook.concat(",").concat(personInfos.toString().concat("\n"));
            empBuffer.append(empDataString);
        });

        try {
            Files.write(Paths.get(String.valueOf(file)) , empBuffer.toString().getBytes());
            System.out.println("File creat successfull");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void csvReader() throws IOException {
        File file = new File("C:\\Users\\Sanju\\Desktop\\Address-Book_System\\src\\com\\Bridgelabz\\Person-Details.csv");
        CSVReader csvReader = new CSVReader(new FileReader(file));
        String [] nextLine;
        while ((nextLine = csvReader.readNext()) != null) {
            for (String token : nextLine) {
                System.out.print(token);
            }
            System.out.println();
        }
    }
}
