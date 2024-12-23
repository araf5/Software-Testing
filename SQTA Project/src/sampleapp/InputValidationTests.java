package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class InputValidationTests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://magento.softwaretestingboard.com/");
            driver.manage().window().maximize();

            // Wait for the SignIn link
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
            loginLink.click();

            // Input Validation Tests
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement password = driver.findElement(By.id("pass"));
            WebElement loginButton = driver.findElement(By.id("send2"));

            // Special Character Input
            username.sendKeys("!@#$%^&*()");
            password.sendKeys("!@#$%^&*()");
            loginButton.click();
            System.out.println("Special character input tested!");

            // Long Input Test
            username.clear();
            password.clear();
            username.sendKeys("a".repeat(255));
            password.sendKeys("b".repeat(255));
            loginButton.click();
            System.out.println("Long input tested!");

        } catch (Exception e) {
            System.out.println("Error in InputValidationTests: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
