package com.vytrack.tests.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageAccessTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void storeManagerTestToVehicleContracts() throws InterruptedException {

        String userName = "storemanager57";
        String password = "UserUser123";

        String expUrl= "http://qa3.vytrack.com";
        String expTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        String expPageName = "All Vehicle Contract";

        driver.get(expUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("prependedInput")).sendKeys(userName); //put Username

        driver.findElement(By.id("prependedInput2")).sendKeys(password);// put password

        driver.findElement(By.id("_submit")).click(); //click login button
        Thread.sleep(5000);

        Actions builder = new Actions(driver);
        //Go to Fleet module and wait there
        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[2]/a/span"))).build().perform();
        Thread.sleep(10000);
        //Click Vehicle Contracts
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[2]/div/div/ul/li[6]/a/span")).click();
        Thread.sleep(3000);

        //get pagename
        String actPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPageName);

    }

    @Test
    public void salesManagerTestToVehicleContracts() throws InterruptedException {
        String userName = "salesmanager110";
        String password = "UserUser123";

        String expUrl= "http://qa3.vytrack.com";
        String expTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        String expPageName = "All Vehicle Contract";

        driver.get(expUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("prependedInput")).sendKeys(userName); //put Username

        driver.findElement(By.id("prependedInput2")).sendKeys(password);// put password

        driver.findElement(By.id("_submit")).click(); //click login button
        Thread.sleep(5000);

        Actions builder = new Actions(driver);
        //Go to Fleet module and wait there
        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[2]/a/span"))).build().perform();
        Thread.sleep(10000);
        //Click Vehicle Contracts
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[2]/div/div/ul/li[6]/a/span")).click();
        Thread.sleep(3000);

        //get pagename
        String actPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPageName);
    }

    @Test
    public void driverTestToVehicleContracts() throws InterruptedException {
        String userName = "user10";
        String password = "UserUser123";
        String expUrl= "http://qa3.vytrack.com";
        String expNotice="You do not have permission to perform this action.";
        driver.get(expUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("prependedInput")).sendKeys(userName); //put Username

        driver.findElement(By.id("prependedInput2")).sendKeys(password);// put password

        driver.findElement(By.id("_submit")).click(); //click login button
        Thread.sleep(5000);

        Actions builder = new Actions(driver);
        Thread.sleep(5000);
        builder.moveToElement(driver.findElement(By.xpath("//div[@class='app-page__content']/header/div[2]/ul/li/a/span"))).build().perform();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@class='app-page__content']/header/div[2]/ul/li/div/div/ul/li[6]/a/span")).click();
        Thread.sleep(5000);

        String actNotice=driver.findElement(By.xpath("//*[@id='flash-messages']/div/div/div[2]/div")).getText();

        Assert.assertEquals(actNotice,expNotice);

    }



}
