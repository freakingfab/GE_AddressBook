import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//@name: Contact
// @desc: class for creating contact objects
class Contact{
    private String firstName, lastName, address, city, state, email;
    private int zipCode;
    private long phoneNo;

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

class AddressBook{
    private List<Contact> contacts;

    public AddressBook(){
        contacts = new ArrayList<>();
    }

    public void addContact(Contact C){
        contacts.add(C);
    }

    public List<Contact> getContacts(){
        return contacts;
    }

    public void deleteContact(Contact C){
        if(contacts.contains(C)){
            contacts.remove(C);
            System.out.println("Contact Deleted");
        }
        else{
            System.out.println("Contact Not Found");
        }
    }

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
    public static void main(String[] args){
    
    }
}
