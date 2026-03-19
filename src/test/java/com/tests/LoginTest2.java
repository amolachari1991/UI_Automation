package com.tests;

import com.pages.HomePage;

import java.io.FileNotFoundException;

import static com.constants.Browsers.CHROME;

public class LoginTest2 {
    public static void main(String[] args) throws FileNotFoundException {
//        HomePage homePage = new HomePage("chrome");
        HomePage homePage = new HomePage(CHROME,true);
        String Username = homePage.goToLoginPage().doLogInWith("qxr50gl7te@lnovic.com","Email").getUserName();
        System.out.println(Username);

    }
}
