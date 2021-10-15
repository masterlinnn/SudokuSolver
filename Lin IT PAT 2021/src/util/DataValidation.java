/**
 * @author masterlinnn
 * @project Sudoku Solver
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {

    public boolean checkPresent(String inText){
     if (inText.equals("")) {
            return false;
        } else {
            return true;
        }
    }
   
    /*====================Validate Username=====================*/
    public boolean usernameValidate(String inUsername) {
        /*
        For Valid Username:
        1.  Username Must Be Between 4 And 16 Characters Long
        2.  Username Must Have No Spaces
         */
        String userNameRegex = "^(?=.{4,16}$).*^([a-zA-Z0-9]*)$";
        Pattern userNamePattern = Pattern.compile(userNameRegex); //Compile Username String Regex To Regex

        Matcher m = userNamePattern.matcher(inUsername); // Determine If The Input Regex Matche The Regex Required

        if (m.matches() == true) {
            return true;
        } else {
            return false;
        }
    }

    /*====================Validate Username=====================*/

 /*====================Validate Password=====================*/
    public boolean passwordValidate(String inPassword) {
        /*
        For Valid Password:
        1.  Password Must Between 4 And 16 Characters Long
        2.  Password Must Contain a Capital Case
        3.  Password Must Have At Least One Number
         */
        String passwordRegex = "^(?=.*?[A-Z])" + "(?=.*?[0-9])" + ".{4,16}$";

        Pattern passwordPattern = Pattern.compile(passwordRegex); //Compile Password String Regex To Regex
        Matcher m = passwordPattern.matcher(inPassword); // Determine If The Input Regex Matche The Regex Required

        if (m.matches() == true) {
            return true;
        } else {
            return false;
        }
    }
    /*====================Validate Password=====================*/
    
    public boolean matchPassword(String inPassword, String inConfirmPassword) {
          if (!inPassword.equals("") && inPassword.equals(inConfirmPassword)) return true;
          else return false;
    }
    
}
