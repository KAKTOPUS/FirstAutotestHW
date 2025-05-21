package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public abstract class AbsBasePage {
    protected WebDriver driver = null;
    private String baseUrl = System.getProperty("baseUrl");

    public AbsBasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open page")
    public void open() {
        driver.get(baseUrl);
    }

    public void insertTextIntoField(WebElement element, String insertText) {
        element.sendKeys(insertText);
    }

    @Step("Checking text is equals")
    public void checkTextShouldBeSameAs(WebElement element, String insertText) {
        if (element.getText().equals("")) {
            assertThat(element.getDomProperty("value"))
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
