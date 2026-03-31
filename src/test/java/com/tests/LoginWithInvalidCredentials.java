package com.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.listeners.TestListner.class})
public class LoginWithInvalidCredentials extends TestBase{
    private static final String INVALID_MAIL = "tret@gmail.com";
    private static final String INVALID_PASS = "123654";

     @Test(description = "verifies whether user able to login with valid credentials", groups = {"e2e", "sanity", "smoke"},
            retryAnalyzer = com.listeners.MyRetryAnalyser.class)
    public void invalidLoginTest() {
        Assert.assertEquals(homePage.goToLoginPage().doLogInWithInvalidCredentials(INVALID_MAIL, INVALID_PASS).getErrorMsg(), "Authentication failed.");
    }


}
