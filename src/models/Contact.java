/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author admin
 */
public class Contact {
    
    private int contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;

    public Contact(int contactId, String firstName, String lastName, String phone, String email, String address) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    
    public String[] toArray(){
        return new String[]{
            String.valueOf(contactId),
            firstName,
            lastName,
            phone,
            email,
            address
        };
        
    }
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" + "contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + ", address=" + address + '}';
    }

   
    
}
