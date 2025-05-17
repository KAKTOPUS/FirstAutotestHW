package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUserName {

    public boolean isNameValid(String userName) {
        Pattern pattern = Pattern.compile("^(?=[^\s]*\\s?[^\s]*$)[\\S\\s]{1,20}$");
        Matcher matcher = pattern.matcher(userName);

        if (userName.equals("")) {
            System.out.println("---Name is cannot be empty!---");
            return false;
        }
        else if (matcher.find()) {
            return true;
        }

        System.out.println("---Incorrect name!---");
        return false;
    }
}
