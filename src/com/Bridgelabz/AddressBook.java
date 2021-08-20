package com.Bridgelabz;

import java.util.Scanner;

public class AddressBook {
    Scanner sc = new Scanner(System.in);
    PersonInfo info =new PersonInfo();
    public void getInput() {
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
    }
    public void display(){
        System.out.println("first Name: " + info.getfirstName()+ "    LastName: "+info.getLastName()+ "\n" + "Address: " +info.getAddress()+"\n"+"City: " +info.getCity() +"\n"
                + "State: " +info.getState() + "\n" +"Zip: " +info.getZip() + "\n"+ "Phone No: " +info.getPhoneNo() +"\n" +"Email Address: " +info.getEmail());
    }
    public void editPersonInfo(){
        System.out.println("What you want to edit");
        System.out.println("1.Firstname  2.Lastname  3.Address  4.City  5.State  6.ZIP  7.Phone  8.Email");
        int option = sc.nextInt();
        switch (option) {

            case 1:
                System.out.println("Enter New:");
                info.setfirstName(sc.next());
                break;
            case 2:
                System.out.println("Enter New:");
                info.setLastName(sc.next());
                break;
            case 3:
                System.out.println("Enter New:");
                info.setAddress(sc.next());
                break;
            case 4:
                System.out.println("Enter New:");
                info.setCity(sc.next());
                break;
            case 5:
                System.out.println("Enter New:");
                info.setState(sc.next());
                break;
            case 6:
                System.out.println("Enter New:");
                info.setZip(sc.next());
                break;
            case 7:
                System.out.println("Enter New:");
                info.setPhoneNo(sc.next());
                break;
            case 8:
                System.out.println("Enter New:");
                info.setEmail(sc.next());
                break;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook creatContacts = new AddressBook();
        System.out.println("What you like to do? \n" +
                "1. Add contact \n" +
                "2. Display contact \n" +
                "3. Edit contact \n" +
                "0. Exit ");
        System.out.println("Enter the key -");
        int option = sc.nextInt();
        switch (option){
            case 1:
                creatContacts.getInput();
                break;
            case 2:
                creatContacts.display();
                break;
            case 3:
                creatContacts.editPersonInfo();
                break;
            default:
                System.exit(0);
                break;
        }

    }
}
