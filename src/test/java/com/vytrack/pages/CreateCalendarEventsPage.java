package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateCalendarEventsPage extends NavigationBar {
    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(css="input[id^=date_selector_oro_calendar_event_form_start]")
    public  WebElement startDate;

    @FindBy(css = ".ui-datepicker-year")
    public WebElement selectYear;

    @FindBy(css = "select[class='ui-datepicker-month'")
    public WebElement selectMonth;

    @FindBy(css =".ui-datepicker-year")
    public List<WebElement> calenderTables;

    @FindBy(css="input[id^=date_selector_oro_calendar_event_form_end")
    public  WebElement endDate;

    @FindBy(css = "button[class^='ui-datepicker-current ui-state-default ui-priority-secondary']")
    public WebElement today;

    @FindBy(css = "input[id^='time_selector_oro_calendar_event_form_start-uid']")
    public WebElement timeBoxStart;

    @FindBy(css = "input[id^='time_selector_oro_calendar_event_form_end-uid']")
    public WebElement timeBoxEnd;

    @FindBy(xpath = "//span[contains(text(),'day(s)')]/../input[1]")
    public WebElement repeatCheckDay;

    @FindBy(xpath = "//span[contains(text(),'day(s)')]/../input[3]")
    public WebElement repeatCheckBoxDay;

    @FindBy(xpath = "//span[contains(text(),'Weekday')]/../input")
    public WebElement repeatCheckWeekday;

    @FindBy(xpath = "//span[contains(text(),'Never')]/../input")
    public WebElement endsCheckNever;

    @FindBy(xpath = "//span[contains(text(),'After')]/../input")
    public WebElement endsCheckAfter;

    @FindBy(xpath = "//span[contains(text(),'After')]/../input[2]")
    public WebElement endsCheckBoxAfter;

    @FindBy(xpath = "//span[contains(text(),'After')]/../../span")
    public WebElement endsErrorAfter;

    @FindBy(xpath = "//span[contains(text(),'day(s)')]/../../span")
    public WebElement repeatErrorDay;

    @FindBy(css = "input[id^='dp15648']")
    public WebElement byChooseDate;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']/div[2]/div/span")
    public WebElement summary;


    public WebElement getTime(String time){
        String xpathTime = "//li[contains(text(),'"+ time +"')]";
        BrowserUtils.waitForVisibility(By.xpath(xpathTime),5);
        return Driver.get().findElement(By.xpath(xpathTime));
    }

    public Select yearList(){ return new Select(selectYear);}



    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }

    public Select MonthList(){return new Select(selectMonth);
    }
    public WebElement getDate(String day){
        String dateXpath = "//table[@class='ui-datepicker-calendar']//a[contains(text(),'"+ day +"')]";
        return Driver.get().findElement(By.xpath(dateXpath));
    }

}