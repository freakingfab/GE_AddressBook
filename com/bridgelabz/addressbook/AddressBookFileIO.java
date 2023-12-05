package com.bridgelabz.addressbook;

import java.io.*;
public class AddressBookFileIO {
    /*
        @desc: write address books to file
        @params: object(AddressBook), filename
        @return: none
     */
    public static void writeToFile(AddressBook addressBook, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(addressBook);
            System.out.println("Address Book has been written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        @desc: reads address books from file
        @params: filename
        @return: AddressBook
     */
    public static AddressBook readFromFile(String fileName) {
        AddressBook addressBook = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            addressBook = (AddressBook) ois.readObject();
            System.out.println("Address Book has been read from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return addressBook;
    }
}
