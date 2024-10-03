package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage extends BaseSauceDemoPage {
    public ShoppingCartPage() {
        super("/cart.html");
    }
    // Locators
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By inventoryItems = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    // Actions
    public void clickShoppingCartLink() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
        cartLink.click();
    }

    public List<WebElement> getShoppingCartItems() {
        return driver().findElements(inventoryItems);
    }

    public void clickCheckout(){
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}