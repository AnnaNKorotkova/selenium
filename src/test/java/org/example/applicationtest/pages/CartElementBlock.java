package org.example.applicationtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartElementBlock extends Page {

    public CartElementBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='cart']/a/span[@class='quantity']")
    public WebElement countProducts;

    @FindBy(xpath = "//div[@id='cart']/a[@class='link']")
    public WebElement chechout;
}
