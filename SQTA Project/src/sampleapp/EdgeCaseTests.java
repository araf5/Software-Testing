package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class EdgeCaseTests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://magento.softwaretestingboard.com/");
            driver.manage().window().maximize();

            // Wait for the Sign In link
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
            loginLink.click();

            // Edge Case Testing
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement password = driver.findElement(By.id("pass"));
            WebElement loginButton = driver.findElement(By.id("send2"));

            // Minimum Length Test
            username.sendKeys("a");
            password.sendKeys("a");
            loginButton.click();
            System.out.println("Minimum length input tested!");

            // Maximum Length Test
            username.clear();
            password.clear();
            username.sendKeys("a".repeat(255));
            password.sendKeys("b".repeat(255));
            loginButton.click();
            System.out.println("Maximum length input tested!");

        } catch (Exception e) {
            System.out.println("Error in EdgeCaseTests: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
