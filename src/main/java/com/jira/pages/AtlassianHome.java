package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static testframework.core.BaseWebTest.driver;

public class AtlassianHome extends BaseJiraPage {
    //Locators
    private final By welcomeMessage = By.xpath("//div[@class='css-1ljhloz']//h1[@class='css-xtidjr']");
    private final By projectAppLocator = By.className("css-1celsnm");
    ;

    public AtlassianHome() {
        super("/");
    }

    //Action
    public String getWelcomeMessage() {
//        driverWait().until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
        WebElement welcomeElement = driver().findElement(welcomeMessage);
        return welcomeElement.getText();
    }

    public void navigateToProjectApp() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(projectAppLocator));
        WebElement jiraBtn = driver().findElements(projectAppLocator).stream().filter(e -> e.getText().equals("Jira")).
                findFirst().get();
        jiraBtn.click();
    }
}

