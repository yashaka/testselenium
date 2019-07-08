import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Java\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        String userName = "TestUserTest123";
        String password = "123TestUserTest";
        String email = "b3713847@urhen.com";

        driver.get("https://en.wikipedia.org/");
        driver.findElement(By.xpath("//*[contains(text(), 'Log in')]")).click();
        driver.findElement(By.xpath("//input[@id='wpName1']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='wpPassword1']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='wpLoginAttempt']")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Log out')]")).click();
        driver.quit();

    }
}
