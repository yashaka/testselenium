package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Scenarios {

    public static void login(WebDriver driver, String site, String userName, String password) {
        driver.get(site);
        driver.findElement(By.xpath("//*[contains(text(), 'Log in')]")).click();
        driver.findElement(By.xpath("//input[@id='wpName1']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='wpPassword1']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='wpLoginAttempt']")).click();
    }

    public static void logout(WebDriver driver) {
        driver.findElement(By.xpath("//a[contains(text(), 'Log out')]")).click();
    }
}
