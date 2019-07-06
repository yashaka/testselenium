import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Java\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org/");
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        System.out.println(driver.findElement(By.xpath("(//input[@name='search'])[1]")).getAttribute("value"));
        driver.findElement(By.xpath("(//input[@name='search'])[1]")).clear();

//        driver.quit();

    }
}
