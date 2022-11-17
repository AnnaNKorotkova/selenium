package org.example;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

public class LoggingTest extends BaseTest {

    @Test
    public void loggingTest() {
        driver.navigate().to("http://localhost:8055/litecart/admin/");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");
        WebElement login = driver.findElement(By.name("login"));
        login.click();
        decorated.navigate()
                .to("http://localhost:8055/litecart//admin?app=catalog&doc=catalog&category_id=1");
        int k = 0;
        List<WebElement> elementsList = decorated.findElements(
                By.xpath("//td[@id='content']/form/table[@class='dataTable']/tbody/tr[@class='row']/td[3]/a"));
        for (int i = 1; i < elementsList.size(); i++) {
            List<WebElement> elements = decorated.findElements(
                    By.xpath("//td[@id='content']/form/table[@class='dataTable']/tbody/tr[@class='row']/td[3]/a"));
            elements.get(i).click();
            decorated.manage().logs().getAvailableLogTypes();
            List<LogEntry> logEntries = decorated.manage().logs().get("browser").getAll();
            if (logEntries.size() > 0) {
                k++;
                for (int j = 0; j < logEntries.size(); j++){
                    System.out.println(logEntries.get(j).getLevel()+": "+ logEntries.get(j).getMessage());
                }
            }
            decorated.navigate().back();
        }
        System.out.println(k);
    }
}
