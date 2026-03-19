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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {
   protected static ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerUtility.getLogger(this.getClass());



    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        this.driver.set(driver);
    }

    public BrowserUtility(String browserName) {
        logger.info("launching browser => "+browserName);
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
        logger.info("launching browser => "+browserName);
        if (browserName == Browsers.CHROME) {
            if(isHeadless){
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=old");
                driver.set(new ChromeDriver(chromeOptions));
            }else {
                driver.set(new ChromeDriver());
            }
        } else if (browserName == Browsers.EDGE) {
            if(isHeadless){
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=old");
                edgeOptions.addArguments("disable-gpu");
                driver.set(new EdgeDriver(edgeOptions));
            }else {
                driver.set(new EdgeDriver());
            }
        } else if (browserName == Browsers.FIREFOX) {
            if(isHeadless){
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=old");
                driver.set(new FirefoxDriver(firefoxOptions));
            }else {
                driver.set(new FirefoxDriver());
            }
        }
    }

        public void goToWebsite (String url){
            driver.get().get(url);
        }
        public void maximizeWindow () {
            logger.info("Maximizing browser window");
            driver.get().manage().window().maximize();
        }
        public void clickOn (By locator){
            logger.info("clicking on locator => "+ locator);
            WebElement element = driver.get().findElement(locator);
            element.click();
            logger.info("successfully clicked on locator => "+ locator);
        }
        public void enterText (By locator, String textToEnter){
            logger.info("entering text into locator "+ locator);
            WebElement element = driver.get().findElement(locator);
            element.sendKeys(textToEnter);
            logger.info("text entered into locator "+ locator);
        }
        public String getText (By locator){
            logger.info("getting text from locator => "+ locator);
            WebElement element = driver.get().findElement(locator);
            String text = element.getText();
            return text;
        }
        public String dynamicTimeStampName(){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
            String timeStamp = simpleDateFormat.format(date);
            return timeStamp;
        }

        public String takeScreenShot(String name){
            String timeStamp = dynamicTimeStampName();
            TakesScreenshot takesScreenshot =  (TakesScreenshot)driver.get();
            File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir")+"\\screenshots\\"+timeStamp+"-"+name+".png";
            File destination = new File(path);
            try {
                FileUtils.copyFile(src, destination);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return path;
        }

        public void quitBrowser(){
            if(driver.get()!=null){
                logger.info("quitting browser");
                driver.get().quit();
                driver.remove();
            }
        }

}
