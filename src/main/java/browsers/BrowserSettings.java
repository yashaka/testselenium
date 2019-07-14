package browsers;

import org.openqa.selenium.WebDriver;

public class BrowserSettings {

    public static void setupBrowser(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
}
