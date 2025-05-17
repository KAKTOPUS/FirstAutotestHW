package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public abstract class AbsBasePage {
    WebDriver driver = null;
    String baseUrl = System.getProperty("baseUrl");

    public AbsBasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(baseUrl);
    }

    public void insertTextIntoField(WebElement element, String insertText) {
        element.sendKeys(insertText);
    }

    public void checkTextShouldBeSameAs(WebElement element, String insertText) {
        if (element.getText().equals("")) {
            assertThat(element.getDomProperty("value"))
                    .as("String should be same as {}", insertText)
                    .isEqualTo(insertText);
        }
        else if (element.getText() == null) {
            String exactText = (String) ((JavascriptExecutor)driver)
                    .executeScript("return arguments[0].childNodes[0].nodeValue;", element);

            assertThat(exactText)
                    .as("String should be same as {}", insertText)
                    .isEqualTo(insertText);

        }
        else {
            assertThat(element.getText())
                    .as("String should be same as {}", insertText)
                    .isEqualTo(insertText);
        }
    }
}
