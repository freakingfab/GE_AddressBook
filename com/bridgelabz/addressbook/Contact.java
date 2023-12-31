package com.bridgelabz.addressbook;

import java.io.Serializable;
import java.util.Objects;

//@name: com.bridgelabz.addressbook.Contact
// @desc: class for creating contact objects
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName, lastName, address, city, state, email;
    private int zipCode;
    private long phoneNo;

    //    @desc: constructor for com.bridgelabz.addressbook.Contact class
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

    public Contact(){
        // empty constructor
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

    /*
        @desc: checking for duplicates
        @params: Object
        @return: boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return Objects.equals(getFirstName(), contact.getFirstName()) &&
                Objects.equals(getLastName(), contact.getLastName());
    }
}

