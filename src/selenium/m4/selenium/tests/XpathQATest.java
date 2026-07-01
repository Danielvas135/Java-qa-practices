package selenium.m4.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.m4.selenium.base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class XpathQATest extends BaseTest {

    @Test
    public void demoQAHomePage() {
        driver.get("https://demoqa.com/");

        // XPath examples
        driver.findElement(By.xpath("//h5[text()='Elements']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("elements"));
        System.out.println(" Navigated to Elements page using XPath");
    }
    @Test
    public void navigateThroughAllCards() {
        driver.get("https://demoqa.com/");

        String[] cards = {"/elements", "/forms", "/alertsWindows", "/widgets", "/interaction", "/books"};

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (String card : cards) {
            driver.findElement(By.xpath("//a[@href='" + card + "']")).click();
            System.out.println("✅ Navigated to: " + card);

            // Wait and return home
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'demoqa.com')]")))
                    .click();
        }

        System.out.println("✅ Completed all cards!");
    }
}