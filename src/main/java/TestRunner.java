import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.*;
import browsers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class TestRunner {

    public static void main(String[] args) {

        String email = "b3713847@urhen.com";
        String site = "https://en.wikipedia.org/";
        String userName = "TestUserTest123";
        String password = "123TestUserTest";

        Scenarios scenario = new Scenarios();
        WebDriver driver;
        WebDriverWait wait;
        WebElement error;

        System.setProperty("webdriver.chrome.driver", "D:\\Java\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        //all fields correct
        try {
            scenario.login(driver, site, userName, password);
            error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error']")));
            if (error.isEnabled()) {
                System.out.printf("Test failed");
                driver.quit();
            }
            else {
                scenario.logout(driver);
                driver.quit();
            }
        } catch (WebDriverException e) {
            System.out.printf("Test failed");
        }

        //incorrect login
        driver = new ChromeDriver();
        try {
            scenario.login(driver, site, "sdfs", password);
            error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error']")));
            if (error.isEnabled()) {
                System.out.printf("Test failed");
                driver.quit();
            }else {
                scenario.logout(driver);
                driver.quit();
            }
        } catch (WebDriverException e) {
            System.out.printf("Test failed");
        }

        //incorrect password
        driver = new ChromeDriver();
        try {
            scenario.login(driver, site, userName, "xcvxc");
            error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error']")));
            if (error.isEnabled()) {
                System.out.printf("Test failed");
                driver.quit();
            }else {
                scenario.logout(driver);
                driver.quit();
            }
        } catch (WebDriverException e) {
            System.out.printf("Test failed");
        }

        //empty login field
        driver = new ChromeDriver();
        try {
            scenario.login(driver, site, "", password);
            error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error']")));
            if (error.isEnabled()) {
                System.out.printf("Test failed");
                driver.quit();
            }else {
                scenario.logout(driver);
                driver.quit();
            }
        } catch (WebDriverException e) {
            System.out.printf("Test failed");
        }

        //empty password field
        driver = new ChromeDriver();
        try {
            scenario.login(driver, site, userName, "");
            error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error']")));
            if (error.isEnabled()) {
                System.out.printf("Test failed");
                driver.quit();
            }else {
                scenario.logout(driver);
                driver.quit();
            }
        } catch (WebDriverException e) {
            System.out.printf("Test failed");
        }



        /*
        System.setProperty("webdriver.gecko.driver", "D:\\Java\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        scenario.login(driver, site, userName, password);
        driver.quit();

        System.setProperty("webdriver.opera.driver", "D:\\Java\\testselenium\\drivers\\operadriver.exe");
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\coolluck\\AppData\\Local\\Programs\\Opera\\60.0.3255.170\\opera.exe");
        driver = new OperaDriver(options);
        scenario.login(driver, site, userName, password);
        driver.quit();
        */
    }
}
