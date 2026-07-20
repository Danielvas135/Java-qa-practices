package selenium.m4.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;

public class FirefoxTesting {

    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser) throws Exception {
        String gridURL = "http://localhost:4444"; // Change if your Grid is on different machine

        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("grid-firefox")) {
            driver = new RemoteWebDriver(new URL(gridURL), new org.openqa.selenium.firefox.FirefoxOptions());
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @Test
    public void testOnFirefox() {
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}