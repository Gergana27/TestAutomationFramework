package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JiraNavigationMenu extends BaseJiraPage{
    //Locators
    private final By createButton = By.cssSelector("[data-testid='create-button-wrapper']");

    public JiraNavigationMenu() {
        super("/");
    }

    //Actions
    public void clickOnCreateButtonTCreateIssue() {
        WebElement createButtonElement = driver().findElement(createButton);
        createButtonElement.click();
    }
}
