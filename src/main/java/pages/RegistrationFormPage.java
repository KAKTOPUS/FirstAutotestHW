package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.*;
public class RegistrationFormPage extends AbsBasePage {
    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    Actions action = new Actions(driver);

    public String checkUserNameField(String userName) {
        CheckUserName checkUserName = new CheckUserName();
        WebElement elementNameField = driver.findElement(By.cssSelector("input#username"));

        if (checkUserName.isNameValid(userName)) {
            insertTextIntoField(elementNameField, userName);
            checkTextShouldBeSameAs(elementNameField, userName);

            return userName;
        }

        return null;
    }

    public String checkEmailField(String userEmail) {
        CheckCorrectEmail checkCorrectEmail = new CheckCorrectEmail();

        WebElement elementEmailField = driver.findElement(By.cssSelector("input#email"));
        if (checkCorrectEmail.isEmailValid(userEmail)) {
            insertTextIntoField(elementEmailField, userEmail);
            checkTextShouldBeSameAs(elementEmailField, userEmail);

            return userEmail;
        }

        return null;
    }

    public void checkPasswordFields(String insertPassword, String confirmPassword) {
        WebElement elementPassword = driver.findElement(By.cssSelector("input#password"));
        WebElement elementConfirmPassword = driver.findElement(By.cssSelector("input#confirm_password"));

            insertTextIntoField(elementPassword, insertPassword);
            checkTextShouldBeSameAs(elementPassword, insertPassword);

            insertTextIntoField(elementConfirmPassword, confirmPassword);
            checkTextShouldBeSameAs(elementConfirmPassword, confirmPassword);
        }

    public String checkBirthdateField(int birthdateDay, int birthdateMonth, int birthdateYear) {
        CheckBirthdate checkBirthdate = new CheckBirthdate();

        String birthdateDayStr = Integer.toString(birthdateDay);
        String birthdateMonthStr = Integer.toString(birthdateMonth);
        String birthdateYearStr = Integer.toString(birthdateYear);

        String birthdateReverse = String.format("%s-%s-%s", checkBirthdate.isBirthdateYearCorrect(birthdateYear)
                                                          , checkBirthdate.isBirthdateMonthCorrect(birthdateMonth)
                                                          , checkBirthdate.isBirthdateDayCorrect(birthdateDay));

        if (checkBirthdate.isValidDate(birthdateDay, birthdateMonth, birthdateYear)) {

            WebElement elementBirthdateField = driver.findElement(By.cssSelector("input#birthdate"));

            action.click(elementBirthdateField)
                    .sendKeys(elementBirthdateField, birthdateDayStr)
                    .sendKeys(Keys.ARROW_RIGHT)
                    .sendKeys(elementBirthdateField, birthdateMonthStr)
                    .sendKeys(Keys.ARROW_RIGHT)
                    .sendKeys(elementBirthdateField, birthdateYearStr)
                    .perform();

            checkTextShouldBeSameAs(elementBirthdateField, birthdateReverse);

            return birthdateReverse;
        }

        return null;
    }

    public String checkLanguageKnowledgeField(int lvl) {
        CheckLanguageLvl languageLvl = new CheckLanguageLvl();

        if (languageLvl.isLanguageValid(lvl)) {

            WebElement elementLanguageKnowledgeField = driver.findElement(By.cssSelector("select#language_level"));

            String languageOption = languageLvl.checkLanguageLvl(driver, elementLanguageKnowledgeField, lvl);
            String languageLvlTranslate = languageLvl.isLanguageOptionExist(languageOption);

            return languageLvlTranslate;
        }

        return null;
    }

    public void checkRegistrationButton(String name, String email, String password, String confirmPassword, int day, int month, int year, int lvlLanguage) throws InterruptedException {
        CheckPasswords checkPasswords = new CheckPasswords();

        WebElement elementRegistrationButton = driver.findElement(By.cssSelector("input[type=submit]"));
        WebElement elementOutputRegistration = driver.findElement(By.cssSelector("div#output"));

        String expectedText = String.format(
                 "Имя пользователя: %s\n" +
                 "Электронная почта: %s\n" +
                 "Дата рождения: %s\n" +
                 "Уровень языка: %s"
                , checkUserNameField(name)
                , checkEmailField(email)
                , checkBirthdateField(day, month, year)
                , checkLanguageKnowledgeField(lvlLanguage));

        checkPasswordFields(password, confirmPassword);

        if (checkPasswords.isPasswordEquals(password,confirmPassword)) {
            elementRegistrationButton.click();
            Thread.sleep(2000);

            checkTextShouldBeSameAs(elementOutputRegistration, expectedText);
        }
        else {
            elementRegistrationButton.click();
            Alert alert = driver.switchTo().alert();

            String alertMsg = alert.getText();
            alert.accept();
            if (alertMsg.equals("Пароли не совпадают!")) {
                System.out.println("Пароли не совпадают!");
            }
        }
    }

}
