package com.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private static final By USER_NAME = By.xpath("//*[contains(text(), 'Abc abc')]");

    public String getUserName(){
      String userName =  getText(USER_NAME);
        return userName;
    }


}
