package org.example;


import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Unit test for simple App.
 */
public class NewProductTest extends BaseTest {

    @Test
    public void newProduct() {
        driver.navigate()
                .to("http://localhost:8055/litecart/admin/?category_id=0&app=catalog&doc=edit_product");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.navigate()
                .to("http://localhost:8055/litecart/admin/?app=catalog&doc=catalog");
        int before = driver.findElements(
                By.xpath("//table[@class='dataTable']/tbody/tr[@class='row']")).size();
        driver.navigate()
                .to("http://localhost:8055/litecart/admin/?category_id=0&app=catalog&doc=edit_product");

        driver.findElement(By.xpath("//div[contains(@id, 'tab-general')]/table/tbody/tr[1]/td//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys("Boomer" + Keys.TAB);
        List<WebElement> categories = driver
                .findElements(By.xpath("//input[@name='categories[]']"));
        categories.get(1).click();
        categories.get(2).click();
        var selectCategory = new Select(driver.findElement(By.xpath("//select[@name='default_category_id']")));
        selectCategory.selectByIndex(2);
        driver.findElements(By.xpath("//input[@name='product_groups[]']")).get(0).click();

        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("10"+ Keys.TAB);
        var selectQuantity = new Select(driver.findElement(By.xpath("//select[@name='quantity_unit_id']")));
        selectQuantity.selectByIndex(1);
        var selectStatus = new Select(driver.findElement(By.xpath("//select[@name='delivery_status_id']")));
        selectStatus.selectByIndex(1);
        var selectSoldOut = new Select(driver.findElement(By.xpath("//select[@name='sold_out_status_id']")));
        selectSoldOut.selectByIndex(2);
        driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys("C:\\Users\\ruaabcn\\IdeaProjects\\Selenium\\src\\test\\resource\\patric.jpg");
        driver.findElement(By.xpath("//input[@name='date_valid_from']")).sendKeys("2022-01-01");
        driver.findElement(By.xpath("//input[@name='date_valid_to']")).sendKeys("2022-10-01");

        driver.findElement(By.xpath("//div[@class='tabs']/ul/li[2]/a")).click();

        var selectManu = new Select(driver.findElement(By.xpath("//select[@name='manufacturer_id']")));
        selectManu.selectByIndex(0);
        var selectSupplier = new Select(driver.findElement(By.xpath("//select[@name='supplier_id']")));
        selectSupplier.selectByIndex(0);
        driver.findElement(By.xpath("//input[@name='keywords']")).sendKeys("Patrick");
        driver.findElement(By.xpath("//input[@name='short_description[en]']")).sendKeys("The best star");
        driver.findElement(By.xpath("//div[@class='trumbowyg-editor']")).sendKeys("The best star in the world"+ Keys.TAB);
        driver.findElement(By.xpath("//input[@name='head_title[en]']")).sendKeys("Patrick"+ Keys.TAB);
        driver.findElement(By.xpath("//input[@name='meta_description[en]']")).sendKeys("Star"+ Keys.TAB);
        driver.findElement(By.xpath("//button[@name='save']")).click();

        driver.navigate()
                .to("http://localhost:8055/litecart/admin/?app=catalog&doc=catalog");
        int after = driver.findElements(
                By.xpath("//table[@class='dataTable']/tbody/tr[@class='row']")).size();
        System.out.println("before: "+ before +" after: "+ after );
    }
}

