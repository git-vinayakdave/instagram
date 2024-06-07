package com.instagram.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InstagramFollowTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.instagram.com");
        // Assume login steps
    }

    @Test
    public void testFollowUnfollow() {
        WebElement userToFollow = driver.findElement(By.xpath("//div[@class='user' and text()='user_to_follow']"));
        userToFollow.click();

        WebElement followButton = driver.findElement(By.id("follow-button"));
        followButton.click();

        WebElement unfollowButton = driver.findElement(By.id("unfollow-button"));
        Assert.assertTrue(unfollowButton.isDisplayed(), "Follow failed: Unfollow button not visible.");

        unfollowButton.click();
        followButton = driver.findElement(By.id("follow-button"));
        Assert.assertTrue(followButton.isDisplayed(), "Unfollow failed: Follow button not visible.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
