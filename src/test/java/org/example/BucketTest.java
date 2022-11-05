package org.example;


import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Unit test for simple App.
 */
public class BucketTest extends BaseTest {

    @Test
    public void bucketTest() {
        driver.navigate().to("http://localhost:8055/litecart/en/");
        List<WebElement> elements = driver.findElements(
                By.xpath("//div[@class='content']/ul/li/a[@title='Green Duck'][1]"));
        elements.get(0).click();

        driver.findElement(
                By.xpath("//button[@name='add_cart_product']")).click();

        int count = Integer.parseInt(driver.findElement(
                By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());

        isElementNotPresent(driver, count);
        count = Integer.parseInt(driver.findElement(
                By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());

        driver.navigate().to("http://localhost:8055/litecart/en/");
        List<WebElement> elementsSecond = driver.findElements(
                By.xpath("//div[@class='content']/ul/li/a[@title='Green Duck'][1]"));
        elementsSecond.get(0).click();
        driver.findElement(
                By.xpath("//button[@name='add_cart_product']")).click();
        isElementNotPresent(driver, count);

        count = Integer.parseInt(driver.findElement(
                By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());

        driver.navigate().to("http://localhost:8055/litecart/en/");
        List<WebElement> elementsThird = driver.findElements(
                By.xpath("//div[@class='content']/ul/li/a[@title='Green Duck'][1]"));
        elementsThird.get(0).click();
        driver.findElement(
                By.xpath("//button[@name='add_cart_product']")).click();
        isElementNotPresent(driver, count);

        count = Integer.parseInt(driver.findElement(
                By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());

        driver.findElement(
                By.xpath("//div[@id='cart']/a[@class='link']")).click();
        List<WebElement> elementList = driver.findElements(
                By.xpath("//button[@name='remove_cart_item']"));
        for (int i = 0; i < elementList.size(); i++) {
            elementList.get(i).click();
        }
        driver.findElement(
                By.xpath("//p/a")).click();
        int beforeDelete = Integer.parseInt(driver.findElement(
                By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());
        System.out.println(count);
        System.out.println(beforeDelete);
    }

    void isElementNotPresent(WebDriver driver, int count) {
        while (Integer.parseInt(driver.findElement(
                By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText()) <= count) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }
}
