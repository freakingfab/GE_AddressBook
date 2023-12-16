package com.bridgelabz.addressbook;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
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
}
