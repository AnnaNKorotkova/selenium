package org.example.applicationtest.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Page{

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost:8055/litecart/en/rubber-ducks-c-1/");
    }
    @FindBy(xpath="//div[@class ='content']/ul[2]/li/a[@class='link']")
    public List<WebElement> products;

    @FindBy(xpath="//button[@name='add_cart_product']")
    public WebElement addProduct;

}
