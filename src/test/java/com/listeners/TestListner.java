package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportsUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.Objects;


public class TestListner implements ITestListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void onTestStart(ITestResult result) {
        logger.info("Method Name => "+result.getMethod().getMethodName());
        logger.info(result.getMethod().getMethodName()+" Discription => "+result.getMethod().getDescription());
        logger.info(result.getMethod().getMethodName()+" Belongs To Groups => "+Arrays.toString(result.getMethod().getGroups()));
        ExtentReportsUtility.createExtentTest(result.getMethod().getMethodName());
        ExtentReportsUtility.getTest().log(Status.INFO, "Method Name => "+result.getMethod().getMethodName());
        ExtentReportsUtility.getTest().log(Status.INFO, result.getMethod().getMethodName()+" Discription => "+result.getMethod().getDescription());
        ExtentReportsUtility.getTest().log(Status.INFO, result.getMethod().getMethodName()+" Belongs To Groups => "+Arrays.toString(result.getMethod().getGroups()));


    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" "+"PASSED");
        ExtentReportsUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" PASSED");

    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName()+" "+"FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReportsUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" FAILED");
        ExtentReportsUtility.getTest().log(Status.FAIL, result.getThrowable());
        ExtentReportsUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

        Object testClassInstance = result.getInstance();
        TestBase testBase = ((TestBase)testClassInstance);
        BrowserUtility browserUtility = ((TestBase)testClassInstance).getInstance();

        logger.info("capturing screenshot for faild method");
        String screenShotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
        logger.info("Attaching scrrenshot to extentreport");
        ExtentReportsUtility.getTest().addScreenCaptureFromPath(screenShotPath);

    }

    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName()+" "+"SKIPPED");
        ExtentReportsUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" SKIPPED");
    }

     public void onStart(ITestContext context) {

        logger.info("Test suite started");
         ExtentReportsUtility.createSparkReport("report.html");
     }

    public void onFinish(ITestContext context) {
        logger.info("Test suite completed");
        ExtentReportsUtility.flushReport();


    }

}
