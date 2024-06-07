package com.instagram.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InstagramPostCreationTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://dummy-instagram-url.com");
        // Assume login steps
    }

    @Test
    public void testCreatePost() {
        WebElement newPostButton = driver.findElement(By.id("new-post-button"));
        newPostButton.click();

        WebElement uploadInput = driver.findElement(By.name("upload"));
        WebElement descriptionField = driver.findElement(By.name("description"));
        WebElement submitPostButton = driver.findElement(By.xpath("//button[@type='submit']"));

        uploadInput.sendKeys("C:/path/to/image.jpg");
        descriptionField.sendKeys("This is a test post.");
        submitPostButton.click();

        WebElement newPost = driver.findElement(By.xpath("//div[@class='post' and text()='This is a test post.']"));
        Assert.assertTrue(newPost.isDisplayed(), "Post creation failed: New post not visible.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
