package org.example;


import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

        while (driver.findElements(By.xpath("//ul[@class='shortcuts']/li/a")).size() != 0) {
            driver.findElement(By.xpath("//button[@name='remove_cart_item']")).click();
            driver.navigate().refresh();
        }

        int afterDelete = driver.findElements(By.xpath("//ul[@class='shortcuts']/li/a")).size();
        System.out.println(beforeDelete == 3);
        System.out.println(afterDelete == 0);
    }

    void addElement(int number) {
        driver.navigate().to("http://localhost:8055/litecart/en/");
        driver.findElements(By.xpath("//div[@class ='content']/div[@class='box']/div/ul/li/a[@class='link']")).get(0)
                .click();

        List<WebElement> select = driver.findElements(By.xpath("//select"));
        if (select.size() > 0) {
            var size = new Select(select.get(0));
            size.selectByIndex(1);
        }

        driver.findElement(
                By.xpath("//button[@name='add_cart_product']")).click();
        int parseInt = Integer.parseInt(driver.findElement(
                By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());
        while (parseInt != number + 1) {
            parseInt = Integer.parseInt(driver.findElement(
                    By.xpath("//div[@id='cart']/a/span[@class='quantity']")).getText());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }
}
