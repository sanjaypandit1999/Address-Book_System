package com.AddressBookJDBC.AddressBookService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.AddressBookJDBC.DBconfig.AdddressBoookDBConfig.getDbConfig;

public class AddressBookDBService {
    List<Person> personList;
    PreparedStatement preparedStatement;
    Connection connection = getDbConfig();
    Scanner scanner = new Scanner(System.in);
    public void createTableAddressBook() {
        String CREATE_TABLE_QUERY = "create table addressbook(ID int NOT NULL AUTO_INCREMENT UNIQUE,ADDRESSBOOK_NAME varchar(150) NOT NULL,FIRST_NAME varchar(150) NOT NULL,LAST_NAME varchar(150) NOT NULL,GENDER varchar(1) NOT NULL,ADDRESS varchar(150) NOT NULL,CITY varchar(50) NOT NULL,STATE varchar(50) NOT NULL,ZIP_CODE int NOT NULL,PHONE_NUMBER int NOT NULL,START_DATE varchar(50) NOT NULL)";
        try {
            preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
            preparedStatement.executeUpdate();
            System.out.println("QUERY EXECUTED");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int insertIntoAddressBook() {
        String INSERT_QUERY = "insert into addressbook (FIRST_NAME,LAST_NAME,ADDRESS,CITY,STATE,ZIP_CODE,PHONE_NUMBER,Email,Type)values(?,?,?,?,?,?,?,?,?)";
        int row = 0;
        try {
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            System.out.println("ENTER THE FIRST NAME :");
            String firstName = scanner.next();
            System.out.println("ENTER THE LAST NAME :");
            String lastName = scanner.next();
            System.out.println("ENTER THE ADDRESS :");
            String address = scanner.next();
            System.out.println("ENTER THE CITY :");
            String city = scanner.next();
            System.out.println("ENTER THE STATE :");
            String state = scanner.next();
            System.out.println("ENTER THE ZIP CODE :");
            int zipCode = scanner.nextInt();
            System.out.println("ENTER THE PHONE NUMBER :");
            long phone = scanner.nextLong();
            System.out.println("ENTER THE Email :");
            String email = scanner.next();
            System.out.println("ENTER THE Relation :");
            String type = scanner.next();
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, state);
            preparedStatement.setInt(6, zipCode);
            preparedStatement.setLong(7, phone);
            preparedStatement.setString(8, email);
            preparedStatement.setString(9,type);

            row = preparedStatement.executeUpdate();
            System.out.println(row + "row inserted");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }
    public List<Person> getPersonsDetails() {
        String FETCH_RECORD_QUERY = "select * from addressbook ";
        Person person;
        personList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(FETCH_RECORD_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person = new Person();
                person.setFirstName(resultSet.getString("FIRST_NAME"));
                person.setLastName(resultSet.getString("LAST_NAME"));
                person.setAddress(resultSet.getString("ADDRESS"));
                person.setCity(resultSet.getString("CITY"));
                person.setState(resultSet.getString("STATE"));
                person.setZipcode(resultSet.getInt("ZIP_CODE"));
                person.setPhoneNumber(resultSet.getLong("PHONE_NUMBER"));
                person.setType(resultSet.getString("Type"));
                personList.add(person);
            }
            System.out.println("QUERY EXECUTED");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return personList;
    }

}
