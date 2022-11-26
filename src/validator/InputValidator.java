/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.swing.JOptionPane;

/**
 *
 * @author zeyad
 */
public class InputValidator {

    
    /**
     * 
     * @param s is the text that inserted from user 
     * String must be contain only characters and not empty
     * @return 
     */
    public static boolean validInput(String s) {
        if (s.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "name should not be empty");
            return false; 
        }
        if(!onlyChars(s)){
             JOptionPane.showMessageDialog(null, "name must contain onlt letters from A - Z");
             return false; 
        }
        return true ; 
    }

    private static boolean onlyChars(String s) {
        boolean valid = true;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
            } else {
                valid = false;
              
                break;
            }
        }
        return valid; 
    }

    public static boolean validID(String id) {
        if (id.length() != 5) {
            JOptionPane.showMessageDialog(null, "Id must be 5 digits");
            return false;
        }
        if (!onlyDigits(id)) {
            return false;
        }
        return true;
    }

    
    private static boolean onlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Id must contain only digits");
                return false;
            }
        }
        return true;
    }

}
