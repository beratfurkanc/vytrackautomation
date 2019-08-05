package com.vytrack.tests.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @Test
    public void loginFunctionality1() throws InterruptedException {

        String expUrl= "http://qa3.vytrack.com";
        String[] userNames = {"storemanager57","salesmanager110","user10"};

        String password = "UserUser123";
        String expTitle = "Dashboard";

        driver.get(expUrl);
        driver.manage().window().maximize();

        for(int i=0;i<userNames.length;i++){

            driver.findElement(By.id("prependedInput")).sendKeys(userNames[i]); //put Username

            driver.findElement(By.id("prependedInput2")).sendKeys(password);// put password

            driver.findElement(By.id("_submit")).click(); //click login button
            Thread.sleep(8000);

            Assert.assertEquals(driver.getTitle(),expTitle);

            driver.findElement(By.xpath("//*[@id='user-menu']/a/i")).click();  // click name.
            Thread.sleep(5000);
            driver.findElement(By.linkText("Logout")).click(); //click logout button
            Thread.sleep(5000);

        }
    }
    @Test
    public void loginFunctionality2() throws InterruptedException {

        String username="user10";
        String password="UserUser12";
        String expMsg="Invalid user name or password.";
        String expPageTitle = "Login";
        String expUrl= "http://qa3.vytrack.com/user/login";
        driver.get("http://qa3.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);// put password
        driver.findElement(By.id("_submit")).click(); //click login button
        Thread.sleep(5000);


        String actmsg= driver.findElement(By.xpath("//form[@id='login-form']/fieldset/div/div")).getText();

        Assert.assertEquals(actmsg,expMsg);
        Assert.assertEquals(driver.getTitle(),expPageTitle);
        Assert.assertEquals(driver.getCurrentUrl(),expUrl);
    }

}
