package com.tests;

import com.pages.HomePage;
import com.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;

import static com.constants.Browsers.CHROME;

public class LoginTest1 {
    public static void main(String[] args) throws FileNotFoundException {
        WebDriver wd = new ChromeDriver();
//        HomePage homePage = new HomePage("chrome");
        HomePage homePage = new HomePage(CHROME, true);
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.doLogInWith("qxr50gl7te@lnovic.com","Email");

    }
}
