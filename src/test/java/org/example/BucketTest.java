package org.example;


import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Unit test for simple App.
 */
public class BucketTest extends BaseTest {

    @Test
    public void bucketTest() {
        for (int i = 0; i < 3; i++) {
            addElement(i);
        }

        int beforeDelete = Integer.parseInt(driver.findElement(
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
        int afterDelete = Integer.parseInt(driver.findElement(
                By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());
        System.out.println(beforeDelete == 3);
        System.out.println(afterDelete == 0);
    }

    void addElement(int number) {
        driver.navigate().to("http://localhost:8055/litecart/en/rubber-ducks-c-1/");
        driver.findElements(By.xpath("//div[@class ='content']/ul[2]/li/a[@class='link']")).get(0)
                .click();
        driver.findElement(
                By.xpath("//button[@name='add_cart_product']")).click();
        int parseInt = Integer.parseInt(driver.findElement(
                By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());
        ;
        while (parseInt != number + 1) {
            parseInt = Integer.parseInt(driver.findElement(
                    By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }
}
