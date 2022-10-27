package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

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
                var listZone = new ArrayList<String>();
                for (int j = 2; j < elements.size(); j++) {
                    List<WebElement> countryZone = driver.findElements(
                            By.cssSelector(
                                    "table[id=table-zones] tr:nth-child(" + j
                                            + ") td:nth-child(3)"));
                    if (countryZone.size() > 0) {
                        listZone.add(countryZone.get(0).getText());
                    }
                }
                int t = 0;
                var sortedListTimeZone = new ArrayList<>(listZone);
                sortedListTimeZone.sort(String::compareToIgnoreCase);
                for (int n = 0; n < listZone.size(); n++) {
                    if (!listZone.get(n).equals(sortedListTimeZone.get(n))) {
                        t++;
                    }
                }
                System.out.println(t);
                driver.navigate()
                        .to("http://localhost:8055/litecart/admin/?app=countries&doc=countries");
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
                        listZone.add(elements.get(0).getText());
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


    @Test
    public void checkSticker() {
        driver.navigate().to("http://localhost:8055/litecart/en/rubber-ducks-c-1/");
        int k = 0;
        List<WebElement> listElement = driver.findElements(
                By.cssSelector("div[class=content] li.product"));
        for (int i = 0; i < listElement.size(); i++) {
            if (!isElementPresent(driver, By.cssSelector(
                    "div[class=content] li.product:nth-child(" + i + ") div.sticker"))) {
                k++;
            }
        }
        System.out.println(k);
    }

    @Test
    public void checkProducts() {
        driver.navigate().to("http://localhost:8055/litecart/en/");
        List<WebElement> listElement = driver.findElements(
                By.cssSelector("div[id=box-campaigns] div.content ul li a.link"));
        for (int i = 1; i < listElement.size()+1; i++) {
        var mapFirstPage = new HashMap<String, String>();
            List<WebElement> elements = driver.findElements(
                    By.cssSelector(
                            "div[id=box-campaigns] div.content ul li a.link:nth-child(" + i + ")"));
            if(elements.size()>0){
                mapFirstPage.put("name",driver.findElement(
                        By.cssSelector(
                                "div[id=box-campaigns] div.content ul li a.link:nth-child(" + i + ") div.name")).getText());
                mapFirstPage.put("sPrice",driver.findElement(
                        By.cssSelector(
                                "div[id=box-campaigns] div.content ul li a.link:nth-child(" + i + ") div.price-wrapper s")).getText());
                String colorS = driver.findElement(
                        By.cssSelector(
                                "div[id=box-campaigns] div.content ul li a.link:nth-child(" + i
                                        + ") div.price-wrapper s")).getCssValue("color");
                var colorSCheck = Objects.equals(colorS, "rgb(119, 119, 119)");
                mapFirstPage.put("strongPrice",driver.findElement(
                        By.cssSelector(
                                "div[id=box-campaigns] div.content ul li a.link:nth-child(" + i + ") div.price-wrapper strong")).getText());
                String colorStrong = driver.findElement(
                        By.cssSelector(
                                "div[id=box-campaigns] div.content ul li a.link:nth-child(" + i
                                        + ") div.price-wrapper strong")).getCssValue("color");
                var colorStrongCheck = Objects.equals(colorStrong, "rgb(204, 0, 0)");

                String cssValue = driver.findElement(
                        By.cssSelector(
                                "div[id=box-campaigns] div.content ul li a.link:nth-child(" + i
                                        + ") div.price-wrapper s")).getCssValue("text-decoration");
                boolean equalsTextDecorationS = cssValue
                        .equals("line-through rgb(119, 119, 119)");
                String cssValueFont = driver.findElement(
                        By.cssSelector(
                                "div[id=box-campaigns] div.content ul li a.link:nth-child(" + i
                                        + ") div.price-wrapper strong")).getCssValue("font-weight");
                boolean equalsTextFontWeightStrong = cssValueFont
                        .equals("900");

                driver.findElements(
                        By.cssSelector(
                                "div[id=box-campaigns] div.content ul li a.link:nth-child(" + i + ")")).get(0).click();
                boolean c1 = mapFirstPage.get("name").equals(driver.findElement(
                        By.cssSelector("div[id=box-product] div h1.title")).getText());

                boolean c2 = mapFirstPage.get("sPrice").equals(driver.findElement(
                        By.cssSelector("div[id=box-product] div.content div.price-wrapper s")).getText());

                boolean c3 = mapFirstPage.get("strongPrice").equals(driver.findElement(
                        By.cssSelector("div[id=box-product] div.content div.price-wrapper strong")).getText());

                String colorS1 = driver.findElement(
                        By.cssSelector(
                                "body")).getCssValue("color");
                var colorSCheck1 = Objects.equals(colorS1, "rgb(102, 102, 102)");

                String colorStrong1 = driver.findElement(
                        By.cssSelector("div[id=box-product] div.content div.information div.price-wrapper strong")).getCssValue("color");
                var colorStrongCheck1 = Objects.equals(colorStrong1, "rgb(204, 0, 0)");

                String cssValue1 = driver.findElement(
                        By.cssSelector(
                                "div[id=box-product] div.content div.information div.price-wrapper s")).getCssValue("text-decoration");
                boolean equalsTextDecorationS1 = cssValue1
                        .equals("line-through rgb(102, 102, 102)");
                String cssValueFont1 = driver.findElement(
                        By.cssSelector(
                                "div[id=box-product] div.content div.information div.price-wrapper strong")).getCssValue("font-weight");
                boolean equalsTextFontWeightStrong1 = cssValueFont1
                        .equals("700");
                System.out.println("Check color in main page: " + colorSCheck);
                System.out.println("Check sale color in main page: " + colorStrongCheck);
                System.out.println("Check text decoration: " + equalsTextDecorationS);
                System.out.println("Check front: " + equalsTextFontWeightStrong);
                System.out.println("Check color in product page: " + colorSCheck1);
                System.out.println("Check color in product page: " + colorStrongCheck1);
                System.out.println("Check name: " + c1);
                System.out.println("Check price: " + c2);
                System.out.println("Check sale price: " + c3);
                System.out.println("Check text decoration product: " + equalsTextDecorationS1);
                System.out.println("Check font product: " + equalsTextFontWeightStrong1);
            }
        }
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
