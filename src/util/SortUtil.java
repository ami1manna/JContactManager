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
    public static void quickSort(int low , int high ,Comparator<Contact> comparator){
        
        if(low < high){
            
        
        int pivotIndex  = pivot(low,high,comparator);
        System.out.println(pivotIndex);
        quickSort(low , pivotIndex - 1 , comparator);
        quickSort(pivotIndex + 1, high , comparator);
        } 
         
    }
    
    private static int pivot(int low ,int high , Comparator<Contact> comparator){
        
        int piv = low;
        Contact pivContact = ContactList.contacts.get(piv);
        
        while(low < high){
            //left sort
            Contact c1 = ContactList.contacts.get(low);
            Contact c2 = ContactList.contacts.get(high);
            
            while(comparator.compare(c1, pivContact) <= 0 && low <= high - 1){
               c1 = ContactList.contacts.get(++low); 
            }
            
            while(comparator.compare(c2, pivContact) > 0 && high >= low + 1){
               c2 = ContactList.contacts.get(--high); 
            }
            
            ContactList.contacts.set(low, c2);
            ContactList.contacts.set(high,c1);
            
            //right sort
        }
        
        ContactList.contacts.set(piv,ContactList.contacts.get(high));
        ContactList.contacts.set(high, pivContact);
        
        return low;
    }
  
    
    
    
    
}
