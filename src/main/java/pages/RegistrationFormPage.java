package pages;

import dto.TestDataGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.*;
import java.time.Duration;

public class RegistrationFormPage extends AbsBasePage {
    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    Actions action = new Actions(driver);

    @Step("Enter name")
    public String enterNameIntoField(TestDataGenerator testDataGenerator) {
        String name = testDataGenerator.getName();
        WebElement elementNameField = driver.findElement(By.cssSelector("input#username"));
        insertTextIntoField(elementNameField, name);

        return name;
    }

    @Step("Enter email")
    public String enterEmailIntoField(TestDataGenerator testDataGenerator) {
        String email = testDataGenerator.getEmail();
        WebElement elementEmailField = driver.findElement(By.cssSelector("input#email"));
        insertTextIntoField(elementEmailField, email);

        return email;
    }

    @Step("Enter password")
    public String enterPasswordIntoField(TestDataGenerator testDataGenerator) {
        String password = testDataGenerator.getPassword();
        WebElement elementPassword = driver.findElement(By.cssSelector("input#password"));
        insertTextIntoField(elementPassword, password);

        return password;
    }

    @Step("Enter confirm password")
    public String enterConfirmPasswordIntoField(String confirmPassword) {
        WebElement elementConfirmPassword = driver.findElement(By.cssSelector("input#confirm_password"));
        insertTextIntoField(elementConfirmPassword, confirmPassword);

        return confirmPassword;
    }

    @Step("Enter birthdate")
    public String enterBirthdateIntoField(TestDataGenerator testDataGenerator) {
        FormatDate formatDate = new FormatDate();
        WebElement elementBirthdateField = driver.findElement(By.cssSelector("input#birthdate"));

        String birthdate = String.valueOf(testDataGenerator.getDate());
        String outputBirthdate = String.valueOf(formatDate.getFormatDate(birthdate));

        String birthdateDayStr = String.valueOf(formatDate.getFormatDate(birthdate).getDayOfMonth());
        String birthdateMonthStr = String.valueOf(formatDate.getFormatDate(birthdate).getMonthValue());
        String birthdateYearStr = String.valueOf(formatDate.getFormatDate(birthdate).getYear());

        action.click(elementBirthdateField)
                .sendKeys(elementBirthdateField, birthdateDayStr)
                .sendKeys(elementBirthdateField, birthdateMonthStr)
                .sendKeys(elementBirthdateField, birthdateYearStr)
                .perform();

        return outputBirthdate;
    }

    @Step("Enter language lvl")
    public String enterLanguageLvl(TestDataGenerator testDataGenerator) {
        FormatLanguageLvl formatLanguageLvl = new FormatLanguageLvl();
        WebElement elementLanguageKnowledgeField = driver.findElement(By.cssSelector("select#language_level"));
        int generateLanguageLvl = testDataGenerator.getLanguageLvl();

        String languageLvl = formatLanguageLvl.getFormatLanguage(elementLanguageKnowledgeField, generateLanguageLvl);

        return languageLvl;
    }

    @Step("Check registration button")
    public void checkRegistrationButton(TestDataGenerator testDataGenerator) {
        WebElement elementRegistrationButton = driver.findElement(By.cssSelector("input[type=submit]"));
        WebElement elementOutputRegistration = driver.findElement(By.cssSelector("div#output"));

        String name = enterNameIntoField(testDataGenerator);
        String email = enterEmailIntoField(testDataGenerator);
        String password = enterPasswordIntoField(testDataGenerator);
        String confirmPassword = "";
        String date = enterBirthdateIntoField(testDataGenerator);
        String languageLvl = enterLanguageLvl(testDataGenerator);

        if (testDataGenerator.randomTrue()) {

            confirmPassword = password;
            enterConfirmPasswordIntoField(confirmPassword);

            elementRegistrationButton.click();

            String expectedText = String.format(
                            "Имя пользователя: %s\n" +
                            "Электронная почта: %s\n" +
                            "Дата рождения: %s\n" +
                            "Уровень языка: %s"
                            , name
                            , email
                            , date
                            , languageLvl);

            checkTextShouldBeSameAs(elementOutputRegistration, expectedText);
        }
        else {

            confirmPassword = testDataGenerator.getConfirmPassword();
            enterConfirmPasswordIntoField(confirmPassword);

            elementRegistrationButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();

            String alertMsg = alert.getText();
            alert.accept();

            if (alertMsg.equals("Пароли не совпадают!")) {
                System.out.println("---Passwords is not equals!---");
            }
        }
    }

}
