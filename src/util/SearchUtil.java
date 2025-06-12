
package util;

import java.util.ArrayList;
import models.Contact;
import models.ContactList;

public class SearchUtil {
    
    public static ArrayList<Contact> searchAll(String search){
        String searchLower = search.toLowerCase();
        
        ArrayList<Contact> result = new ArrayList<>();
        
        // traverse through all arraylist
        for(Contact contact : ContactList.contacts){
            
            //compare with all field 
            if(contact.getFirstName().toLowerCase().contains(searchLower)||
               contact.getLastName().toLowerCase().contains(searchLower)||
               contact.getPhone().contains(searchLower)||
               contact.getEmail().toLowerCase().contains(searchLower)){
            
                result.add(contact);
            }
        }
        
        return result;
    }
}