package selenium.m4.selenium.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.m4.selenium.base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class M4L12_CSSLocatorsTest extends BaseTest {


    @Test
    public void cssLocatorsPractice() {
        driver.get("https://www.saucedemo.com/");

        selenium.pages.LoginPage loginPage = new selenium.pages.LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login should have succeeded");
        System.out.println("M4-L12 CSS Locators Test passed using Page Object");
    }

    @Test
    public void addItemToCart() {
        driver.get("https://www.saucedemo.com/");
        new selenium.pages.LoginPage(driver).login("standard_user", "secret_sauce");

        // Add item
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();

        // Go to cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-test='shopping-cart-link']")))
                .click();

        // Verify
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_item")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".cart_item")).isDisplayed());
        System.out.println("Item added to cart!");
    }
    @Test
    public void removeItemFromCart() {
        driver.get("https://www.saucedemo.com/");
        new selenium.pages.LoginPage(driver).login("standard_user", "secret_sauce");

        // Add item first
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();

        // Go to cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-test='shopping-cart-link']")))
                .click();

        // Remove item
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test^='remove-']")))
                .click();

        // Verify empty
        Assert.assertTrue(driver.findElements(By.cssSelector(".cart_item")).isEmpty());
        System.out.println("Cart item removed!");
    }
    @Test
    public void completeCheckout() {
        driver.get("https://www.saucedemo.com/");
        new selenium.pages.LoginPage(driver).login("standard_user", "secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Add item
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='add-to-cart-sauce-labs-bolt-t-shirt']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='add-to-cart-sauce-labs-fleece-jacket']"))).click();
        System.out.println(" 4 Items added to cart successfully!");

        // Remove Item
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='remove-sauce-labs-backpack']"))).click();
        System.out.println("Backpack Removed...");

        // Go to cart
        driver.findElement(By.cssSelector("a[data-test='shopping-cart-link']")).click();

        // Checkout
        driver.findElement(By.cssSelector("[data-test='checkout']")).click();

        // Fill form
        driver.findElement(By.cssSelector("[data-test='firstName']")).sendKeys("Daniel");
        driver.findElement(By.cssSelector("[data-test='lastName']")).sendKeys("Vas");
        driver.findElement(By.cssSelector("[data-test='postalCode']")).sendKeys("90802");
        driver.findElement(By.cssSelector("[data-test='continue']")).click();

        // Finish


        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='finish']"))).click();

        Assert.assertTrue(driver.getPageSource().contains("Thank you for your order!"));
        System.out.println(" Checkout completed successfully!");
    }



}