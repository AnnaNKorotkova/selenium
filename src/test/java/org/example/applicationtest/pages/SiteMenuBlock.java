package org.example.applicationtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiteMenuBlock extends Page {

    public SiteMenuBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav[@id='site-menu']/ul/li[@class='general-0']/a")
    public WebElement goHome;

    @FindBy(xpath = "//nav[@id='site-menu']/ul/li[@class='category-1']/a")
    public WebElement backToCategories;
}
