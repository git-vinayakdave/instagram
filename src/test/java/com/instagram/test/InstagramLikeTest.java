package com.instagram.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InstagramLikeTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://dummy-instagram-url.com");
        // Assume login steps
    }

    @Test
    public void testLikeUnlikePost() {
        WebElement post = driver.findElement(By.xpath("//div[@class='post' and text()='Some post description']"));
        WebElement likeButton = post.findElement(By.className("like-button"));
        likeButton.click();

        WebElement unlikeButton = post.findElement(By.className("unlike-button"));
        Assert.assertTrue(unlikeButton.isDisplayed(), "Like failed: Unlike button not visible.");

        unlikeButton.click();
        likeButton = post.findElement(By.className("like-button"));
        Assert.assertTrue(likeButton.isDisplayed(), "Unlike failed: Like button not visible.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}