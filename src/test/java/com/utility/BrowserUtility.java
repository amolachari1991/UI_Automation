package com.utility;

import com.constants.Browsers;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerUtility.getLogger(this.getClass());


    public BrowserUtility(WebDriver driver) {
        this.driver.set(driver);
    }

    public BrowserUtility(String browserName) {
        logger.info("launching browser => " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        } else {
            logger.error("wrong browser selected");
            System.out.println("Select eighter chrome of edge");
        }
    }

    public BrowserUtility(Browsers browserName, Boolean isHeadless) {
        logger.info("launching browser => " + browserName);
        if (browserName == Browsers.CHROME) {
            if (isHeadless) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=old");
                driver.set(new ChromeDriver(chromeOptions));
            } else {
                driver.set(new ChromeDriver());
            }
        } else if (browserName == Browsers.EDGE) {
            if (isHeadless) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=old");
                edgeOptions.addArguments("disable-gpu");
                driver.set(new EdgeDriver(edgeOptions));
            } else {
                driver.set(new EdgeDriver());
            }
        } else if (browserName == Browsers.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=old");
                driver.set(new FirefoxDriver(firefoxOptions));
            } else {
                driver.set(new FirefoxDriver());
            }
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void goToWebsite(String url) {
        driver.get().get(url);
    }

    public void maximizeWindow() {
        logger.info("Maximizing browser window");
        driver.get().manage().window().maximize();
    }

    public void clickOn(WebElement element) {
        logger.info("clicking on WebElement => " + element);
        element.click();
        logger.info("successfully clicked on WebElement => " + element);
    }

    public void clickOnViaJavaScriptExecutor(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        logger.info("clicking on locator => " + locator);
        WebElement element = driver.get().findElement(locator);
        js.executeScript("arguments[0].click();",element);
        logger.info("successfully clicked on WebElement => " + element);
    }
    public void clickOn(By locator) {
        logger.info("clicking on locator => " + locator);
        WebElement element = driver.get().findElement(locator);
        element.click();
        logger.info("successfully clicked on locator => " + locator);
    }

    public void selectFromDropdown(By locator, String visibleText) {
        logger.info("selecting "+visibleText+" from dropdown locator=> " + locator);
        WebElement element = driver.get().findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
        logger.info("option "+visibleText+" selected");
    }
    public void clearInputField(By locator) {
        logger.info("clearing the previous text from inputfield " + locator);
        WebElement element = driver.get().findElement(locator);
        element.clear();
        logger.info("text field cleard");
    }

    public void enterText(By locator, String textToEnter) {
        clearInputField(locator);
        logger.info("entering text into locator " + locator);
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(textToEnter);
        logger.info("text entered into locator " + locator);
    }

    public void enterSpecialKey(By locator, Keys keyToEnter) {
        logger.info("entering SpecialKey into locator " + locator);
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(keyToEnter);
        logger.info("SpecialKey entered into locator " + locator);
    }

    public String getText(By locator) {
        logger.info("getting text from locator => " + locator);
        WebElement element = driver.get().findElement(locator);
        String text = element.getText();
        return text;
    }

    public List<String> getTextFromListOfWebElement(By locator) {
        logger.info("getting text from list of webelements => " + locator);
        List<String> list = new ArrayList<>();
        List<WebElement> elements = driver.get().findElements(locator);
        for (WebElement element : elements) {
//            System.out.println(getText(element));
            list.add(getText(element));
        }
        return list;
    }

    public List<WebElement> getListOfWebElement(By locator) {
        logger.info("getting list of webelements => ");
        List<WebElement> elements = driver.get().findElements(locator);
        return elements;
    }

    public String getText(WebElement element) {
        logger.info("getting text from WebElement => " + element);
        String text = element.getText();
        return text;
    }

    public String dynamicTimeStampName() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = simpleDateFormat.format(date);
        return timeStamp;
    }

    public String takeScreenShot(String name) {
        String timeStamp = dynamicTimeStampName();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = ".//screenshots//" + timeStamp + "-" + name + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public void quitBrowser() {
        if (driver.get() != null) {
            logger.info("quitting browser");
            driver.get().quit();
            driver.remove();
        }
    }

}
