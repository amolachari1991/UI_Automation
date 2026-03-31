package com.pages;

import com.pojo.AddressPojo;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourAddressPage extends BrowserUtility {
    public YourAddressPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME = By.xpath("//*[@id=\"firstname\"]");
    private static final By LAST_NAME = By.xpath("//*[@id=\"lastname\"]");
    private static final By COMPANY_NAME = By.xpath("//*[@id=\"company\"]");
    private static final By ADDRESS1 = By.xpath("//*[@id=\"address1\"]");
    private static final By ADDRESS2 = By.xpath("//*[@id=\"address2\"]");
    private static final By CITY = By.xpath("//*[@id=\"city\"]");
    private static final By STATE = By.xpath("//select[@id='id_state']");
    private static final By POST_CODE = By.xpath("//*[@id=\"postcode\"]");
    private static final By COUNTRY = By.xpath("//*[@name=\"id_country\"]");
    private static final By PHONE = By.xpath("//*[@id=\"phone\"]");
    private static final By MOBILE = By.xpath("//*[@id=\"phone_mobile\"]");
    private static final By ADDITIONAL_INFORMATION = By.xpath("//*[@id=\"other\"]");
    private static final By ALIAS = By.xpath("//*[@id=\"alias\"]");
    private static final By SUBMIT_BTN = By.xpath("//*[@id=\"submitAddress\"]");
    private static final By YOUR_ADDRESS_LISTED_BELLOW_TEXT = By.xpath("//p//strong[@class='dark']");



    public String saveAddress(AddressPojo addressPojo){
        enterText(FIRST_NAME, addressPojo.getFirstname());
        enterText(LAST_NAME, addressPojo.getLastname());
        enterText(COMPANY_NAME, addressPojo.getCompany());
        enterText(ADDRESS1, addressPojo.getAddress1());
        enterText(ADDRESS2, addressPojo.getAddress2());
        enterText(CITY, addressPojo.getCity());
        selectFromDropdown(STATE, addressPojo.getState());
        enterText(POST_CODE, addressPojo.getPostcode());
        selectFromDropdown(COUNTRY, addressPojo.getCountry());
        enterText(PHONE, addressPojo.getPhone());
        enterText(MOBILE, addressPojo.getMobile());
        enterText(ADDITIONAL_INFORMATION, addressPojo.getOther());
        enterText(ALIAS, addressPojo.getAlias());
        clickOn(SUBMIT_BTN);
        return getText(YOUR_ADDRESS_LISTED_BELLOW_TEXT);
    }

}
