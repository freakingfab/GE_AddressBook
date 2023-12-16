package com.bridgelabz.addressbook;

import java.util.Scanner;
import java.util.List;

public class Main {
    private static final int addContact = 1;
    private static final int displayContact = 2;

    private static final int editContact = 3;
    private static final int deleteContact=4;
    private static final int exit =5;

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        Scanner input = new Scanner(System.in);
        AddressBookSystem addressBooks = new AddressBookSystem();
        AddressBookCSV addressBookCSV = new AddressBookCSV();
        AddressBook contactBook1 = new AddressBook("Book1");
        addressBooks.add(contactBook1);
        for (AddressBook contactBook: addressBooks.getAddressBooks()) {
            int choice = -1;
            while (true) {
                System.out.println("======================");
                System.out.println("Add Contact -> 1");
                System.out.println("Display Contacts -> 2");
                System.out.println("Edit Contact ->3");
                System.out.println("Delete Contact -> 4");
                System.out.println("Exit-> 5");
                System.out.print("Please Enter the choice: ");
                choice = input.nextInt();
                if (choice == exit) {
                    break;
                }
                switch (choice) {
                    case addContact:
                        System.out.print("Enter First Name: ");
                        String firstName = input.next();
                        System.out.print("Enter Last Name: ");
                        String lastName = input.next();
                        System.out.print("Enter Address: ");
                        String address = input.next();
                        System.out.print("Enter State: ");
                        String state = input.next();
                        System.out.print("Enter City: ");
                        String city = input.next();
                        System.out.print("Enter email: ");
                        String email = input.next();
                        System.out.print("Enter ZipCode: ");
                        int zipCode = input.nextInt();
                        System.out.print("Enter Phone Number: ");
                        long phoneNo = input.nextLong();
                        Contact C = new Contact(firstName, lastName, address, city, state, email, zipCode, phoneNo);
                        contactBook.addContact(C);
                        break;

                    case displayContact:
                        System.out.println("Contacts displayed sorted acc. to city then state then zipcode");
                        List<Contact> sortedByCityStateZip = contactBook.sortContactsByCityStateZip();
                        addressBooks.displayBook(sortedByCityStateZip);
                        break;
                    case editContact:
                        System.out.print("Enter First Name: ");
                        firstName = input.next();
                        System.out.print("Enter Last Name: ");
                        lastName = input.next();
                        int cuC = addressBooks.getContact(contactBook.getContacts(), firstName, lastName);
                        if (cuC != -1) {
                            System.out.print("Enter First Name: ");
                            firstName = input.next();
                            System.out.print("Enter Last Name: ");
                            lastName = input.next();
                            System.out.print("Enter Address: ");
                            address = input.next();
                            System.out.print("Enter State: ");
                            state = input.next();
                            System.out.print("Enter City: ");
                            city = input.next();
                            System.out.print("Enter email: ");
                            email = input.next();
                            System.out.print("Enter ZipCode: ");
                            zipCode = input.nextInt();
                            System.out.print("Enter Phone Number: ");
                            phoneNo = input.nextLong();
                            contactBook.editContact(cuC, firstName, lastName, address, city, state, email, zipCode, phoneNo);
                        } else {
                            System.out.print("Contact Not Found");
                        }
                        break;
                    case deleteContact:
                        System.out.print("Enter First Name: ");
                        firstName = input.next();
                        System.out.print("Enter Last Name: ");
                        lastName = input.next();
                        int index = addressBooks.getContact(contactBook.getContacts(), firstName, lastName);
                        if (index != -1) {
                            contactBook.deleteContact(index);
                        } else {
                            System.out.println("Contact Not Found");
                        }
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
            addressBookCSV.writeContactsToCSV(contactBook.getContacts(), "contacts.csv");
        }

    }
}
