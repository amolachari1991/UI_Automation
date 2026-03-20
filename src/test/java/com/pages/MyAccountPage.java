package com.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private static final By USER_NAME = By.xpath("//*[contains(text(), 'Abc abc')]");
    private static final By PRODUCT_SEARCH_LOCATOR = By.xpath("//*[@id=\"search_query_top\"]");
    private static final By ADD_MY_FIRST_ADDRESS_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]//span");


    public String getUserName(){
      String userName =  getText(USER_NAME);
        return userName;
    }

    public SearchResultPage productToSearch(String productName){
        enterText(PRODUCT_SEARCH_LOCATOR, productName);
        enterSpecialKey(PRODUCT_SEARCH_LOCATOR, Keys.ENTER);
        return new SearchResultPage(getDriver());
    }

    public YourAddressPage addMyFirstAddress(){
        clickOn(ADD_MY_FIRST_ADDRESS_LOCATOR);
        return new YourAddressPage(getDriver());
    }


}
