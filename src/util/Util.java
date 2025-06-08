/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.Contact;

/**
 *
 * @author admin
 */
public class Util {
    
    public static String[][] get2DArray(ArrayList<Contact> contacts){
        int contNum = contacts.size();
        
        String[][] arr = new String[contNum][];
        
        
        for(int i = 0 ; i < contNum ; i++ ){
            arr[i] = contacts.get(i).toArray();
        }
        
        return arr;
    }
    
    public static ArrayList<Contact> getContactsFromFile() {

        ArrayList<Contact> contacts = new ArrayList<>();

        File fs = new File("contacts.xml");
        String fileData = readFile(fs);

        if (fileData == null) {
            return null;
        }

        String contactDetail = "\\<contact\\>\\s*\\<contact-id\\>(\\d+)\\<\\/contact-id\\>\\s*\\<first-name\\>(.*?)\\<\\/first-name\\>\\s*\\<last-name\\>(.*?)\\<\\/last-name\\>\\s*\\<phone\\>(.*?)\\<\\/phone\\>\\s*\\<email\\>(.*?)\\<\\/email\\>\\s*\\<address\\>(.*?)\\<\\/address\\>\\s*\\<\\/contact\\>";
        Pattern contactPattern = Pattern.compile(contactDetail, Pattern.DOTALL);

        Matcher contactMatcher = contactPattern.matcher(fileData);

        while (contactMatcher.find()) {

            contacts.add(new Contact(Integer.parseInt(contactMatcher.group(1)), contactMatcher.group(2), contactMatcher.group(3), contactMatcher.group(4), contactMatcher.group(5), contactMatcher.group(6)));
        }
            
        return contacts;
    }

    private static String readFile(File fs) {
        String output = "";
        try {

            FileInputStream stream = new FileInputStream(fs);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));

            String str = null;

            while ((str = br.readLine()) != null) {
                output += str + "\n";
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return null;

        } catch (IOException e) {
            return null;
        }
        return output;
    }

}
