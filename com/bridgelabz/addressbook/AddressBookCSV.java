package com.bridgelabz.addressbook;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
    @desc: class for implementing CSV operations in AddressBook
 */
public class AddressBookCSV {

    /*
        @desc: function to write contact objects to csv
        @params: List<Contact>, file path
     */
    public void writeContactsToCSV(List<Contact> contacts, String csvFilePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            // Writing the header
            String[] header = {"FirstName", "LastName", "Address", "City", "State", "Email", "ZipCode", "PhoneNo"};
            writer.writeNext(header);

            // Writing each contact to the CSV file
            for (Contact contact : contacts) {
                String[] row = {
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getAddress(),
                        contact.getCity(),
                        contact.getState(),
                        contact.getEmail(),
                        String.valueOf(contact.getZipCode()),
                        String.valueOf(contact.getPhoneNo())
                };
                writer.writeNext(row);
            }
            System.out.println("Contacts written to CSV successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        @desc: read from csv file
        @params:
        @return: List<Contact>
     */
    public static List<Contact> readContactsFromCSV(String csvFilePath) {
        List<Contact> contacts = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            // Skipping the header
            reader.readNext();
            // Reading each row and creating Contact objects
            String[] row;
            while ((row = reader.readNext()) != null) {
                Contact contact = new Contact();
                contact.setFirstName(row[0]);
                contact.setLastName(row[1]);
                contact.setAddress(row[2]);
                contact.setCity(row[3]);
                contact.setState(row[4]);
                contact.setEmail(row[5]);
                contact.setZipCode(Integer.parseInt(row[6]));
                contact.setPhoneNo(Long.parseLong(row[7]));
                contacts.add(contact);
            }
            System.out.println("Contacts read from CSV successfully!");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
