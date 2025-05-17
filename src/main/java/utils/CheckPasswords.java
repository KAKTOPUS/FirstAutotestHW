package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPasswords {
    public boolean isPasswordEquals(String insertPassword, String confirmPassword) {
        Pattern pattern = Pattern.compile("^(?=[^\s]*\\s?[^\s]*$)[\\S\\s]{1,20}$");
        Matcher matcherInsertPassword = pattern.matcher(insertPassword);
        Matcher matcherConfirmPassword = pattern.matcher(confirmPassword);

        if (!matcherInsertPassword.find() || !matcherConfirmPassword.find()) {
            System.out.println("---Unacceptable password---");
            return false;
        }
        else if(insertPassword.equals(confirmPassword) && !insertPassword.equals("")) {
            return true;
        }
        else if (insertPassword.equals("") || confirmPassword.equals("")) {
            System.out.println("---Passwords cannot be empty!---");
            return false;
        }
        else {
            System.out.println("---Passwords is not equals!---");
            return false;
        }

    }
}
