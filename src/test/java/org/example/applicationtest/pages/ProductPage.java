package org.example.applicationtest.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page{

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost:8055/litecart/en/");
    }

    @FindBy(xpath="//div[@class ='content']/div[@class='box']/div/ul/li/a[@class='link']")
    public List<WebElement> products;

    @FindBy(xpath="//button[@name='add_cart_product']")
    public WebElement addProduct;

    @FindBy(xpath="//select")
    public List<WebElement> select;

    public void selectSize(WebElement select) {
        var size = new Select(select);
        size.selectByIndex(1);
    }

}
