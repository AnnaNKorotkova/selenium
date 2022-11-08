package org.example;


import java.time.Duration;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Unit test for simple App.
 */
public class AccountTest extends BaseTest {

    @Test
    public void createAccount() {
        driver.navigate().to("http://localhost:8055/litecart/en/create_account");
        driver.findElement(
                        By.cssSelector(
                                "form[name=customer_form] table tr:nth-child(2) td:nth-child(1) input"))
                .sendKeys("test");

        driver.findElement(
                        By.cssSelector(
                                "form[name=customer_form] table tr:nth-child(2) td:nth-child(2) input"))
                .sendKeys("testovich");

        driver.findElement(
                        By.cssSelector(
                                "form[name=customer_form] table tr:nth-child(3) td:nth-child(1) input"))
                .sendKeys("Москва");

        driver.findElement(
                        By.cssSelector(
                                "form[name=customer_form] table tr:nth-child(4) td:nth-child(1) input"))
                .sendKeys("12345");

        driver.findElement(
                        By.cssSelector(
                                "form[name=customer_form] table tr:nth-child(4) td:nth-child(2) input"))
                .sendKeys("Москва");

        driver.findElement(By.cssSelector(
                        "form[name=customer_form] table tr:nth-child(5) td:nth-child(1) span.select2-selection__arrow"))
                .click();
        driver.findElement(By.cssSelector(
                "input[class=select2-search__field]")).sendKeys("United States" + Keys.ENTER);
        Random rand = new Random();
        int nextInt = rand.nextInt();
        driver.findElement(
                        By.cssSelector(
                                "form[name=customer_form] table tr:nth-child(6) td:nth-child(1) input"))
                .sendKeys("cheburashka_the_best" + nextInt
                        + "@mail.ru");
        driver.findElement(
                        By.cssSelector(
                                "form[name=customer_form] table tr:nth-child(6) td:nth-child(2) input"))
                .sendKeys(Keys.HOME + "+191501251325");
        driver.findElement(
                        By.cssSelector(
                                "form[name=customer_form] table tr:nth-child(8) td:nth-child(1) input"))
                .sendKeys("taburenka");
        driver.findElement(
                        By.cssSelector(
                                "form[name=customer_form] table tr:nth-child(8) td:nth-child(2) input"))
                .sendKeys("taburenka");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(
                By.cssSelector(
                        "button[name=create_account]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(
                By.xpath(
                        "//*[contains(text(), 'Logout')]")).click();
        driver.findElement(
                        By.cssSelector(
                                "input[name=email]"))
                .sendKeys("cheburashka_the_best" + nextInt + "@mail.ru");
        driver.findElement(
                By.cssSelector(
                        "input[name=password]")).sendKeys("taburenka");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(
                By.xpath(
                        "//*[contains(text(), 'Login')]")).click();
    }
}
