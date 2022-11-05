package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckAlfabetZoneTest extends BaseTest {

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
                By.cssSelector("table[class=dataTable] tr"));
        int numberOfListElements = listElement.size();
        var listZone = new ArrayList<String>();
        for (int i = 2; i < numberOfListElements; i++) {
            List<WebElement> country = driver.findElements(
                    By.cssSelector(
                            "table[class=dataTable] tr:nth-child(" + i
                                    + ") td:nth-child(3) a"));
            if (country.size() > 0) {
                country.get(0).click();
            }
            List<WebElement> countryClick = driver.findElements(
                    By.cssSelector(
                            "table[class=dataTable] tr"));
            for (int j = 1; j < countryClick.size() + 1 + 1; j++) {
                List<WebElement> options = driver.findElements(
                        By.cssSelector(
                                "table[class=dataTable] tr:nth-child(" + j
                                        + ") td:nth-child(3) select option"));
                for (int n = 0; n < options.size(); n++) {
                    List<WebElement> elements = driver.findElements(
                            By.cssSelector(
                                    "table[class=dataTable] tr:nth-child(" + j
                                            + ") td:nth-child(3) select option:nth-child(" + n
                                            + ")"));
                    if (elements.size() > 0 && elements.get(0).isSelected()) {
                        if (!listZone.contains(elements.get(0).getText())) {
                            listZone.add(elements.get(0).getText());

                        }
                    }
                }
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
}

