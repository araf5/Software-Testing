package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
            driver.manage().window().maximize();
            Thread.sleep(2000);

            // Valid Login
            WebElement emailField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("pass"));
            WebElement loginButton = driver.findElement(By.id("send2"));

            emailField.sendKeys("roni_cost@example.com");
            passwordField.sendKeys("roni_cost3@example.com");
            loginButton.click();
            Thread.sleep(2000);
            System.out.println("Valid Login Tested");

            // Invalid Login
            driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
            Thread.sleep(2000);

            emailField = driver.findElement(By.id("email"));
            passwordField = driver.findElement(By.id("pass"));

            emailField.sendKeys("invalid_user@example.com");
            passwordField.sendKeys("InvalidPassword123");
            loginButton.click();
            Thread.sleep(2000);
            System.out.println("Invalid Login Tested");

            // Empty Fields
            driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
            Thread.sleep(2000);

            emailField = driver.findElement(By.id("email"));
            passwordField = driver.findElement(By.id("pass"));

            emailField.clear();
            passwordField.clear();
            loginButton.click();
            Thread.sleep(2000);
            System.out.println("Empty Fields Validation Tested");

        } catch (Exception e) {
            System.out.println("Functional Tests Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
