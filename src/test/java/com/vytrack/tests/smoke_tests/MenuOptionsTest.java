package com.vytrack.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class MenuOptionsTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void menuOptionsDriver() throws InterruptedException {

        String expUrl= "http://qa3.vytrack.com";
        String driverUsername ="user10";
        String password="UserUser123";
        String expTitle="";
        String expPagename="";
        driver.get(expUrl);  //open the url
        driver.manage().window().maximize();
        driver.findElement(By.id("prependedInput")).sendKeys(driverUsername); //put Username

        driver.findElement(By.id("prependedInput2")).sendKeys(password);// put password

        driver.findElement(By.id("_submit")).click(); //click login button

        Actions builder = new Actions(driver);
        Thread.sleep(5000);
        builder.moveToElement(driver.findElement(By.xpath("//div[@class='app-page__content']/header/div[2]/ul/li/a/span"))).build().perform();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@class='app-page__content']/header/div[2]/ul/li/div/div/ul/li[3]/a/span")).click();
        Thread.sleep(5000);

        expTitle="Car - Entities - System - Car - Entities - System";
        expPagename="Cars";
        String actPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);



        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[2]/a/span"))).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        Thread.sleep(5000);

        expTitle ="Accounts - Customers";
        expPagename="Accounts";
        actPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);

        builder.release();
        Thread.sleep(3000);
        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div[2]/header/div[2]/ul/li[2]/a"))).build().perform();
        Thread.sleep(3000);
//        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div[2]/header/div[2]/ul/li[2]/a/span"))).click().build().perform();
//        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[2]/div/div/ul/li[4]/a/span")).click();
        Thread.sleep(3000);



         expTitle = "Contacts - Customers";
         expPagename = "Contacts";
         actPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);

         builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[3]/a/span"))).build().perform();
         Thread.sleep(3000);
         driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[3]/div/div/ul/li[3]/a/span")).click();
         Thread.sleep(3000);

         expTitle = "Calendar Events - Activities";
         expPagename="Calendar Events";
         actPageName =driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);


    }
    @Test
    public void menuOptionsStoreManager() throws InterruptedException {

        String expUrl= "http://qa3.vytrack.com";
        String driverUsername ="storemanager57";
        String password="UserUser123";
        String expTitle="";
        String expPagename="";
        driver.get(expUrl);  //open the url
        driver.manage().window().maximize();

        driver.findElement(By.id("prependedInput")).sendKeys(driverUsername); //put Username

        driver.findElement(By.id("prependedInput2")).sendKeys(password);// put password

        driver.findElement(By.id("_submit")).click(); //click login button

        Actions builder = new Actions(driver);
        Thread.sleep(5000);
        builder.moveToElement(driver.findElement(By.xpath("//div[@class='app-page__content']/header/div[2]/ul/li/a/span"))).build().perform();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@class='app-page__content']/header/div[2]/ul/li/div/div/ul/li[3]/a/span")).click();
        Thread.sleep(5000);
        expTitle="Dashboard - Dashboards";
        expPagename="Dashboard";
        String actPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);



        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[2]/a/span"))).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        Thread.sleep(5000);

        expTitle="All - Car - Entities - System - Car - Entities - System";
        expPagename="All Cars";
        actPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);


        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[3]/a/span"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[3]/div/div/ul/li[3]/a/span")).click();
        Thread.sleep(3000);

        expTitle = "All - Accounts - Customers";
        expPagename="All Accounts";
        actPageName =driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);


        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[3]/a/span"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[3]/div/div/ul/li[4]/a/span")).click();
        Thread.sleep(3000);

        expTitle = "All - Contacts - Customers";
        expPagename="All Contacts";
        actPageName =driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);


        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[4]/a/span"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[4]/div/div/ul/li[3]/a/span")).click();
        Thread.sleep(3000);

        expTitle = "Open Opportunities - Opportunities - Sales";
        expPagename="Open Opportunities";
        actPageName =driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);

        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[5]/a/span"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[5]/div/div/ul/li[3]/a/span")).click();
        Thread.sleep(3000);

        expTitle = "All - Calls - Activities";
        expPagename="All Calls";
        actPageName =driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);

        builder.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[5]/a/span"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='page']/div/header/div[2]/ul/li[5]/div/div/ul/li[4]/a/span")).click();
        Thread.sleep(3000);

        expTitle = "All - Calendar Events - Activities";
        expPagename="All Calendar Events";
        actPageName =driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(driver.getTitle(),expTitle);
        Assert.assertEquals(actPageName,expPagename);

    }



}
