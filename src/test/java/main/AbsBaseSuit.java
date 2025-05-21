package main;

import dto.TestDataGenerator;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class AbsBaseSuit {

    WebDriver driver = null;

    protected TestDataGenerator testDataGenerator = null;


    @BeforeEach
    public void initWebDriver() {
        testDataGenerator = new TestDataGenerator();
        driver = new WebDriverFactory().getDriver();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
