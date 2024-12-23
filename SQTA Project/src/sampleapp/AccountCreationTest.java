package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreationTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://magento.softwaretestingboard.com/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Step 1: Navigate to Create Account Page
            WebElement createAccountLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("a[href*='customer/account/create/']")));
            createAccountLink.click();

            // Step 2: Fill the Registration Form
            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
            WebElement lastName = driver.findElement(By.id("lastname"));
            WebElement email = driver.findElement(By.id("email_address"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));

            firstName.sendKeys("Test");
            lastName.sendKeys("User");
            String uniqueEmail = "testuser" + System.currentTimeMillis() + "@example.com";
            email.sendKeys(uniqueEmail);
            password.sendKeys("TestPassword123!");
            confirmPassword.sendKeys("TestPassword123!");

            WebElement createAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
            createAccountButton.click();

            System.out.println("Account Creation Successful!");

            // Step 3: Login with Created Account
            driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement passwordField = driver.findElement(By.id("pass"));
            WebElement loginButton = driver.findElement(By.id("send2"));

            emailField.sendKeys(uniqueEmail);
            passwordField.sendKeys("TestPassword123!");
            loginButton.click();

            System.out.println("Login with Created Account Successful!");

            // Step 4: Add Product to Cart
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
            searchBox.sendKeys("Jacket");
            searchBox.submit();

            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-item-link")));
            firstProduct.click();

            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
            addToCartButton.click();

            System.out.println("Product Added to Cart Successfully!");

            // Step 5: Proceed to Checkout
            WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".showcart")));
            cartIcon.click();

            WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("top-cart-btn-checkout")));
            proceedToCheckoutButton.click();

            System.out.println("Checkout Process Started!");

            // Step 6: Place the Order
            WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".place-order")));
            placeOrderButton.click();

            System.out.println("Order Placed Successfully!");

        } catch (Exception e) {
            System.out.println("Account Creation Test Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
