package org.example.applicationtest.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BucketPage extends Page{

    public BucketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void refreshBucket() {
        driver.navigate().refresh();
    }
    @FindBy(xpath="//div[@id='cart']/a[@class='link']")
    public WebElement enterToCart;

    @FindBy(xpath="//button[@name='remove_cart_item']")
    public WebElement removeOrder;

    @FindBy(xpath="//ul[@class='shortcuts']/li/a")
    public List<WebElement> listProducts;

}
