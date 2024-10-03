package saucedemotests.web;

import com.saucedemo.pages.InventoryPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saucedemotests.core.SauceDemoBaseWebTest;
import saucedemotests.enums.TestData;

public class ProductsTests extends SauceDemoBaseWebTest {
    public final String BACKPACK_TITLE = "Sauce Labs Backpack";
    public final String SHIRT_TITLE = "Sauce Labs Bolt T-Shirt";

    @BeforeEach
    public void beforeTest(){
        // Authenticate with Standard user
        loginPage.navigate();
        loginPage.submitLoginForm(TestData.STANDARD_USER_USERNAME.getValue(), TestData.STANDARD_USER_PASSWORD.getValue());
        inventoryPage.waitForPageTitle();
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart(){
        // Add products to shopping cart
        inventoryPage.addProductsByTitle(BACKPACK_TITLE);

        // Go to shopping cart
        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        Assertions.assertEquals(1, shoppingCartPage.getShoppingCartItems().size(), "Item count in cart should be 1");
        Assertions.assertTrue(shoppingCartPage.getShoppingCartItems().stream()
                .anyMatch(item -> item.getText().equals(BACKPACK_TITLE)), "Backpack should be in the cart");

    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {
       // Add products to shopping cart
        inventoryPage.addProductsByTitle(BACKPACK_TITLE);

        // Click on shopping cart link to go to cart page
        shoppingCartPage.clickShoppingCartLink();

        // Assert that the shopping cart has 1 item
        Assertions.assertEquals(1, shoppingCartPage.getShoppingCartItems().size(), "Shopping cart should have 1 item");

        // Go to checkout
        shoppingCartPage.clickCheckout();

        // Fill form with shipping details
        checkoutYourInformationPage.fillShippingDetails("John", "Doe", "12345");
        checkoutYourInformationPage.clickContinue();

        // Assert Cart Items number on the checkout overview page
        Assertions.assertEquals(1, checkoutOverviewPage.getShoppingCartItems().size(), "Checkout should have 1 item");

        // Calculate expected total cost
        String totalLabelText = checkoutOverviewPage.getTotalLabelText().replace("Total: ", "").replace("$", "").trim();
        double totalCost = Double.parseDouble(totalLabelText);

        double expectedTotalCost = 32.39;
        Assertions.assertEquals(expectedTotalCost, totalCost, "Total cost should match expected value");

    }
    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        inventoryPage.addProductsByTitle(BACKPACK_TITLE,SHIRT_TITLE);
        inventoryPage.clickShoppingCartLink();

        // Go to Billing Info
        shoppingCartPage.clickCheckout();
        checkoutYourInformationPage.fillShippingDetails("John", "Doe", "12345");
        checkoutYourInformationPage.clickContinue();

        // Complete Order
        checkoutOverviewPage.clickFinish();

        // Assert Shopping cart is empty
        Assertions.assertEquals(0, shoppingCartPage.getShoppingCartItems().size(), "Shopping cart should be empty after completing the order");
    }
    }
