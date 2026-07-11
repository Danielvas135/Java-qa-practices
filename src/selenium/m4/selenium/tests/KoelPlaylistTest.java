package selenium.m4.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import selenium.m4.selenium.base.BaseTest;

import java.time.Duration;

public class KoelPlaylistTest extends BaseTest {

    @Test
    public void changeTheme()  {
        driver.get("https://qa.koel.app/");

        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("daniel.vasquez@testpro.io");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Makatey135!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='view-profile-link']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" div[data-testid= 'theme-card-pines']"))).click();
        System.out.println("Theme changed to In the Pines");

    }

    @Test
    public void createPlaylistDeletePlaylist()  {
        // Nedded for Thread Sleeps - throws InterruptedException

        driver.get("https://qa.koel.app/");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("daniel.vasquez@testpro.io");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Makatey135!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title= 'Create a new playlist']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"))).click();

        WebElement playlistName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name'][type='text']")));
        playlistName.sendKeys("LumScreamo");
        playlistName.sendKeys(Keys.ENTER);
        System.out.println("New playlist created");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'LumScreamo')]"))).click();
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title= 'Delete this playlist']"))).click();
        System.out.println("Playlist deleted.");
        //Thread.sleep(3000);



    }

}
