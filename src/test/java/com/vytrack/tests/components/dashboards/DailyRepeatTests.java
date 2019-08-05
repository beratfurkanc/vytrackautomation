package com.vytrack.tests.components.dashboards;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.CreateCalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class DailyRepeatTests extends TestBase {

    @BeforeMethod
    public void setUpMehtod2(){
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
    }
    @Test
    public void testid1(){

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities","Calendar Events");

        VytrackUtils.waitForUIOverlay();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        VytrackUtils.waitForUIOverlay();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        BrowserUtils.waitForVisibility(createCalendarEventsPage.repeatCheckDay,5);

        String rpt = createCalendarEventsPage.repeatOptionsList().getFirstSelectedOption().getText();

        Assert.assertEquals(rpt,"Daily");
        Assert.assertEquals(createCalendarEventsPage.repeatCheckDay.isSelected(),true);
        Assert.assertEquals(createCalendarEventsPage.repeatCheckBoxDay.getAttribute("value"),"1");
        Assert.assertEquals(createCalendarEventsPage.summary.getText(),"Daily every 1 day");
        createCalendarEventsPage.repeatCheckWeekday.click();

        wait.until(ExpectedConditions.elementSelectionStateToBe(createCalendarEventsPage.repeatCheckWeekday,true));
        Assert.assertEquals(createCalendarEventsPage.repeatCheckDay.isSelected(),false);
        Assert.assertEquals(createCalendarEventsPage.summary.getText(),"Daily, every weekday");

    }

    @Test
    public void testid2(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities","Calendar Events");

        VytrackUtils.waitForUIOverlay();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        VytrackUtils.waitForUIOverlay();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        BrowserUtils.waitForVisibility(createCalendarEventsPage.repeatCheckDay,5);
        String rpt = createCalendarEventsPage.repeatOptionsList().getFirstSelectedOption().getText();

        Assert.assertEquals(rpt,"Daily");
        Assert.assertEquals(createCalendarEventsPage.repeatCheckDay.isSelected(),true);
        Assert.assertEquals(createCalendarEventsPage.repeatCheckBoxDay.getAttribute("value"),"1");
        Assert.assertEquals(createCalendarEventsPage.summary.getText(),"Daily every 1 day");

    }
        @Test
        public void testid3(){

            LoginPage loginPage = new LoginPage();
            loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));

            DashboardPage dashboardPage = new DashboardPage();
            dashboardPage.selectMenuOption("Activities","Calendar Events");

            VytrackUtils.waitForUIOverlay();
            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
            calendarEventsPage.createCalendarEvent.click();
            VytrackUtils.waitForUIOverlay();
            CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
            createCalendarEventsPage.repeat.click();

            BrowserUtils.waitForVisibility(createCalendarEventsPage.repeatCheckDay,5);

            createCalendarEventsPage.repeatCheckBoxDay.clear();
            createCalendarEventsPage.repeatCheckBoxDay.sendKeys("-1", Keys.ENTER);
            Assert.assertEquals(createCalendarEventsPage.repeatErrorDay.getText(),"The value have not to be less than 1.");
            createCalendarEventsPage.repeatCheckBoxDay.clear();
            createCalendarEventsPage.repeatCheckBoxDay.sendKeys("100",Keys.ENTER);
            Assert.assertEquals(createCalendarEventsPage.repeatErrorDay.getText(),"The value have not to be more than 99.");
            createCalendarEventsPage.repeatCheckBoxDay.clear();
            createCalendarEventsPage.repeatCheckBoxDay.sendKeys("5",Keys.ENTER);
            Assert.assertEquals(createCalendarEventsPage.repeatErrorDay.isDisplayed(),false);

        }

    @Test
    public void testid4(){

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities","Calendar Events");

        VytrackUtils.waitForUIOverlay();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        VytrackUtils.waitForUIOverlay();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        BrowserUtils.waitForVisibility(createCalendarEventsPage.repeatCheckDay,5);

        String randomNumber = "" +(int)(Math.random()*100);

        createCalendarEventsPage.repeatCheckBoxDay.clear();
        createCalendarEventsPage.repeatCheckBoxDay.sendKeys(randomNumber, Keys.ENTER);
        Assert.assertEquals(createCalendarEventsPage.summary.getText(),"Daily every "+randomNumber+" days");

        randomNumber = "" +(int)(Math.random()*100);
        createCalendarEventsPage.repeatCheckBoxDay.clear();
        createCalendarEventsPage.repeatCheckBoxDay.sendKeys(randomNumber,Keys.ENTER);
        Assert.assertEquals(createCalendarEventsPage.summary.getText(),"Daily every "+randomNumber+" days");

}
    @Test
    public void testid5(){

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities","Calendar Events");

        VytrackUtils.waitForUIOverlay();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        VytrackUtils.waitForUIOverlay();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        BrowserUtils.waitForVisibility(createCalendarEventsPage.repeatCheckDay,5);

        createCalendarEventsPage.repeatCheckBoxDay.clear();
        Assert.assertEquals(createCalendarEventsPage.repeatErrorDay.getText(),"This value should not be blank.");
        createCalendarEventsPage.repeatCheckBoxDay.sendKeys("15",Keys.ENTER);
        Assert.assertEquals(createCalendarEventsPage.repeatErrorDay.isDisplayed(),false);
        createCalendarEventsPage.endsCheckAfter.click();
        createCalendarEventsPage.endsCheckBoxAfter.sendKeys("",Keys.ENTER);
        Assert.assertEquals(createCalendarEventsPage.endsErrorAfter.getText(),"This value should not be blank.");
        createCalendarEventsPage.endsCheckBoxAfter.sendKeys("15",Keys.ENTER);
        Assert.assertEquals(createCalendarEventsPage.endsErrorAfter.isDisplayed(),false);

}
        @Test
        public void testid6(){

        }
}
