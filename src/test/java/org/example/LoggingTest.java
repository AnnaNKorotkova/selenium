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
        driver.navigate()
                .to("http://localhost:8055/litecart//admin?app=catalog&doc=catalog&category_id=1");
        int k = 0;
        List<WebElement> elements = driver.findElements(
                By.cssSelector("td[id=content] table.dataTable tr.row"));
        for (int i = 1; i < elements.size(); i++) {
            decorated.findElements(
                    By.cssSelector(
                            "td[id=content] table.dataTable tr.row a:nth-child(" + i + ")"));
            decorated.manage().logs().getAvailableLogTypes();
            List<LogEntry> logEntries = decorated.manage().logs().get("browser").getAll();
            if (logEntries.size() > 0) {
                k++;
            }
        }
        System.out.println(k);
    }
}
