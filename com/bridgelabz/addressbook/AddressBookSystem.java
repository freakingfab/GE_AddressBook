package com.bridgelabz.addressbook;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class AddressBookSystem {
    public static List<AddressBook> addressBooks;

    /*
        @desc: constructor for the class
        @params: none
        @return: none
     */
    public AddressBookSystem(){
        addressBooks = new ArrayList<>();
    }

    /*
        @desc: getter for the list
        @param: none
        @return List
     */
    public List<AddressBook> getAddressBooks(){
        return addressBooks;
    }
    /*
        @desc: add the addressBook in the system
        @params: AddressBook
        @return: none
     */
    public void add(AddressBook node){
        addressBooks.add(node);
    }

//    @desc: function for displaying contacts
//    @params: List of com.bridgelabz.addressbook.Contact object
//    @return: void
    public static void displayBook(List<Contact> contacts){
        System.out.println("Address Book");
        for (int i = 0; i < contacts.size(); i++) {
            Contact currContact = contacts.get(i);
            System.out.println("======================");
            System.out.println("First Name: " + currContact.getFirstName());
            System.out.println("Last Name: " + currContact.getLastName());
            System.out.println("Address: " + currContact.getAddress());
            System.out.println("State: " + currContact.getState());
            System.out.println("City: " + currContact.getCity());
            System.out.println("Email: " + currContact.getEmail());
            System.out.println("ZipCode: " + currContact.getZipCode());
            System.out.println("PhoneNo: " + currContact.getPhoneNo());
        }
    }

//    @desc: function for getting index of searched contact
//    @params: List of contacts, firstname, lastname
//    @return: index of contact
    public static int getContact(List<Contact> contacts, String firstName, String lastName){
        for (int i=0;i<contacts.size();i++) {
            Contact contact=contacts.get(i);
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                return i;
            }
        }
        return -1;
    }


}
