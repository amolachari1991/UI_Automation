package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args)  {
        WebDriver wd = new ChromeDriver();
        wd.get("http://automationpractice.techwithjatin.com");
        wd.manage().window().maximize();
        By signInBtnLocator = By.xpath("//*[contains(text(),\"Sign in\")]");
        WebElement signInBtnWebElement = wd.findElement(signInBtnLocator);
        signInBtnWebElement.click();

        By emailLocator = By.id("email");
        WebElement emailWebElement = wd.findElement(emailLocator);
        emailWebElement.sendKeys("qxr50gl7te@lnovic.com");

        By passwdLocator = By.id("passwd");
        WebElement passwdWebElement = wd.findElement(passwdLocator);
        passwdWebElement.sendKeys("Email");

        By loginLocator = By.id("SubmitLogin");
        WebElement loginWebElement = wd.findElement(loginLocator);
        loginWebElement.click();
        wd.quit();
    }
}
