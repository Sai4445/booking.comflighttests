package com.actoJava.qa.endToEndTests;

import org.testng.annotations.Test;

import com.actoJava.qa.base.BaseTest;
import com.actoJava.qa.pages.SearchPage;

public class FlightValidationTests extends BaseTest{
    @Test
    public void validateFlightDetails(){
        SearchPage searchPage=new SearchPage();
        searchPage.fillFieldsAndClickonSearch();
    }
}
