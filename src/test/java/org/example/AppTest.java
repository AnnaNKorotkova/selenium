package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
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
        List<WebElement> listElement = driver.findElements(
                By.cssSelector("ul[id=box-apps-menu] li"));
        int numberOfListElements = listElement.size();
        int k = 0;
        for (int i = 0; i < numberOfListElements; i++) {
            List<WebElement> menu = driver.findElements(By.cssSelector("ul[id=box-apps-menu] li"));
            menu.get(i).click();
            if (isElementPresent(driver, By.cssSelector("ul[class=docs] li"))) {
                List<WebElement> secondmenutList = driver.findElements(
                        By.cssSelector("ul[class=docs] li"));
                for (int j = 0; j < secondmenutList.size(); j++) {
                    List<WebElement> subMenu = driver.findElements(
                            By.cssSelector("ul[class=docs] li"));
                    subMenu.get(j).click();
                    if (isElementPresent(driver, By.cssSelector("td[id=content] h1"))) {
                        k++;
                    }
                }
            }
            driver.navigate().to("http://localhost:8055/litecart/admin/");
        }
        System.out.println(k);
    }


    @Test
    public void alfabetCountry() {
        driver.navigate().to("http://localhost:8055/litecart/admin/");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");
        WebElement login = driver.findElement(By.name("login"));
        login.click();
        driver.navigate().to("http://localhost:8055/litecart/admin/?app=countries&doc=countries");

        List<WebElement> listElement = driver.findElements(
                By.cssSelector("table[class=dataTable] tr"));
        int numberOfListElements = listElement.size();
        var listCountry = new ArrayList<String>();
        var listZone = new ArrayList<String>();
        for (int i = 2; i < numberOfListElements; i++) {
            List<WebElement> country = driver.findElements(
                    By.cssSelector(
                            "table[class=dataTable] tr:nth-child(" + i + ") td:nth-child(5)"));
            if (country.size() > 0) {
                listCountry.add(country.get(0).getText());
            }
            List<WebElement> count = driver.findElements(
                    By.cssSelector(
                            "table[class=dataTable] tr:nth-child(" + i + ") td:nth-child(6)"));
            if (count.size() > 0 && !count.get(0).getText().equals("0")) {
                WebElement element = driver.findElement(
                        By.cssSelector(
                                "table[class=dataTable] tr:nth-child(" + i
                                        + ") td:nth-child(5) a"));
                element.click();
                List<WebElement> elements = driver.findElements(
                        By.cssSelector("table[id=table-zones] tr"));
                for (int j = 2; j < elements.size(); j++) {
                    List<WebElement> countryZone = driver.findElements(
                            By.cssSelector(
                                    "table[id=table-zones] tr:nth-child(" + i
                                            + ") td:nth-child(3)"));
                    if (countryZone.size() > 0) {
                        listZone.add(country.get(0).getText());
                    }
                }
                int t = 0;
                var sortedListTimeZone = new ArrayList<>(listCountry);
                sortedListTimeZone.sort(String::compareToIgnoreCase);
                for (int n = 0; n < listZone.size(); n++) {
                    if (!listZone.get(n).equals(sortedListTimeZone.get(n))) {
                        t++;
                    }
                }
                System.out.println(t);
                driver.navigate().to("http://localhost:8055/litecart/admin/?app=countries&doc=countries");
            }
        }
        int k = 0;
        var sortedList = new ArrayList<>(listCountry);
        sortedList.sort(String::compareToIgnoreCase);
        for (int i = 0; i < listCountry.size(); i++) {
            if (!listCountry.get(i).equals(sortedList.get(i))) {
                k++;
            }
        }
        System.out.println(k);
    }

    @Test
    public void alfabetTimeZone() {
        driver.navigate().to("http://localhost:8055/litecart/admin/");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");
        WebElement login = driver.findElement(By.name("login"));
        login.click();
        driver.navigate().to("http://localhost:8055/litecart/admin/?app=geo_zones&doc=geo_zones");

        List<WebElement> listElement = driver.findElements(
                By.cssSelector("form[name=geo_zones_form] table tr"));
        int numberOfListElements = listElement.size();
        var listZone = new ArrayList<String>();
        for (int i = 2; i < numberOfListElements; i++) {
            List<WebElement> country = driver.findElements(
                    By.cssSelector(
                            "form[name=geo_zones_form] table tr:nth-child(" + i + ") td:nth-child(3)"));
            if(country.size()>0){
                listZone.add(country.get(0).getText());
            }

        }
        int k = 0;
        var sortedList = new ArrayList<>(listZone);
        sortedList.sort(String::compareToIgnoreCase);
        for (int i = 0; i < listZone.size(); i++) {
            if (!listZone.get(i).equals(sortedList.get(i))) {
                k++;
            }
        }
        System.out.println(k);
    }


    @Test
    public void checkSticker() {
        driver.navigate().to("http://localhost:8055/litecart/en/rubber-ducks-c-1/");
        int k = 0;
        List<WebElement> listElement = driver.findElements(
                By.cssSelector("div[class=content] ul.listing-wrapper.products a.link"));
        for (int i = 0; i < listElement.size(); i++) {
            if (isElementPresent(driver, By.cssSelector("div[class|=sticker]"))) {
                k++;
            }
        }
        Assertions.assertEquals(k, listElement.size());
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElements(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
