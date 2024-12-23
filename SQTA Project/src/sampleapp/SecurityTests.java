package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SecurityTests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://magento.softwaretestingboard.com/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to Sign In page
            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
            loginLink.click();

            // SQL Injection Test
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement password = driver.findElement(By.id("pass"));
            WebElement loginButton = driver.findElement(By.id("send2"));

            username.sendKeys("' OR '1'='1");
            password.sendKeys("' OR '1'='1");
            loginButton.click();

            // Check Result
            WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("message-error")));
            if (errorMessage.getText().contains("Invalid login or password")) {
                System.out.println("SQL Injection Test Passed: Login prevented.");
            } else {
                System.out.println("SQL Injection Test Failed: Unexpected behavior.");
            }

        } catch (Exception e) {
            System.out.println("Error in SecurityTests: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
