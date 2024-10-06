package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static testframework.core.BaseWebTest.driver;

public class JiraNavigationMenu {
    //Locators
    private final By createButton = By.cssSelector("[data-testid='create-button-wrapper']");

    //Actions
    public void clickOnCreateButtonTCreateIssue() {
        WebElement createButtonElement = driver().findElement(createButton);
        createButtonElement.click();
    }
}
