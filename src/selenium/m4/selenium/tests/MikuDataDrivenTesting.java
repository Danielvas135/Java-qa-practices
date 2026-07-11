package selenium.m4.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.m4.selenium.base.BaseTest;

import java.time.Duration;

public class MikuDataDrivenTesting extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", true},
                {"locked_out_user", "secret_sauce", false},
                {"problem_user", "secret_sauce", true}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginWithDifferentUsers(String username, String password, boolean shouldSucceed) {
        driver.get("https://www.saucedemo.com/");
        new selenium.pages.LoginPage(driver).login(username, password);

        if (shouldSucceed) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        } else {
            Assert.assertTrue(driver.getPageSource().contains("locked out"));
        }
    }
    @DataProvider(name = "checkoutData")
    public Object[][] checkoutData() {
        return new Object[][] {
                {"standard_user", "Daniel", "Vas", "90802", true},
                {"performance_glitch_user", "John", "Doe", "90210", true},
                {"problem_user", "Jane", "White", "90860", false} // Expect Failure
        };
    }

    @Test(dataProvider = "checkoutData")
    public void checkoutWithDifferentUsers(String username, String firstName, String lastName, String zip, boolean expectSuccess) {
        driver.get("https://www.saucedemo.com/");
        // use the parameter username
        new selenium.pages.LoginPage(driver).login(username, "secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println(username + " has logged in successfully!");

        // Add item
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']"))).click();
        System.out.println(username + "  added an item to the cart successfully!");

        // Go to cart
        driver.findElement(By.cssSelector("a[data-test='shopping-cart-link']")).click();

        // Checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='checkout']"))).click();

        // Fill form using parameters
        driver.findElement(By.cssSelector("[data-test='firstName']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[data-test='lastName']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[data-test='postalCode']")).sendKeys(zip);
        driver.findElement(By.cssSelector("[data-test='continue']")).click();

        // Finish
        if(expectSuccess) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='finish']"))).click();
            Assert.assertTrue(driver.getPageSource().contains("Thank you for your order!"));
        } else {
            // Expect failure for problem_user
            Assert.assertTrue(driver.getPageSource().contains("error") || driver.getCurrentUrl().contains("checkout"));
            System.out.println(username + "  did not successfully complete the checkout!");
        }

    }

}
