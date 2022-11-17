package org.example.applicationtest.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(0, checkElementBeforeAdding);
        assertEquals(3, checkElementAfterAdding);
        assertEquals(0, app.getAllProductsIntoCart().size());
    }
}
