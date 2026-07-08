package selenium.m4.selenium.tests.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.m4.selenium.base.BaseTest;

import java.time.Duration;

public class LumFilters extends BaseTest {


    @Test
    public void filterProductsByPrice() {
        driver.get("https://www.saucedemo.com/");
        new selenium.pages.LoginPage(driver).login("standard_user", "secret_sauce");

        // Sort by price low to high
        driver.findElement(By.cssSelector("[data-test='product-sort-container']")).click();
        driver.findElement(By.cssSelector("option[value='lohi']")).click();

        System.out.println(" Products filtered by price low to high");
    }
    @Test
    public void sortProductsNameAZ() {
        driver.get("https://www.saucedemo.com/");
        new selenium.pages.LoginPage(driver).login("standard_user", "secret_sauce");

        // Sort by price low to high
        driver.findElement(By.cssSelector("[data-test='product-sort-container']")).click();
        driver.findElement(By.cssSelector("option[value='az']")).click();

        System.out.println(" Products sorted by name AZ");
    }
    @Test
    public void removeAllItemsFromCart() {
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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='remove-sauce-labs-bike-light']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='remove-sauce-labs-bolt-t-shirt']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='remove-sauce-labs-fleece-jacket']"))).click();
        System.out.println("cart successfully emptied");
    }
    @Test
    public void verifyCartBadge() {
        driver.get("https://www.saucedemo.com/");
        new selenium.pages.LoginPage(driver).login("standard_user", "secret_sauce");

        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();

        String badgeText = driver.findElement(By.cssSelector("[data-test='shopping-cart-badge']")).getText();
        Assert.assertEquals(badgeText, "1");
        System.out.println("Cart badge shows correct count");
    }
    @Test
    public void logoutTest() {
        driver.get("https://www.saucedemo.com/");
        new selenium.pages.LoginPage(driver).login("standard_user", "secret_sauce");

        driver.findElement(By.cssSelector("[id='react-burger-menu-btn']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='logout-sidebar-link']"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
        System.out.println("Logout successful");
    }
    @Test
    public void invalidLoginTest() {
        driver.get("https://www.saucedemo.com/");

        new selenium.pages.LoginPage(driver).login("locked_out_user", "secret_sauce");

        String errorMsg = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(errorMsg.contains("locked out"));
        System.out.println("Invalid login handled correctly");
    }


}
