package com.tests;

import com.pages.HomePage;
import com.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.constants.Browsers.CHROME;
@Listeners({com.listeners.TestListner.class})
public class LoginTest3 extends TestBase{


    @Test(description = "verifies whether user able to login with valid credentials", groups = {"e2e", "sanity", "smoke"},
            dataProviderClass = com.dataProviders.LoginDataProvider.class, dataProvider = "loginDataProvider")
    public void loginTest(User user) {
        Assert.assertEquals(homePage.goToLoginPage().doLogInWith(user.getEmail(), user.getPassword()).getUserName(), "Abc abc");

    }

    @Test(description = "verifies whether user able to login with valid credentials", groups = {"e2e", "sanity", "smoke"},
            dataProviderClass = com.dataProviders.LoginDataProvider.class, dataProvider = "loginCSVDataProvider")
    public void loginCSVTest(User user) {
        Assert.assertEquals(homePage.goToLoginPage().doLogInWith(user.getEmail(), user.getPassword()).getUserName(), "Abc abc");

    }
    @Test(description = "verifies whether user able to login with valid credentials", groups = {"e2e", "sanity", "smoke"},
            dataProviderClass = com.dataProviders.LoginDataProvider.class, dataProvider = "loginExcelDataProvider", retryAnalyzer = com.listeners.MyRetryAnalyser.class)
    public void loginExcelTest(User user) {

        Assert.assertEquals(homePage.goToLoginPage().doLogInWith(user.getEmail(), user.getPassword()).getUserName(), "Abc abc");

    }


}
