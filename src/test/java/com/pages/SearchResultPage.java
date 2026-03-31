package com.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SearchResultPage extends BrowserUtility {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private static final By SEARCHED_TEXT_LOCATOR = By.xpath("//*[@class=\"lighter\"]");
    private static final By PRODOUCT_LIST_LOCATOR = By.xpath("//h5//*[@title=\"Printed Summer Dress\"]"); //h5//*[@title="Printed Summer Dress"] //h5[@itemprop="name"]//a

    public String searchedText(){
        return getText(SEARCHED_TEXT_LOCATOR);
    }

    public List<String> getProductList(){

        return getTextFromListOfWebElement(PRODOUCT_LIST_LOCATOR);
    }
    public ProductDetailsPage clickOnProductAtIndex(int i){

        clickOn(getListOfWebElement(PRODOUCT_LIST_LOCATOR).get(i));
        return new ProductDetailsPage(getDriver());
    }
}
