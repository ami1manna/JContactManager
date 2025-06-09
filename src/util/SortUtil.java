/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.Comparator;
import models.Contact;
import models.ContactList;

public class SortUtil {
    
    public static void bubbleSort(Comparator<Contact> comparator){
    //   quick Sort 
        int n = ContactList.contacts.size();
        
        for(int i = 0 ; i < n - 1 ; i++){
            for(int j = 0 ;  j < n - 1  ;j++){
                Contact c1 = ContactList.contacts.get(j);
                Contact c2 = ContactList.contacts.get(j+1);
                
                if(comparator.compare(c1,c2) > 0){
                    ContactList.contacts.set(j, c2);
                    ContactList.contacts.set(j+1,c1);
                }
            }
        }

    }
    
    
    
}
