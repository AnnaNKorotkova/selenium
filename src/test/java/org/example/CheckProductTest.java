package org.example;


import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckProductTest extends BaseTest {

    @Test
    public void checkProducts() {
        driver.navigate().to("http://localhost:8055/litecart/en/");
        List<WebElement> listElement = driver.findElements(
                By.cssSelector("div[id=box-campaigns] div.content ul li a.link"));
        for (int i = 0; i < listElement.size(); i++) {
            var mapFirstPage = new HashMap<String, String>();
            mapFirstPage.put("name",
                    listElement.get(i).findElement(By.cssSelector("div.name")).getText());

            mapFirstPage.put("sPrice",
                    listElement.get(i).findElement(By.cssSelector("div.price-wrapper s")).getText());

            mapFirstPage.put("strongPrice",
                    listElement.get(i).findElement(By.cssSelector("div.price-wrapper strong")).getText());

            String colorS = listElement.get(i).findElement(
                    By.cssSelector("div.price-wrapper s")).getCssValue("color");

            var color1 = getColorFromString(colorS);
            var colorSCheck = (color1.R == color1.G) && (color1.G == color1.B);

            String colorStrong = listElement.get(0).findElement(
                    By.cssSelector("div.price-wrapper strong")).getCssValue("color");
            var color2 = getColorFromString(colorStrong);
            var colorStrongCheck = (color2.G == 0) && (color2.B == 0);

            String cssValue = listElement.get(i).findElement(
                    By.cssSelector(
                            "div.price-wrapper s")).getCssValue("text-decoration-line");
            boolean equalsTextDecorationS = Objects.equals("line-through", cssValue);


            String cssValueFont = listElement.get(i).findElement(
                    By.cssSelector("div.price-wrapper strong")).getCssValue("font-weight");
            boolean equalsTextFontWeightStrong = cssValueFont
                    .equals("900");

            listElement.get(i).click();
            boolean c1 = mapFirstPage.get("name").equals(driver.findElement(
                    By.cssSelector("div[id=box-product] div h1.title")).getText());

            boolean c2 = mapFirstPage.get("sPrice").equals(driver.findElement(
                            By.cssSelector("div[id=box-product] div.content div.price-wrapper s"))
                    .getText());

            boolean c3 = mapFirstPage.get("strongPrice").equals(driver.findElement(
                            By.cssSelector("div[id=box-product] div.content div.price-wrapper strong"))
                    .getText());

            String colorS1 = driver.findElement(
                    By.cssSelector("body")).getCssValue("color");
            ColorRGB colorS1FromRGB = getColorFromString(colorS1);

            var colorSCheck1 = (colorS1FromRGB.R == colorS1FromRGB.B) && (colorS1FromRGB.B
                    == colorS1FromRGB.G);

            ColorRGB colorFromString = getColorFromString(colorS1);
            var colorStrongCheck1 = (colorFromString.B == 0) && (colorFromString.R == 0);

            String cssValue1 = driver.findElement(
                            By.cssSelector(
                                    "div[id=box-product] div.content div.information div.price-wrapper s"))
                    .getCssValue("text-decoration-line");
            boolean equalsTextDecorationS1 = cssValue1
                    .equals("line-through");
            String cssValueFont1 = driver.findElement(
                            By.cssSelector("strong[class=campaign-price]")).getCssValue("font-weight");
            boolean equalsTextFontWeightStrong1 = cssValueFont1
                    .equals("bold") ||cssValueFont1.equals("700") ;
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

    private ColorRGB getColorFromString(String color) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(color);
        int[] subColors = new int[3];
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            subColors[i++] = Integer.parseInt(group);
        }

        return new ColorRGB(subColors[0], subColors[1], subColors[2]);


    }

    static class ColorRGB {

        int R;
        int G;
        int B;

        public ColorRGB(int r, int g, int b) {
            R = r;
            G = g;
            B = b;
        }
    }
}

