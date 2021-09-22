package com.Bridgelabz;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddressbookJson {
    String filePath = "C:\\Users\\Sanju\\Desktop\\Address-Book_System\\src\\com\\Bridgelabz\\Person-Details.gson";
    public void writeAddressBook(Map<String, List<PersonInfo>> contactBook){
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            gson.toJson(contactBook, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readAddressBookJson(Map<String, List<PersonInfo>> contactBook){
        Gson gson = new Gson();
        try {
            contactBook = gson.fromJson(new FileReader(filePath), null);
            System.out.println(contactBook.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
