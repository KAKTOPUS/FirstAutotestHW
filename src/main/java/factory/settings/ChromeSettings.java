package factory.settings;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements IBrowserSettings {

    private String launchParameter = System.getProperty("launchParameter");
    public AbstractDriverOptions settings() {

        ChromeOptions options = new ChromeOptions();

        switch (launchParameter) {

            case "fullscreen": {
                options.addArguments("--maximize");
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
