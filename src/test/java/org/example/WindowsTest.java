package org.example;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Unit test for simple App.
 */
public class WindowsTest extends BaseTest {

    @Test
    public void createAccount() {
        driver.navigate().to("http://localhost:8055/litecart/admin/");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");
        WebElement login = driver.findElement(By.name("login"));
        login.click();
        driver.navigate().to("http://localhost:8055/litecart/admin/?app=countries&doc=countries");

        driver.findElement(By.cssSelector("form[name=countries_form] table tbody tr:nth-child(2) td:nth-child(5) a")).click();
        String mainWindow = driver.getWindowHandle();
        List<WebElement> driverElements = driver.findElements(
                By.cssSelector("td[id=content] form a[target=_blank]"));
        for (int i=0; i<driverElements.size(); i++){
            Set<String> oldWindows = driver.getWindowHandles();
            driverElements.get(i).click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> windows = driver.getWindowHandles();
            driver.switchTo().window(newWindow(oldWindows, windows));
            driver.close();
            driver.switchTo().window(mainWindow);
        }
        driver.quit();
    }

    private String newWindow(Set<String> old, Set<String> now){
        for (String st: now) {
            if (!old.contains(st)){
                return st;
            }
        }
        throw new IllegalArgumentException();
    }
}
