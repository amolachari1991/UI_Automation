package com.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners({com.listeners.TestListner.class})
public class ProductSearchTest extends TestBase {
    String searchedText = "Printed Summer Dress";


    @Test(description = "To search the product", groups = {"e2e", "sanity", "smoke"})
    public void searchProductTest() {
        myAccountPage();
        List<String> productList = myAccountPage.productToSearch(searchedText).getProductList();
        productList.stream().forEach(System.out::println);
       Assert.assertEquals(productList.stream().allMatch(n -> n.equalsIgnoreCase(searchedText)), true);
    }
}
