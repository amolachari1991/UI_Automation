package com.tests;

import com.constants.Browsers;
import com.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;

import static com.constants.Browsers.CHROME;

public class TestBase {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest  ;

    @Parameters({"browser","isLambdaTest", "isHeadless" })
    @BeforeMethod(description = "Loads the homepage of website")
    public void setUp(
            @Optional("chrome") String browser,
            @Optional("false") boolean isLambdaTest,
            @Optional("true") boolean isHeadless, ITestResult result) throws FileNotFoundException {
        this.isLambdaTest = isLambdaTest;
        WebDriver lambdaDriver;
        if(isLambdaTest){
            lambdaDriver = LambdaTestUtility.intializeLambdaTestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        }else {
            homePage = new HomePage(Browsers.valueOf(browser.toUpperCase()), isHeadless);
        }
    }
    @AfterMethod(description = "close all browser instances")
    public void tearDown() {
        if(isLambdaTest){
            LambdaTestUtility.quitSession();
        }else {
            homePage.quitBrowser();
        }
    }

    public BrowserUtility getInstance(){
        return homePage;
    }
}
