/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import static util.Util.getContactsFromFile;

/**
 *
 * @author admin
 */
public class ContactList {

    public static ArrayList<Contact> contacts;

    static {
        contacts = getContactsFromFile();
    }
    
    
    public static void create(Contact contact){
        
        contacts.add(contact);
    }
    public static void delete(Contact contact) {

        contacts.remove(contact);

    }

    public static void update(Contact contact) {

        int index = findContactIndex(contact.getContactId());
        contacts.set(index, contact);

    }

    private static int findContactIndex(int id) {

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId() == id) {
                return i;
            }
        }
        return -1;

    }

    private static Contact findContact(int id) {
        for (Contact con : contacts) {
            if (con.getContactId() == id) {
                return con;
            }
        }
        return null;
    }

    /**
     * Search contacts by any field containing the search term
     * @param searchTerm The term to search for
     * @return List of contacts matching the search term
     */
    public static ArrayList<Contact> searchContacts(String searchTerm) {
        ArrayList<Contact> results = new ArrayList<>();
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return results;
        }
        
        searchTerm = searchTerm.toLowerCase().trim();
        
        for (Contact contact : contacts) {
            if (matchesSearchTerm(contact, searchTerm)) {
                results.add(contact);
            }
        }
        return results;
    }
    
    /**
     * Check if a contact matches the search term in any field
     */
    private static boolean matchesSearchTerm(Contact contact, String searchTerm) {
        return (contact.getFirstName() != null && contact.getFirstName().toLowerCase().contains(searchTerm)) ||
               (contact.getLastName() != null && contact.getLastName().toLowerCase().contains(searchTerm)) ||
               (contact.getPhone() != null && contact.getPhone().toLowerCase().contains(searchTerm)) ||
               (contact.getEmail() != null && contact.getEmail().toLowerCase().contains(searchTerm)) ||
               (contact.getAddress() != null && contact.getAddress().toLowerCase().contains(searchTerm));
    }
    
    /**
     * Search contacts by specific field
     * @param field The field to search in (firstName, lastName, phone, email, address)
     * @param searchTerm The term to search for
     * @return List of contacts matching the search criteria
     */
    public static ArrayList<Contact> searchContactsByField(String field, String searchTerm) {
        ArrayList<Contact> results = new ArrayList<>();
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return results;
        }
        
        searchTerm = searchTerm.toLowerCase().trim();
        
        for (Contact contact : contacts) {
            switch (field.toLowerCase()) {
                case "firstname":
                    if (contact.getFirstName() != null && contact.getFirstName().toLowerCase().contains(searchTerm)) {
                        results.add(contact);
                    }
                    break;
                case "lastname":
                    if (contact.getLastName() != null && contact.getLastName().toLowerCase().contains(searchTerm)) {
                        results.add(contact);
                    }
                    break;
                case "phone":
                    if (contact.getPhone() != null && contact.getPhone().toLowerCase().contains(searchTerm)) {
                        results.add(contact);
                    }
                    break;
                case "email":
                    if (contact.getEmail() != null && contact.getEmail().toLowerCase().contains(searchTerm)) {
                        results.add(contact);
                    }
                    break;
                case "address":
                    if (contact.getAddress() != null && contact.getAddress().toLowerCase().contains(searchTerm)) {
                        results.add(contact);
                    }
                    break;
            }
        }
        return results;
    }

}
