import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//@name: Contact
// @desc: class for creating contact objects
class Contact{
    private String firstName, lastName, address, city, state, email;
    private int zipCode;
    private long phoneNo;

//    @desc: constructor for Contact class
//    @params: details for contact
    public Contact(String firstName, String lastName, String address, String city, String state, String email, int zipCode, long phoneNo){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.email=email;
        this.zipCode=zipCode;
        this.phoneNo=phoneNo;
    }

//    @desc: getter and setters for all variable
//    @params: getter->none, setter->update variable
//    @return: getter->same as type of variable, setter->void
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    public String getState(){
        return this.state;
    }
    public void setState(String state){
        this.state=state;
    }

    public String getCity(){
        return this.city;
    }
    public void setCity(String city){
        this.city=city;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public Integer getZipCode(){
        return this.zipCode;
    }
    public void setZipCode(Integer zipCode){
        this.zipCode=zipCode;
    }

    public Long getPhoneNo(){
        return this.phoneNo;
    }
    public void setPhoneNo(Long phoneNo){
        this.phoneNo=phoneNo;
    }
}

//@name: AddressBook
//@desc: list of contacts is stored
class AddressBook{
    private List<Contact> contacts;
    private String bookName;

//    @desc: constructor for class
    public AddressBook(String bookName){
        this.bookName=bookName;
        contacts = new ArrayList<>();
    }

//    @desc: function for adding contacts
//    @params: Contact object
//    @return: void
    public void addContact(Contact C){
        contacts.add(C);
    }

//    @desc: function for getting contacts
//    @params: none
//    @return: List<Contact>
    public List<Contact> getContacts(){
        return contacts;
    }

//    @desc: function for deleting contacts
//    @params: Contact object
//    @return: void
    public void deleteContact(int index){
            contacts.remove(index);
            System.out.println("Contact Deleted");
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
            System.out.print("Contact Edited");
    }
}


public class AddressBookSystem {
    private static final int addContact = 1;
    private static final int displayContact = 2;

    private static final int editContact = 3;
    private static final int deleteContact=4;
    private static final int exit =5;
    private static List<AddressBook> addressBooks = new ArrayList<>(); ;
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        Scanner input = new Scanner(System.in);
        AddressBook contactBook1 = new AddressBook("Book1");
        addressBooks.add(contactBook1);
        AddressBook contactBook2 = new AddressBook("Book2");
        addressBooks.add(contactBook2);
        for (AddressBook contactBook: addressBooks) {
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
                        displayBook(contactBook.getContacts());
                        break;
                    case editContact:
                        System.out.print("Enter First Name: ");
                        firstName = input.next();
                        System.out.print("Enter Last Name: ");
                        lastName = input.next();
                        int cuC = getContact(contactBook.getContacts(), firstName, lastName);
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
                        int index = getContact(contactBook.getContacts(), firstName, lastName);
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
        }
    }

//    @desc: function for displaying contacts
//    @params: List of Contact object
//    @return: void
    private static void displayBook(List<Contact> contacts){
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
    private static int getContact(List<Contact> contacts, String firstName, String lastName){
        for (int i=0;i<contacts.size();i++) {
            Contact contact=contacts.get(i);
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                return i;
            }
        }
        return -1;
    }
}
