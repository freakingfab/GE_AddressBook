package com.bridgelabz.addressbook;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@name: AddressBook
//@desc: list of contacts is stored
public class AddressBook{
    private List<Contact> contacts;
    private String bookName;

    //    @desc: constructor for class
    public AddressBook(String bookName){
        this.bookName=bookName;
        contacts = new ArrayList<>();
    }

    //    @desc: function for adding contacts
//    @params: com.bridgelabz.addressbook.Contact object
//    @return: void
    public void addContact(Contact C){
        if (!isDuplicate(C)) {
            contacts.add(C);
            System.out.println("Contact Added");
        } else {
            System.out.println("Duplicate Entry! Contact not added.");
        }
    }

    //    @desc: function for getting contacts
//    @params: none
//    @return: List<Contact>
    public List<Contact> getContacts(){
        return contacts;
    }

    //    @desc: function for deleting contacts
//    @params: com.bridgelabz.addressbook.Contact object
//    @return: void
    public void deleteContact(int index){
        contacts.remove(index);
        System.out.println("com.bridgelabz.addressbook.Contact Deleted");
    }


    //    @desc: function for editing contacts
//    @params: details for contact
//    @return: void
    public void editContact(Integer index, String firstName, String lastName, String address, String city, String state, String email, int zipCode, long phoneNo){
        Contact C = contacts.get(index);
        C.setFirstName(firstName);
        C.setLastName(lastName);
        C.setAddress(address);
        C.setState(state);
        C.setCity(city);
        C.setEmail(email);
        C.setPhoneNo(phoneNo);
        C.setZipCode(zipCode);
        contacts.set(index,C);
        System.out.print("com.bridgelabz.addressbook.Contact Edited");
    }
    /*
     @desc: check for duplicate values
     @params: Contact object
     @return: boolean
     */
    private boolean isDuplicate(Contact contact) {
        return contacts.stream().anyMatch(c -> c.equals(contact));
    }

    /*
        @desc: give list of people in given state
        @params: state
        @return: List<Contact>
     */
    public List<Contact> searchPersonInState(String state) {
        return contacts.stream()
                .flatMap(contacts -> this.getContacts().stream())
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    /*
       @desc: give list of people in given city
       @params: city
       @return: List<Contact>
    */
    public List<Contact> searchPersonInCity(String city) {
        return contacts.stream()
                .flatMap(addressBook -> this.getContacts().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
}


