package com.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private static final By EMAIL_LOCATOR = By.id("email");
    private static final By PASSWD_LOCATOR = By.id("passwd");
    private static final By LOGIN_LOCATOR = By.id("SubmitLogin");
    private static final By ERROR_MSG_LOCATOR = By.xpath("//*[contains(@class, \"alert-danger\")]//li");

    public MyAccountPage doLogInWith(String email, String Pass){
        enterText(EMAIL_LOCATOR, email);
        enterText(PASSWD_LOCATOR, Pass);
        clickOn(LOGIN_LOCATOR);
        return new MyAccountPage(getDriver());
    }

    public LoginPage doLogInWithInvalidCredentials(String email, String Pass){
        enterText(EMAIL_LOCATOR, email);
        enterText(PASSWD_LOCATOR, Pass);
        clickOn(LOGIN_LOCATOR);
        return this;
    }

    public String getErrorMsg(){
        return getText(ERROR_MSG_LOCATOR);
    }

}
