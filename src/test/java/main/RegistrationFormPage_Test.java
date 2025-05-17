package main;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormPage_Test extends AbsBaseSuit {

    @Test
    public void registrationFormPageTest() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
        registrationFormPage.open();
        registrationFormPage.checkRegistrationButton("kaktopus", "darkwatchgigabyte@mail.ru", "12", "12", 3, 11, 1999, 4);
    }

}
