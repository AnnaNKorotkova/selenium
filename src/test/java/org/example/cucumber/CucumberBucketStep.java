package org.example.cucumber;

import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberBucketStep extends CucumberBaseTest implements En {

    public CucumberBucketStep(){
        Given("^open list products$", () -> {
            app.openProducts();
        });
        And("^count order is (\\d+)$", (Integer integer) -> {
            assertEquals(integer, app.checkElementsIntoCart());
        });
        When("^add product (\\d+)$", (Integer integer) -> {
            app.addFirstProductToCart(integer);
        });
        When("enter to card", () -> {
            app.enterToCart();
        });
        And("^checkout$", () -> {
            app.enterToCart();
        });
        When("^remove all elements$", () -> {
            app.removeAllProduct();
        });
    }
}
