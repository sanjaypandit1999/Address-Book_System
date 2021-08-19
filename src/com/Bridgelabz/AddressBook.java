package com.Bridgelabz;

import java.util.Scanner;
import java.util.SimpleTimeZone;

public class AddressBook {
    public void getInput() {
        Scanner sc = new Scanner(System.in);
        PersonInfo info =new PersonInfo();
        System.out.println("Enter the personal details : ");
        System.out.print("Enter FIRST NAME: ");
        info.setfirstName(sc.next());
        System.out.print("Enter LAST NAME: ");
        info.setLastName(sc.next());
        System.out.print("Enter ADDRESS: ");
        info.setAddress(sc.next());
        System.out.print("Enter CITY: ");
        info.setCity(sc.next());
        System.out.print("Enter STATE: ");
        info.setState(sc.next());
        System.out.print("Enter ZIP: ");
        info.setZip(sc.next());
        System.out.print("Enter PHONE NUMBER: ");
        info.setPhoneNo(sc.next());
        System.out.print("Enter E-MAIL: ");
        info.setEmail(sc.next());
        System.out.println("first Name: " + info.getfirstName()+ "    LastName: "+info.getLastName()+ "\n" + "Address: " +info.getAddress()+"\n"+"City: " +info.getCity() +"\n"
                + "State: " +info.getState() + "\n" +"Zip: " +info.getZip() + "\n"+ "Phone No: " +info.getPhoneNo() +"\n" +"Email Address: " +info.getEmail());
    }

    public static void main(String[] args) {
        AddressBook creatContacts = new AddressBook();
        creatContacts.getInput();
    }
}
