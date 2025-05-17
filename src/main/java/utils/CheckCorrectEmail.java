package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCorrectEmail {
    public boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^(?=.{1,15}@)[a-zA-Z0-9._-]{1,15}@[a-zA-Z0-9._-]{1,15}$");
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            return true;
        }
        System.out.println("---Incorrect email---");

        return false;
    }
}
