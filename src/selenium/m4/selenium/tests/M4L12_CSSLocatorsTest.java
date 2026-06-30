package selenium.m4.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

        // CSS practice: Add first item to cart
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();

        // Wait and click cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-test='shopping-cart-link']")))
                .click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".cart_item")).isDisplayed());
        System.out.println("Item added to cart!");

        driver.findElement(By.cssSelector("a[data-test='shopping-cart-link']")).click();
        driver.findElement(By.cssSelector("button[data-test^='remove-']")).click();  // Remove button

        // Verify cart is empty
        Assert.assertTrue(driver.findElements(By.cssSelector("[data-test='cart-list'] .cart_item")).isEmpty());
    }


}