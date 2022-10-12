package org.example;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest {

  @Test
  public void myFirstTest() {
    driver.navigate().to("http://www.google.com");
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("webdriver");
    searchBox.sendKeys(Keys.ENTER);
  }

  @Test
  public void loginTest() {
    driver.navigate().to("http://localhost:8055/litecart/admin/");
    WebElement username = driver.findElement(By.name("username"));
    username.sendKeys("user");
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("password");
    WebElement login = driver.findElement(By.name("login"));
    login.click();
  }
}
