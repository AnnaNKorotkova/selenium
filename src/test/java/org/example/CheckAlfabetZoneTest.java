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
                By.xpath("//table[@class='dataTable']/tbody/tr[@class='row']/td[3]/a"));
        int numberOfListElements = listElement.size();
        var map = new HashMap<String , Integer>();
        for (int i = 0; i < numberOfListElements; i++) {
        var listZone = new ArrayList<String>();
            String nameCountry = driver.findElements(
                            By.xpath("//table[@class='dataTable']/tbody/tr[@class='row']/td[3]/a")).get(i)
                    .getText();
            driver.findElements(
                    By.xpath("//table[@class='dataTable']/tbody/tr[@class='row']/td[3]/a")).get(i).click();
            List<WebElement> zones = driver.findElements(By.xpath(
                    "//table[@class='dataTable']/tbody/tr/td[3]/select/option[@selected='selected']"));
            for (int j=0; j<zones.size(); j++){
                listZone.add(zones.get(j).getText());
            }
            int k=0;
            var sortedList = new ArrayList<>(listZone);
            sortedList.sort(String::compareToIgnoreCase);
            for (int n = 0; n < listZone.size(); n++) {
                if (!listZone.get(n).equals(sortedList.get(n))) {
                    k++;
                }
            }
            map.put(nameCountry, k);
            driver.navigate().to("http://localhost:8055/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
        System.out.println(map);
    }
}

