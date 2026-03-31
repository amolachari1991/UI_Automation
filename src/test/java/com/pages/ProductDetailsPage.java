package com.pages;

import com.constants.Size;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BrowserUtility {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private static final By SIZE_DROPDOWN = By.xpath("//*[@id='group_1']");
    private static final By ADD_TO_CART = By.xpath("//span[.='Add to cart']");
    private static final By PROCEED_TO_CHECKOUT_BTN = By.xpath("//*[contains(text(),'Proceed to checkout')]");
    private static final By PROCEED_TO_CHECKOUT_BTN2 = By.xpath("(//*[contains(text(),'Proceed to checkout')])[2]");
    private static final By I_AGREE_CHECKBOX = By.xpath("//*[@id='uniform-cgv']");


    public ProductDetailsPage selectProductSize(){
        selectFromDropdown(SIZE_DROPDOWN, Size.M.toString());
        return this;
    }
    public ProductDetailsPage addToCart(){
        clickOn(ADD_TO_CART);
        return this;
    }
    public ProductDetailsPage proceedToCheckOutBtn(){
        clickOnViaJavaScriptExecutor(PROCEED_TO_CHECKOUT_BTN);
        return this;
    }
    public ProductDetailsPage proceedToCheckOutBtn2(){
        clickOnViaJavaScriptExecutor(PROCEED_TO_CHECKOUT_BTN2);
        return this;
    }
    public ProductDetailsPage selectI_AgreeCheckbox(){
        clickOn(I_AGREE_CHECKBOX);
        return this;
    }
}
