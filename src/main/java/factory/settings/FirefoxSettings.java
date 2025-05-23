package factory.settings;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSettings implements IBrowserSettings {

    private String launchParameter = System.getProperty("launchParameter");

    public AbstractDriverOptions settings() {

        FirefoxOptions options = new FirefoxOptions();

        switch (launchParameter.toLowerCase()) {
            case "fullscreen": {
                options.addArguments("--fullscreen");
                return options;
            }
            case "headless": {
                options.addArguments("--headless");
                return options;
            }
            case "kiosk": {
                options.addArguments("--kiosk");
                return options;
            }
            default: {
                options.addArguments("start-fullscreen");
                return options;
            }
        }

    }
}
