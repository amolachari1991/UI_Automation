package com.pages;

import com.constants.Browsers;
import static com.constants.Environments.*;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtility.*;

import com.utility.JsonUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public final class HomePage extends BrowserUtility {
    Logger logger = LoggerUtility.getLogger(this.getClass());


  /*  public HomePage(String browserName) {
        super(browserName);
        goToWebsite("http://automationpractice.techwithjatin.com");
        maximizeWindow();
    }*/

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage(Browsers browserName, Boolean isHeadless) throws FileNotFoundException {
        super(browserName, isHeadless);
//        goToWebsite(readProperty(QA, "URL"));//reading environment from property file
        goToWebsite(JsonUtility.jsonReader(QA).getUrl());//reading environment from JSON file
        maximizeWindow();
    }

   private static final By SIGN_IN_BTN_LOCATOR = By.xpath("//*[contains(text(),\"Sign in\")]");



    public LoginPage goToLoginPage(){
        clickOn(SIGN_IN_BTN_LOCATOR);
        return new LoginPage(getDriver());
    }
}
