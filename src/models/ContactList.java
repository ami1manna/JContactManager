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

}
