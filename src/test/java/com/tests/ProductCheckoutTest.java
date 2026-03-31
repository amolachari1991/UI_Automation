package com.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({com.listeners.TestListner.class})
public class ProductCheckoutTest extends TestBase {
    String searchedText = "Printed Summer Dress";


    @Test(description = "To checkout the searched product", groups = {"e2e", "sanity", "smoke"})
    public void productCheckoutTest() {
        int index = 0;
        myAccountPage();
        myAccountPage.productToSearch(searchedText).clickOnProductAtIndex(0).selectProductSize().addToCart().proceedToCheckOutBtn().proceedToCheckOutBtn2().proceedToCheckOutBtn2().selectI_AgreeCheckbox().proceedToCheckOutBtn2();

    }
}
