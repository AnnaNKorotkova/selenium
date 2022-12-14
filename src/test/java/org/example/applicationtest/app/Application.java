package org.example.applicationtest.app;

import java.time.Duration;
import java.util.List;
import org.example.applicationtest.pages.BucketPage;
import org.example.applicationtest.pages.CartElementBlock;
import org.example.applicationtest.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

    private final WebDriver driver;

    private final BucketPage bucketPage;
    private final CartElementBlock cartElementBlock;
    private final ProductPage productPage;

    public Application() {
        driver = new ChromeDriver();
        bucketPage = new BucketPage(driver);
        cartElementBlock = new CartElementBlock(driver);
        productPage = new ProductPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void openProducts() {
        productPage.open();
    }

    public void addFirstProductToCart(int number) {
        productPage.open();
        productPage.products.get(0).click();
        int count = Integer.parseInt(cartElementBlock.countProducts.getText());
        if (productPage.select.size() != 0) {
            productPage.selectSize(productPage.select.get(0));
        }
        productPage.addProduct.click();
        while (count != number) {
            count = Integer.parseInt(cartElementBlock.countProducts.getText());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public int checkElementsIntoCart() {
        return Integer.parseInt(cartElementBlock.countProducts.getText());
    }

    public void enterToCart() {
        cartElementBlock.chechout.click();
    }

    public void removeAllProduct() {
        List<WebElement> listProducts = bucketPage.listProducts;
        int count = listProducts.size();
        for (int i = 0; i < count; i++) {
            bucketPage.removeOrder.click();
            bucketPage.refreshBucket();
        }
    }
}
