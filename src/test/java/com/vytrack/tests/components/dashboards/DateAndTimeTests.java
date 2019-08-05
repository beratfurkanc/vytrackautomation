package com.vytrack.tests.components.dashboards;

import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.MethodUtils;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vytrack.pages.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAndTimeTests extends TestBase {


    @BeforeMethod
    public void setUpMethod2() {

        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void testid1() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities", "Calendar Events");
        VytrackUtils.waitForUIOverlay();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        VytrackUtils.waitForUIOverlay();
        BrowserUtils.waitForVisibility(createCalendarEventsPage.startDate, 5);

        createCalendarEventsPage.startDate.click();
        String currentDate = createCalendarEventsPage.startDate.getAttribute("value");
        String yearStr = createCalendarEventsPage.yearList().getFirstSelectedOption().getText();
        String futureYearStr = "" + (Integer.parseInt(yearStr) + 1);

        createCalendarEventsPage.yearList().selectByValue(futureYearStr);
        createCalendarEventsPage.getDate("15").click();

        VytrackUtils.waitForUIOverlay();
        Assert.assertEquals(createCalendarEventsPage.startDate.getAttribute("value"), createCalendarEventsPage.endDate.getAttribute("value"));

        createCalendarEventsPage.startDate.click();

        BrowserUtils.waitForVisibility(createCalendarEventsPage.today, 5);
        createCalendarEventsPage.today.click();
        VytrackUtils.waitForUIOverlay();
        Assert.assertEquals(currentDate, createCalendarEventsPage.endDate.getAttribute("value"));

    }


    @Test
    public void testid2() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities", "Calendar Events");
        VytrackUtils.waitForUIOverlay();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        VytrackUtils.waitForUIOverlay();
        createCalendarEventsPage.timeBoxStart.click();

        //js.executeScript("arguments[0].click()", createCalendarEventsPage.getTime("4:30 AM"));
        createCalendarEventsPage.getTime("4:30 AM").click();

        Assert.assertEquals(createCalendarEventsPage.timeBoxEnd.getAttribute("value"), "5:30 AM");


    }

    @Test
    public void testid3() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities", "Calendar Events");
        VytrackUtils.waitForUIOverlay();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        VytrackUtils.waitForUIOverlay();

        String currentDay = createCalendarEventsPage.startDate.getAttribute("value");
        createCalendarEventsPage.timeBoxStart.click();
        createCalendarEventsPage.getTime("11:30 PM").click();
        String nextDay = MethodUtils.getNextDate(currentDay);

        Assert.assertEquals(createCalendarEventsPage.endDate.getAttribute("value"),nextDay);

    }




}

