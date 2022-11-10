package org.example.applicationtest.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BucketTest extends TestBase {

    @Test
    void addIntoBucketTest() {
        app.openProducts();
        int checkElementBeforeAdding = app.checkElementsIntoCart();
        for (int i = 0; i < 3; i++) {
            app.addFirstProductToCart(i);
        }
        int checkElementAfterAdding = app.checkElementsIntoCart();
        app.enterToCart();
        app.removeAllProduct();
        Assertions.assertEquals(0, checkElementBeforeAdding);
        Assertions.assertEquals(3, checkElementAfterAdding);
        Assertions.assertEquals(0,  app.getAllProductsIntoCart().size());
    }
}
