package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormatLanguageLvl {

    public String getFormatLanguage(WebElement element, int languageLvl) {
        Select select = new Select(element);

        switch (languageLvl) {
            case 1: {
                select.selectByIndex(1);
                return select.getFirstSelectedOption().getDomAttribute("value");
            }
            case 2: {
                select.selectByIndex(2);
                return select.getFirstSelectedOption().getDomAttribute("value");
            }
            case 3: {
                select.selectByIndex(3);
                return select.getFirstSelectedOption().getDomAttribute("value");
            }
            case 4: {
                return select.getFirstSelectedOption().getDomAttribute("value");
            }
        }

        return "---Unacceptable languageLvl---";
    }

}
