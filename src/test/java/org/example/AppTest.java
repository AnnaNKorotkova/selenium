package org.example;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

  @Test
  public void checkHeaders() {
    driver.navigate().to("http://localhost:8055/litecart/admin/");
    WebElement username = driver.findElement(By.name("username"));
    username.sendKeys("admin");
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("admin");
    WebElement login = driver.findElement(By.name("login"));
    login.click();
    driver.navigate().to("http://localhost:8055/litecart/admin/");
    List<WebElement> listElement = driver.findElements(By.cssSelector("ul[id=box-apps-menu] li"));
    int numberOfListElements = listElement.size();
    int k = 0;
    for (int i = 0; i < numberOfListElements-1; i++){
      List<WebElement> menu= driver.findElements(By.cssSelector("ul[id=box-apps-menu] li"));
      menu.get(i).click();
      if(isElementPresent(driver, By.cssSelector("td[id=content] h1"))){
        k++;
      }
    }
    System.out.println(k);
  }
  boolean isElementPresent(WebDriver driver, By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
