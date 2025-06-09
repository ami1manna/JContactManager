package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class ValidationUtil {
    private ValidationUtil(){
        throw new UnsupportedOperationException("Utility CLass");
    }
    public static boolean isValidEmail(String email){
            
        
        if(email == null || email.isEmpty()){ return false;}
        String emailRegex = "^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    
    }
    
    public static boolean isValidPhone(String phone){
             if(phone == null || phone.isEmpty()){ return false;}
        String phoneRegex = "^[6-9]\\d{9}$";
        
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        
        return matcher.matches();
    }
   
}
