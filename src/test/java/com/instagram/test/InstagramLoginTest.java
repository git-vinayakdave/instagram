package com.instagram.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InstagramLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.instagram.com");
    }

    @Test
    public void testLogin() {
        WebElement usernameField = driver.findElement(By.name("test"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameField.sendKeys("test");
        passwordField.sendKeys("password");
        loginButton.click();

        WebElement profileIcon = driver.findElement(By.id("profile-icon"));
        Assert.assertTrue(profileIcon.isDisplayed(), "Login failed: Profile icon not visible.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
