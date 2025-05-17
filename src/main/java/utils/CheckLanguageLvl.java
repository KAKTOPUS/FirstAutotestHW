package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CheckLanguageLvl {

    public String checkLanguageLvl(WebDriver driver, WebElement element, int lvl) {
        Actions action = new Actions(driver);
        Select select = new Select(element);

        switch (lvl) {
            case 1: {
                action.click(element)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.ENTER)
                        .perform();

                String beginnerLvl = select.getFirstSelectedOption().getText();

                return beginnerLvl;
            }
            case 2: {
                action.click(element)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.ENTER)
                        .perform();

                String intermediateLvl = select.getFirstSelectedOption().getText();

                return intermediateLvl;
            }
            case 3: {
                action.click(element)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.ENTER)
                        .perform();

                String advancedLvl = select.getFirstSelectedOption().getText();

                return advancedLvl;
            }

            case 4: {
                action.click(element)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.DOWN)
                        .sendKeys(Keys.ENTER)
                        .perform();

                String nativeLvl = select.getFirstSelectedOption().getText();

                return nativeLvl;
            }
        }

        return "---Unacceptable languageLvl---";
    }

    public String isLanguageOptionExist(String languageOption) {
        switch (languageOption) {
            case "Начальный": {
                return "beginner";
            }
            case "Средний": {
                return "intermediate";
            }
            case "Продвинутый": {
                return "advanced";
            }
            case "Носитель языка": {
                return "native";
            }
        }

        return null;
    }

    public boolean isLanguageValid(int languageLvl) {
        if (languageLvl >= 1 && languageLvl <= 4) {
            return true;
        }
        System.out.println("---Unacceptable languageLvl!---");

        return false;
    }
}
