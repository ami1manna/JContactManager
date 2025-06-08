/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.Contact;

/**
 *
 * @author admin
 */
public class Util {

    public static String[][] get2DArray(ArrayList<Contact> contacts) {
        int contNum = contacts.size();

        String[][] arr = new String[contNum][];

        for (int i = 0; i < contNum; i++) {
            arr[i] = contacts.get(i).toArray();
        }

        return arr;
    }

    public static void setContactsToFile(ArrayList<Contact> contacts) {

        String output = "<contact-book>\n";
        for (Contact con : contacts) {
            String out ="""
\t<contact>
\t\t<contact-id>%d</contact-id>
\t\t<first-name>%s</first-name>
\t\t<last-name>%s</last-name>
\t\t<phone>%s</phone>
\t\t<email>%s</email>
\t\t<address>%s</address>
\t</contact>
""";
            output += String.format(out, con.getContactId(), con.getFirstName(), con.getLastName(),
                    con.getPhone(),
                    con.getEmail(),
                    con.getAddress());
        
        }
        output += "</contact-book>";
        
        writeFile(new File("contacts.xml"),output);
       
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
        FileInputStream stream = null;
        BufferedReader br = null;
        try {

            stream = new FileInputStream(fs);
            br = new BufferedReader(new InputStreamReader(stream));

            String str = null;

            while ((str = br.readLine()) != null) {
                output += str + "\n";
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return null;

        } catch (IOException e) {
            return null;
        } finally {
            try {
                stream.close();
                 br.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return output;
    }

    private static void writeFile(File fs, String data) {

        FileOutputStream fout = null;
        PrintWriter pw = null;

        try {
            fout = new FileOutputStream(fs, false);
            pw = new PrintWriter(fout,true);

            pw.print(data);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pw.close();
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
