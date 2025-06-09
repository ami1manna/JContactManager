/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Comparator;
import models.Contact;

/**
 *
 * @author Lenovo
 */
public class ContactComparators {
    //asc
    
    public static Comparator<Contact> byFirstNameAsc = Comparator.comparing(Contact::getFirstName,String.CASE_INSENSITIVE_ORDER);
    public static Comparator<Contact> byLastNameAsc = Comparator.comparing(Contact::getLastName,String.CASE_INSENSITIVE_ORDER);
    public static Comparator<Contact> byEmailAsc = Comparator.comparing(Contact::getEmail,String.CASE_INSENSITIVE_ORDER);
    
    //desc.
    public static Comparator<Contact> byFirstNameDesc = (c1,c2)->c2.getFirstName().compareToIgnoreCase(c1.getFirstName());
    public static Comparator<Contact> byLastNameDesc  = (c1,c2)->c2.getLastName().compareToIgnoreCase(c1.getLastName());
    public static Comparator<Contact> byEmailDesc = (c1,c2)->c2.getEmail().compareToIgnoreCase(c1.getEmail());
}
