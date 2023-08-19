package com.actoJava.qa.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actoJava.qa.base.BaseTest;

import dev.failsafe.internal.util.Assert;


public class SearchPage extends BaseTest {
    @FindBy(id = "search_type_option_ROUNDTRIP")
    private WebElement roundTripRadioBtn;

    @FindBy(xpath = "//button[@data-ui-name='input_location_from_segment_0']")
    private WebElement fromButton;

    @FindBy(xpath = "//input[@placeholder='Airport or city']")
    private WebElement airportOrCity;

    @FindBy(xpath = "//input[@name='CITYLON']")
    private WebElement fromCityCheckBox;

    @FindBy(xpath = "//button[@data-ui-name='input_location_to_segment_0']")
    private WebElement toButton;

    @FindBy(xpath = "//input[@name='CITYNYC']")
    private WebElement toCityCheckBox;

    @FindBy(xpath = "//span[@data-date='2023-09-23']")
    private WebElement fromDate;

    @FindBy(xpath = "//span[@data-date='2023-09-29']")
    private WebElement toDate;

    @FindBy(xpath = "//button[@data-ui-name='button_date_segment_0']")
    private WebElement dateButton;

    @FindBy(xpath = "//button[@data-ui-name='button_search_submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[text()='Accept']")
    private WebElement acceptBtn;
    
    @FindBy(xpath = "//span[text()='Cheapest']")
    private WebElement cheapestBtn;
    
    @FindBy(xpath = "//div[@data-test-id='flight_card_price_main_price']")
    private WebElement[] prices;
    

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void fillFieldsAndClickonSearch() {
        acceptBtn.click();
        roundTripRadioBtn.click();
        fromButton.click();
        airportOrCity.clear();
        airportOrCity.sendKeys("London");
       // fromCityCheckBox.click();
        toButton.click();
        airportOrCity.clear();
        airportOrCity.sendKeys("New York");
        toCityCheckBox.click();
        dateButton.click();
        fromDate.click();
        toDate.click();
        searchButton.click();
      acceptBtn.click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        cheapestBtn.click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        List<WebElement> ele=driver.findElements(By.xpath("//div[@data-test-id='flight_card_price_main_price']"));
        System.out.println("Number of prices "+ ele.size());
        for(WebElement w:ele){
            System.out.println("Hello");
            System.out.println(w.getText());
        }
        String selectedFlightPrice=driver.findElement(By.xpath("//div[@data-test-id='flight_card_price_main_price']")).getText();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        driver.findElement(By.xpath("//*[text()='See flight']")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        driver.findElement(By.xpath("//*[text()='Select']")).click();
        String text=driver.findElement(By.xpath("//*[@data-testid='breakdown_list_price']")).getText();
        System.out.println(text);
       //Assert.(selectedFlightPrice, text);
    }
}
