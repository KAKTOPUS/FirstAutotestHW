package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCorrectEmail {
    public boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^(?=.{1,30}@)[a-zA-Z0-9._-]{1,30}@[a-zA-Z0-9._-]{1,7}$");
        Matcher matcher = pattern.matcher(email);
        if(email.length() > 38) {
            System.out.println("---email is too long!---");

            return false;
        }
        else if (matcher.find()) {
            return true;
        }
        System.out.println("---Incorrect email---");

        return false;
    }
}
