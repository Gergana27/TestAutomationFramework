package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AtlassianLoginPage extends BaseJiraPage {
    public AtlassianLoginPage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    //Locators
    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-submit");


    public void submitLogin(String username, String password) {

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        WebElement usernameInput = driver().findElement(usernameLocator);
        usernameInput.sendKeys(username);

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        WebElement continueButton = driver().findElement(loginButtonLocator);
        continueButton.click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        WebElement passwordInput = driver().findElement(passwordLocator);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver().findElement(loginButtonLocator);
        loginButton.click();
    }
}
